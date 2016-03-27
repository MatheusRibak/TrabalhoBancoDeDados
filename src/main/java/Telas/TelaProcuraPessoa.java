package Telas;

import java.awt.Container;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import metodos.ProcurarPessoa;
import Componentes.CriaButton;
import Componentes.CriaField;
import Componentes.CriaLabel;
import Componentes.CriaPanel;
import Componentes.CriaRadioButton;
import Componentes.CriaTabela;

public class TelaProcuraPessoa extends JFrame{
	private static final long serialVersionUID = -9172268853152388303L;
	private JLabel jlbTituloFrame, jlbProNome, jlbProRG, jlbProTelefone, jlbProTipo;
	private JPanel jpnCamposBusca, jpnTable;
	private CriaLabel cl = new CriaLabel();
	private CriaPanel cp = new CriaPanel();
	private CriaField cf = new CriaField();
	private CriaButton cb = new CriaButton();
	private CriaTabela ct = new CriaTabela();
	private CriaRadioButton crb = new CriaRadioButton();
	private JTextField jtfProNome, jtfProRG, jtfProTelefone;
	private JRadioButton jrbCliente, jrbVendedor, jrbTodos;
	private JButton jbtProcurar, jbtNovo;
	private ButtonGroup btnProGrupo;
	private Container tela;
	private JTable jtbPessoas;
	private DefaultTableModel dtmPessoas = new DefaultTableModel();
	
	public TelaProcuraPessoa() {
		tela = getContentPane();
		setTitle("Celulares - Procurar pessoa");
		setLayout(null);
		
		jlbTituloFrame = cl.criarTitulo("Procurar por pessoa", jlbTituloFrame, tela);
		criarCamposBusca();
		criarTabela();
				
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void criarTabela() {
		ArrayList<String> colunas = new ArrayList<String>();
		colunas.add("ID");
		colunas.add("Nome");
		colunas.add("RG");
		
		dtmPessoas = ct.criarTableImoveis(jtbPessoas, tela, dtmPessoas, colunas, 0, 170, 800, 400);
		ProcurarPessoa pp = new ProcurarPessoa();
		pp.procurarTodos(dtmPessoas);	
		
	}

	private void criarCamposBusca() {
		jlbProNome = cl.criarLabelParaPanel("Nome:", 15, 15, 80, 24, jlbProNome, tela);
		jlbProRG = cl.criarLabelParaPanel("RG:", 15, 39, 80, 24, jlbProRG, tela);
		jlbProTelefone = cl.criarLabelParaPanel("Telefone:", 365, 39, 80, 24, jlbProTelefone, tela);
		jlbProTipo = cl.criarLabelParaPanel("Tipo:", 15, 63, 80, 24, jlbProTipo, tela);
		
		jtfProNome = cf.criarTextField(100, 15, 600, 24, jtfProNome, tela);
		jtfProRG = cf.criarTextField(100, 39, 250, 24, jtfProNome, tela);
		jtfProTelefone = cf.criarTextField(450, 39, 250, 24, jtfProNome, tela);
		
		jrbCliente = crb.criarRadioButton("Cliente", 100, 63, 70, 24, jrbCliente, tela);
		jrbVendedor = crb.criarRadioButton("Vendedor", 175, 63, 80, 24, jrbVendedor, tela);
		jrbTodos = crb.criarRadioButton("Ambos", 260, 63, 80, 24, jrbTodos, tela);
		jrbTodos.setSelected(true);
		btnProGrupo = new ButtonGroup();
		btnProGrupo.add(jrbCliente);
		btnProGrupo.add(jrbVendedor);
		btnProGrupo.add(jrbTodos);
		
		jbtNovo = cb.criarBotao("Novo", 500, 63, 100, 24, jbtNovo, tela);
		jbtProcurar = cb.criarBotao("Procurar", 600, 63, 100, 24, jbtProcurar, tela);
		
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

	public static void main(String[] args) {
		new TelaProcuraPessoa();
	}
}
