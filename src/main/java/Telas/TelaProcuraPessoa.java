package Telas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import metodos.ListarPessoa;
import Componentes.CriaButton;
import Componentes.CriaField;
import Componentes.CriaLabel;
import Componentes.CriaPanel;
import Componentes.CriaRadioButton;
import Componentes.CriaTabela;
import Componentes.FieldEmUpper;

public class TelaProcuraPessoa extends JFrame implements ActionListener, KeyListener{
	private static final long serialVersionUID = -9172268853152388303L;
	private JLabel jlbTituloFrame, jlbProNome, jlbProRG, jlbProTelefone, jlbProTipo, jlbOpcOpcoes;
	private JPanel jpnCamposBusca, jpnOpcoes;
	private CriaLabel cl = new CriaLabel();
	private CriaPanel cp = new CriaPanel();
	private CriaField cf = new CriaField();
	private CriaButton cb = new CriaButton();
	private CriaTabela ct = new CriaTabela();
	FieldEmUpper fu = new FieldEmUpper();
	private CriaRadioButton crb = new CriaRadioButton();
	private JTextField jtfProNome, jtfProRG, jtfProTelefone;
	private JRadioButton jrbCliente, jrbVendedor, jrbTodos;
	private JButton jbtProcurar, jbtNovo, jbtExcluir, jbtAlterar;
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
		criarOpcoesResultado();
		
		/*jlbProRG.setVisible(false);
		jlbProTelefone.setVisible(false);
		jtfProRG.setVisible(false);
		jtfProTelefone.setVisible(false);*/
		jlbProTipo.setVisible(false);
		jrbCliente.setVisible(false);
		jrbTodos.setVisible(false);
		jrbVendedor.setVisible(false);
				
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
		colunas.add("Nome");
		colunas.add("RG");
		colunas.add("TEL. CELULAR");
		colunas.add("TIPO");
		
		dtmPessoas = ct.criarTableImoveis(jtbPessoas, tela, dtmPessoas, colunas, 0, 170, 800, 300);		
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

	public static void main(String[] args) {
		new TelaProcuraPessoa();
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == jbtProcurar){
			ListarPessoa lp = new ListarPessoa();
			lp.listar(dtmPessoas, jtfProNome.getText());	
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getComponent() == jtfProNome){
			if(e.getSource() == jtfProNome){
				//fu.transformar(jtfProNome);
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	
}
