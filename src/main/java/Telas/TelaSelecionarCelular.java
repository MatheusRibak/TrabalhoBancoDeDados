package Telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import metodos.ListarCelular;
import metodos.ProcurarCelular;
import Componentes.CriaButton;
import Componentes.CriaField;
import Componentes.CriaLabel;
import Componentes.CriaPanel;
import Componentes.FieldEmUpper;
import Model.Celular;

public class TelaSelecionarCelular extends JInternalFrame implements KeyListener, ActionListener{
	private static final long serialVersionUID = -9172268853152388303L;
	private JLabel jlbTituloFrame, jlbProDescricao, jlbProModelo, jlbProMarca, jlbProImei, jlbOpcOpcoes;
	private JPanel jpnCamposBusca, jpnOpcoes;
	private CriaLabel cl = new CriaLabel();
	private CriaPanel cp = new CriaPanel();
	private CriaField cf = new CriaField();
	private CriaButton cb = new CriaButton();
	FieldEmUpper fu = new FieldEmUpper();
	private JTextField jtfProDescricao, jtfProModelo, jtfProMarca, jtfProImei;
	private JButton jbtProcurar, jbtNovo, jbtSelecionar;
	private Container tela;
	private JTable jtbCelulares;
	private DefaultTableModel dtmCelulares = new DefaultTableModel();
	private static String titulo = "Selecionar celular";
	
	public TelaSelecionarCelular() {
		tela = getContentPane();
		setTitle("M&M Celulares - Vender celular - Selecionar");
		setLayout(null);
		
		jlbTituloFrame = cl.criarTitulo(titulo, jlbTituloFrame, tela);
		criarCamposBusca();
		criarTabela();
		criarOpcoesResultado();
				
		tela.setBackground(Color.white);
		setSize(800, 587);
		setResizable(false);
		setVisible(true);
		setClosable(true);
	}
	
	private void criarOpcoesResultado() {
		jlbOpcOpcoes = cl.criarParaPanelCenter("Op��es", 360, 5, 80, 24, jlbOpcOpcoes, tela);
		jbtSelecionar = cb.criarBotao("Selecionar", 300, 33, 200, 24, jbtSelecionar, tela, this);
		//jbtExcluir = cb.criarBotao("Excluir", 400, 33, 100, 24, jbtExcluir, tela, this);
		
		jpnOpcoes = cp.criarPanelSemTitulo(0, 470, 800, 90, jpnOpcoes, true, tela);
		jpnOpcoes.add(jlbOpcOpcoes);
		jpnOpcoes.add(jbtSelecionar);
		//jpnOpcoes.add(jbtExcluir);
		
	}

	private void criarTabela() {
		ArrayList<String> colunas = new ArrayList<String>();
		colunas.add("ID");
		colunas.add("MODELO");
		colunas.add("EMPRESA");
		colunas.add("IMEI");
		
		jtbCelulares = new JTable();
		tela.add(jtbCelulares);
		dtmCelulares = new DefaultTableModel();
		for (String colNome : colunas) {
			dtmCelulares.addColumn(colNome);
		}
		jtbCelulares.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtbCelulares.setModel(dtmCelulares);
		JScrollPane jsp = new JScrollPane(jtbCelulares);
		jsp.setBounds(0, 170, 800, 300);
		jsp.setVisible(true);
		tela.add(jsp);	
	}

	private void criarCamposBusca() {
		jlbProDescricao = cl.criarLabelParaPanel("Descri��o:", 5, 15, 90, 24, jlbProDescricao, tela);
		jlbProModelo = cl.criarLabelParaPanel("Modelo:", 15, 39, 80, 24, jlbProModelo, tela);
		jlbProMarca = cl.criarLabelParaPanel("Marca:", 365, 39, 80, 24, jlbProMarca, tela);
		jlbProImei = cl.criarLabelParaPanel("IMEI:", 15, 63, 80, 24, jlbProImei, tela);
		
		jtfProDescricao = cf.criarTextField(100, 15, 600, 24, jtfProDescricao, tela, this);
		jtfProModelo = cf.criarTextField(100, 39, 250, 24, jtfProModelo, tela, this);
		jtfProMarca = cf.criarTextField(450, 39, 250, 24, jtfProMarca, tela, this);
		jtfProImei = cf.criarTextField(100, 63, 200, 24, jtfProImei, tela, this);
		
		//jbtNovo = cb.criarBotao("Novo", 500, 63, 100, 24, jbtNovo, tela, this);
		jbtProcurar = cb.criarBotao("Procurar", 600, 63, 100, 24, jbtProcurar, tela, this);
		
		jpnCamposBusca = cp.criarPanelSemTitulo(0, 70, 800, 100, jpnCamposBusca, true, tela);
		jpnCamposBusca.add(jlbProDescricao);
		jpnCamposBusca.add(jtfProDescricao);
		jpnCamposBusca.add(jlbProModelo);
		jpnCamposBusca.add(jtfProModelo);
		jpnCamposBusca.add(jlbProMarca);
		jpnCamposBusca.add(jtfProMarca);
		jpnCamposBusca.add(jlbProImei);
		jpnCamposBusca.add(jtfProImei);
		//jpnCamposBusca.add(jbtNovo);
		jpnCamposBusca.add(jbtProcurar);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getComponent() == jtfProDescricao){
			if(e.getSource() == jtfProDescricao){
				fu.transformar(jtfProDescricao);
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == jbtProcurar){
			ListarCelular lc = new ListarCelular();
			lc.listar(dtmCelulares, jtfProDescricao.getText(), jtfProModelo.getText(), jtfProImei.getText(), jtfProMarca.getText());	
		}
		if(evt.getSource() == jbtSelecionar){
			String id = String.valueOf(dtmCelulares.getValueAt(jtbCelulares.getSelectedRow(), 0));
			ProcurarCelular pc = new ProcurarCelular();
			Celular celular = pc.procurar(id);
			//TelaInicial.getTlInicial().esconderTelas();
			//TelaInicial.getTlInicial().getTlAlterarCelular().setVisible(true);
			//TelaInicial.getTlInicial().getTlAlterarCelular().popularCampos(celular);
			TelaInicial.getTlInicial().getTlCadastrarVenda().popularCelular(celular);
			TelaInicial.getTlInicial().getTlSelecionarCelular().setVisible(false);
		}
		if(evt.getSource() == jbtNovo){
			TelaInicial.getTlInicial().esconderTelas();
			TelaInicial.getTlInicial().getTlCadastraCelular().setVisible(true);
		}
	}

	
	public static void main(String[] args) {
		new TelaSelecionarCelular();
	}
}