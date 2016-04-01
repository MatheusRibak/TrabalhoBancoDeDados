package Telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import metodos.ListarCliente;
import metodos.ListarUsuario;
import metodos.ProcurarCliente;
import metodos.ProcurarUsuario;
import Componentes.CriaButton;
import Componentes.CriaField;
import Componentes.CriaLabel;
import Componentes.CriaPanel;
import Componentes.CriaRadioButton;
import Componentes.CriaTabela;
import Componentes.FieldEmUpper;
import Model.Cliente;
import Model.Usuario;

public class TelaSelecionarVendedor extends JInternalFrame implements ActionListener, KeyListener{
	private static final long serialVersionUID = -9172268853152388303L;
	private JLabel jlbTituloFrame, jlbProNome, jlbProRG, jlbProTelefone, jlbProTipo, jlbOpcOpcoes;
	private JPanel jpnCamposBusca, jpnOpcoes;
	private CriaLabel cl = new CriaLabel();
	private CriaPanel cp = new CriaPanel();
	private CriaField cf = new CriaField();
	private CriaButton cb = new CriaButton();
	private CriaTabela ct = new CriaTabela();
	private FieldEmUpper fu = new FieldEmUpper();
	private CriaRadioButton crb = new CriaRadioButton();
	private JTextField jtfProNome, jtfProRG, jtfProTelefone;
	private JRadioButton jrbCliente, jrbVendedor, jrbTodos;
	private JButton jbtProcurar, jbtSelecionar, jbtNovo;
	private ButtonGroup btnProGrupo;
	private Container tela;
	private JTable jtbPessoas = new JTable();
	private DefaultTableModel dtmPessoas = new DefaultTableModel();
	private static String titulo = "Selecionar vendedor";
	
	public TelaSelecionarVendedor() {
		tela = getContentPane();
		setTitle("M&M Celulares - Venda - Selecionar");
		setLayout(null);
		
		jlbTituloFrame = cl.criarTitulo(titulo, jlbTituloFrame, tela);
		criarCamposBusca();
		criarTabela();
		criarOpcoesResultado();

		jlbProTelefone.setVisible(false);
		jtfProTelefone.setVisible(false);
		jlbProTipo.setVisible(false);
		jrbCliente.setVisible(false);
		jrbTodos.setVisible(false);
		jrbVendedor.setVisible(false);
				
		tela.setBackground(Color.white);
		setSize(800, 587);
		setResizable(false);
		setVisible(true);
		setClosable(true);
	}
	
	private void criarOpcoesResultado() {
		jlbOpcOpcoes = cl.criarParaPanelCenter("Opções", 360, 5, 80, 24, jlbOpcOpcoes, tela);
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
		colunas.add("Nome");
		colunas.add("RG");
		colunas.add("TEL. CELULAR");
		colunas.add("TIPO");

		jtbPessoas = new JTable();
		tela.add(jtbPessoas);
		dtmPessoas = new DefaultTableModel();
		for (String colNome : colunas) {
			dtmPessoas.addColumn(colNome);
		}
		jtbPessoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtbPessoas.setModel(dtmPessoas);
		JScrollPane jsp = new JScrollPane(jtbPessoas);
		jsp.setBounds(0, 170, 800, 300);
		jsp.setVisible(true);
		tela.add(jsp);	
	}

	private void criarCamposBusca() {
		jlbProNome = cl.criarLabelParaPanel("Nome:", 15, 15, 80, 24, jlbProNome, tela);
		jlbProRG = cl.criarLabelParaPanel("RG:", 15, 39, 80, 24, jlbProRG, tela);
		jlbProTelefone = cl.criarLabelParaPanel("Telefone:", 365, 39, 80, 24, jlbProTelefone, tela);
		jlbProTipo = cl.criarLabelParaPanel("Tipo:", 15, 63, 80, 24, jlbProTipo, tela);
		
		jtfProNome = cf.criarTextField(100, 15, 600, 24, jtfProNome, tela, this);
		jtfProRG = cf.criarTextField(100, 39, 250, 24, jtfProNome, tela, this);
		jtfProTelefone = cf.criarTextField(450, 39, 250, 24, jtfProNome, tela, this);
		
		jrbCliente = crb.criarRadioButton("Cliente", 100, 63, 70, 24, jrbCliente, tela);
		jrbVendedor = crb.criarRadioButton("Vendedor", 175, 63, 80, 24, jrbVendedor, tela);
		jrbTodos = crb.criarRadioButton("Ambos", 260, 63, 80, 24, jrbTodos, tela);
		jrbTodos.setSelected(true);
		btnProGrupo = new ButtonGroup();
		btnProGrupo.add(jrbCliente);
		btnProGrupo.add(jrbVendedor);
		btnProGrupo.add(jrbTodos);
		
		jbtNovo = cb.criarBotao("Novo", 500, 63, 100, 24, jbtNovo, tela, this);
		jbtProcurar = cb.criarBotao("Procurar", 600, 63, 100, 24, jbtProcurar, tela, this);
		
		jpnCamposBusca = cp.criarPanelSemTitulo(0, 70, 800, 100, jpnCamposBusca, true, tela);
		jpnCamposBusca.add(jlbProNome);
		jpnCamposBusca.add(jtfProNome);
		jpnCamposBusca.add(jlbProRG);
		jpnCamposBusca.add(jtfProRG);
		jpnCamposBusca.add(jlbProTelefone);
		jpnCamposBusca.add(jtfProTelefone);
		jpnCamposBusca.add(jlbProTipo);
		jpnCamposBusca.add(jrbCliente);
		jpnCamposBusca.add(jrbVendedor);
		jpnCamposBusca.add(jrbTodos);
		jpnCamposBusca.add(jbtNovo);
		jpnCamposBusca.add(jbtProcurar);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getComponent() == jtfProNome){
			if(e.getSource() == jtfProNome){
				fu.transformar(jtfProNome);
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == jbtProcurar){
			ListarUsuario lv = new ListarUsuario();
			lv.listar(dtmPessoas, jtfProNome.getText(), jtfProRG.getText());	
		}
		if(evt.getSource() == jbtNovo){
			TelaInicial.getTlInicial().esconderTelas();
			TelaInicial.getTlInicial().getTlCadastrarPessoa().setVisible(true);
		}
		if(evt.getSource() == jbtSelecionar){
			String id = String.valueOf(dtmPessoas.getValueAt(jtbPessoas.getSelectedRow(), 0));
			ProcurarUsuario pu = new ProcurarUsuario();
			Usuario usuario = pu.procurar(id);
			TelaInicial.getTlInicial().getTlCadastrarVenda().popularVendedor(usuario);
			TelaInicial.getTlInicial().getTlSelecionarVendedor().setVisible(false);	
		}		
	}
	
	public static void main(String[] args) {
		new TelaSelecionarVendedor();
	}

}
