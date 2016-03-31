package Telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import metodos.ListarCelular;
import metodos.ListarVenda;
import Componentes.CriaButton;
import Componentes.CriaField;
import Componentes.CriaLabel;
import Componentes.CriaPanel;
import Componentes.CriaTabela;
import Componentes.FieldEmUpper;

public class TelaProcurarVenda extends JFrame implements ActionListener, KeyListener{
	private static final long serialVersionUID = -9172268853152388303L;
	private JLabel jlbTituloFrame, jlbProCliente, jlbProData, jlbProVendedor, jlbProCodNF, jlbOpcOpcoes;
	private JPanel jpnCamposBusca, jpnOpcoes;
	private CriaLabel cl = new CriaLabel();
	private CriaPanel cp = new CriaPanel();
	private CriaField cf = new CriaField();
	private CriaButton cb = new CriaButton();
	private CriaTabela ct = new CriaTabela();
	FieldEmUpper fu = new FieldEmUpper();
	private JTextField jtfProCliente, jtfProData, jtfProVendedor, jtfProCodNF;
	private JButton jbtProcurar, jbtNovo, jbtExcluir, jbtAlterar;
	private Container tela;
	private JTable jtbCelulares;
	private DefaultTableModel dtmCelulares = new DefaultTableModel();
	private static String titulo = "Procurar por venda";
	private JButton jbtInfData;
	
	public TelaProcurarVenda() {
		tela = getContentPane();
		setTitle("M&M Celulares - Procurar venda");
		setLayout(null);
		
		jlbTituloFrame = cl.criarTitulo(titulo, jlbTituloFrame, tela);
		criarCamposBusca();
		criarTabela();
		criarOpcoesResultado();
				
		tela.setBackground(Color.white);
		setSize(800, 587);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void criarOpcoesResultado() {
		jlbOpcOpcoes = cl.criarParaPanelCenter("Opções", 360, 5, 80, 24, jlbOpcOpcoes, tela);
		jbtAlterar = cb.criarBotao("Alterar", 300, 33, 100, 24, jbtAlterar, tela, this);
		jbtExcluir = cb.criarBotao("Excluir", 400, 33, 100, 24, jbtExcluir, tela, this);
		
		jpnOpcoes = cp.criarPanelSemTitulo(0, 470, 800, 90, jpnOpcoes, true, tela);
		jpnOpcoes.add(jlbOpcOpcoes);
		jpnOpcoes.add(jbtAlterar);
		jpnOpcoes.add(jbtExcluir);
		
	}

	private void criarTabela() {
		ArrayList<String> colunas = new ArrayList<String>();
		colunas.add("ID");
		colunas.add("CLIENTE");
		colunas.add("VENDEDOR");
		colunas.add("VALOR(R$)");
		
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
		jlbProCliente = cl.criarLabelParaPanel("Cliente:", 5, 15, 90, 24, jlbProCliente, tela);
		//jlbProData = cl.criarLabelParaPanel("Data:", 15, 39, 80, 24, jlbProData, tela);
		jlbProVendedor = cl.criarLabelParaPanel("Vendedor:", 5, 39, 90, 24, jlbProVendedor, tela);
		//jlbProCodNF = cl.criarLabelParaPanel("Cód. NF:", 15, 63, 80, 24, jlbProCodNF, tela);
		
		jtfProCliente = cf.criarTextField(100, 15, 600, 24, jtfProCliente, tela, this);
		//jtfProData = cf.criarMaskFieldDate(100, 39, 80, 24, jtfProData, tela);
		jtfProVendedor = cf.criarTextField(100, 39, 600, 24, jtfProVendedor, tela, this);
		//jtfProCodNF = cf.criarTextField(100, 63, 80, 24, jtfProCodNF, tela, this);
		
		jbtNovo = cb.criarBotao("Novo", 500, 63, 100, 24, jbtNovo, tela, this);
		jbtProcurar = cb.criarBotao("Procurar", 600, 63, 100, 24, jbtProcurar, tela, this);
		
		//String MENSAGEM_DATA = "Use o formato Mês/Dia/Ano ao inserir datas. Exemplo: 12/29/97";
		//jbtInfData = cb.criarBotaoAjuda(MENSAGEM_DATA, "?", 180, 39, 49, 24, jbtInfData, tela, this);		
		
		jpnCamposBusca = cp.criarPanelSemTitulo(0, 70, 800, 100, jpnCamposBusca, true, tela);
		jpnCamposBusca.add(jlbProCliente);
		jpnCamposBusca.add(jtfProCliente);
		//jpnCamposBusca.add(jlbProData);
		//jpnCamposBusca.add(jtfProData);
		//jpnCamposBusca.add(jbtInfData);
		jpnCamposBusca.add(jlbProVendedor);
		jpnCamposBusca.add(jtfProVendedor);
		//jpnCamposBusca.add(jlbProCodNF);
		//jpnCamposBusca.add(jtfProCodNF);
		jpnCamposBusca.add(jbtNovo);
		jpnCamposBusca.add(jbtProcurar);
		
	}

	public static void main(String[] args) {
		new TelaProcurarVenda();
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == jbtProcurar){
			ListarVenda lv = new ListarVenda();
			lv.listar(dtmCelulares);	
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getComponent() == jtfProCliente){
			if(e.getSource() == jtfProCliente){
				fu.transformar(jtfProCliente);
			}
		}
		if(e.getComponent() == jtfProVendedor){
			if(e.getSource() == jtfProVendedor){
				fu.transformar(jtfProVendedor);
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	
}
