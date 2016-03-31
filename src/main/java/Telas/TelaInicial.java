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
	private TelaCadastraCelular tlCadastraCelular = new TelaCadastraCelular();
	private ArrayList<JInternalFrame> listaInternalFrame = new ArrayList<>();

	public TelaInicial() {
		tela = getContentPane();
		setTitle("Celulares - Inicial");
		setLayout(null);

		criarBarra();
		
		listaInternalFrame.add(tlCadastraCelular);
		
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
	
	public static TelaInicial getTlInicial(){
		if(tlInicial == null){
			tlInicial = new TelaInicial();
		}
		return tlInicial;
	}
	
	private void posicionaFrames(List<JInternalFrame> frames) {
		for (JInternalFrame fr : frames) {
			fr.setLocation((super.getWidth() / 2) - fr.getWidth() / 2,
					((super.getHeight() / 2) - fr.getHeight() / 2) - 50);
			getContentPane().add(fr);
			fr.setVisible(false);
		}
	}
	
	public void esconderTelas() {
		tlCadastraCelular.setVisible(false);
		posicionaFrames(listaInternalFrame);
	}

	private void criarBarra() {
		jmnCadastro = new JMenu("Cadastro |");
		jmiCadPessoa = cm.criarMenuItem(jmiCadPessoa, "Pessoa física", jmnCadastro, this);
		jmnCadastro.add(new JSeparator());
		jmiCadCelular = cm.criarMenuItem(jmiCadCelular, "Celular", jmnCadastro, this);
		jmiCadCelular.addActionListener(this);
		jmnCadastro.add(new JSeparator());
		jmiCadVenda = cm.criarMenuItem(jmiCadVenda, "Venda", jmnCadastro, this);
		
		jmnProcurar = new JMenu("Procurar");
		jmiProPessoa = cm.criarMenuItem(jmiProPessoa, "Pessoa Física", jmnProcurar, this);
		jmnProcurar.add(new JSeparator());
		jmiProCelular = cm.criarMenuItem(jmiProCelular, "Celular", jmnProcurar, this);
		jmnProcurar.add(new JSeparator());
		jmiProVenda = cm.criarMenuItem(jmiProVenda, "Venda", jmnProcurar, this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jmiCadCelular){
			esconderTelas();
			tlCadastraCelular.setVisible(true);;
		}
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, 
												IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		tlInicial.getTlInicial();
		tlInicial.setVisible(true);
	}
}
