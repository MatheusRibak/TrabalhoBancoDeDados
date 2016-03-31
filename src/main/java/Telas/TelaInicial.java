package Telas;

import java.awt.Container;
import java.awt.Menu;
import java.awt.MenuBar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import lombok.Getter;
import lombok.Setter;
import Componentes.CriaButton;
import Componentes.CriaField;
import Componentes.CriaLabel;
import Componentes.CriaMenu;

@Getter
@Setter
public class TelaInicial extends JFrame {
	private static final long serialVersionUID = -5502135091121637861L;
	private CriaField cf = new CriaField();
	private CriaLabel cl = new CriaLabel();
	private CriaButton cb = new CriaButton();
	private CriaMenu cm = new CriaMenu();
	private JMenuBar jmnBar;
	private JMenu jmnCadastro, jmnProcurar;
	private JMenuItem jmiCadCliente, jmiCadCelular, jmiCadLoja, jmiCadVenda,
			jmiCadVendedor;
	private JMenuItem jmiProCliente, jmiProCelular, jmiProLoja, jmiProVenda,
			jmiProVendedor;

	public TelaInicial() {
		Container tela = getContentPane();
		setTitle("Celulares - Inicial");
		setLayout(null);

		criarBarra();

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

	private void criarBarra() {
		jmnCadastro = new JMenu("Cadastro");

		jmiCadCliente = cm.criarMenuItem(jmiCadCliente, "Cliente", jmnCadastro);
		jmiCadCelular = cm.criarMenuItem(jmiCadCelular, "Celular", jmnCadastro);
		jmiCadVendedor = cm.criarMenuItem(jmiCadVendedor, "Vendedor",
				jmnCadastro);
		jmiCadVenda = cm.criarMenuItem(jmiCadVenda, "Venda", jmnCadastro);
		

		jmnProcurar = new JMenu("Procurar");

		jmiCadCliente = cm.criarMenuItem(jmiProCliente, "Cliente", jmnProcurar);
		jmiCadCelular = cm.criarMenuItem(jmiProCelular, "Celular", jmnProcurar);
		jmiCadVendedor = cm.criarMenuItem(jmiProLoja, "Vendedor", jmnProcurar);
		jmiCadVenda = cm.criarMenuItem(jmiProVenda, "Venda", jmnProcurar);
		
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		new TelaInicial();
	}
}
