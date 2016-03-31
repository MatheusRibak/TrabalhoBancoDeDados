package Telas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import lombok.Getter;
import lombok.Setter;
import Componentes.CriaButton;
import Componentes.CriaField;
import Componentes.CriaLabel;
import Componentes.CriaMenu;
import DAO.GenericDAO;

@Getter @Setter
public class TelaInicial extends JFrame implements ActionListener{
	private static final long serialVersionUID = -5502135091121637861L;
	private CriaField cf = new CriaField();
	private CriaLabel cl = new CriaLabel();
	private CriaButton cb = new CriaButton();
	private CriaMenu cm = new CriaMenu();
	private JMenuBar jmnBar;
	private JMenu jmnCadastro, jmnProcurar;
	private JMenuItem jmiCadCelular, jmiCadVenda, jmiCadPessoa;
	private JMenuItem jmiProCelular, jmiProVenda, jmiProPessoa;
	private Container tela;
	private static TelaInicial tlInicial;
	private TelaCadastraPessoa tlCadastrarPessoa = new TelaCadastraPessoa();
	private TelaProcuraPessoa tlProcurarPessoa = new TelaProcuraPessoa();
	private TelaAlterarPessoa tlAlterarPessoa = new TelaAlterarPessoa();
	private TelaCadastraCelular tlCadastraCelular = new TelaCadastraCelular();
	private TelaProcurarCelular tlProcurarCelular = new TelaProcurarCelular();
	private TelaAlterarCelular tlAlterarCelular = new TelaAlterarCelular();
	private ArrayList<JInternalFrame> listaInternalFrame = new ArrayList<>();
	private GenericDAO dao = new GenericDAO();

	public static TelaInicial getTlInicial(){
		if(tlInicial == null){
			tlInicial = new TelaInicial();
		}
		return tlInicial;
	}
	
	public TelaInicial() {
		tela = getContentPane();
		setTitle("M&M Celulares - Tela inicial");
		setLayout(null);

		criarBarra();
		
		listaInternalFrame.add(tlCadastrarPessoa);
		listaInternalFrame.add(tlProcurarPessoa);
		listaInternalFrame.add(tlAlterarPessoa);
		listaInternalFrame.add(tlCadastraCelular);
		listaInternalFrame.add(tlProcurarCelular);
		listaInternalFrame.add(tlAlterarCelular);
		
		posicionaFrames(listaInternalFrame);
		jmnBar = new JMenuBar();
		jmnBar.setVisible(true);
		jmnBar.add(jmnCadastro);
		jmnBar.add(jmnProcurar);
		setJMenuBar(jmnBar);
		setSize(1200, 700);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void posicionaFrames(List<JInternalFrame> frames) {
		for (JInternalFrame fr : frames) {
			fr.setLocation((super.getWidth() / 2) - fr.getWidth() / 2,
					((super.getHeight() / 2) - fr.getHeight() / 2) - 50);
			getContentPane().add(fr);
			fr.setClosable(true);
			fr.setVisible(false);
		}
	}
	
	public void esconderTelas() {
		tlCadastraCelular.setVisible(false);
		posicionaFrames(listaInternalFrame);
	}

	private void criarBarra() {
		jmnCadastro = new JMenu("Cadastro |");
		jmiCadPessoa = cm.criarMenuItem(jmiCadPessoa, "Pessoa física", jmnCadastro);
		jmiCadPessoa.addActionListener(this);
		jmnCadastro.add(new JSeparator());
		jmiCadCelular = cm.criarMenuItem(jmiCadCelular, "Celular", jmnCadastro);
		jmiCadCelular.addActionListener(this);
		jmnCadastro.add(new JSeparator());
		jmiCadVenda = cm.criarMenuItem(jmiCadVenda, "Venda", jmnCadastro);
		jmiCadVenda.addActionListener(this);
		
		jmnProcurar = new JMenu("Procurar");
		jmiProPessoa = cm.criarMenuItem(jmiProPessoa, "Pessoa Física", jmnProcurar);
		jmiProPessoa.addActionListener(this);
		jmnProcurar.add(new JSeparator());
		jmiProCelular = cm.criarMenuItem(jmiProCelular, "Celular", jmnProcurar);
		jmiProCelular.addActionListener(this);
		jmnProcurar.add(new JSeparator());
		jmiProVenda = cm.criarMenuItem(jmiProVenda, "Venda", jmnProcurar);
		jmiProVenda.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jmiCadCelular){
			esconderTelas();
			tlCadastraCelular.setVisible(true);;
		}
		if(e.getSource() == jmiCadPessoa){
			esconderTelas();
			tlCadastrarPessoa.setVisible(true);;
		}	
		if(e.getSource() == jmiProPessoa){
			esconderTelas();
			tlProcurarPessoa.setVisible(true);
		}
		if(e.getSource() == jmiProCelular){
			esconderTelas();
			tlProcurarCelular.setVisible(true);
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, 
												IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		tlInicial.getTlInicial();
		tlInicial.setVisible(true);
	}
}
