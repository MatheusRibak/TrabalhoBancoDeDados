package Telas;

import java.awt.Container;
import java.awt.Menu;
import java.awt.MenuBar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import lombok.Getter;
import lombok.Setter;
import Componentes.CriaButton;
import Componentes.CriaField;
import Componentes.CriaLabel;

@Getter @Setter
public class TelaInicial extends JFrame{
	private static final long serialVersionUID = -5502135091121637861L;
	private CriaField cf = new CriaField();
	private CriaLabel cl = new CriaLabel();
	private CriaButton cb = new CriaButton();
	private JMenuBar jmnBar;
	private JMenu jmnCliente;
	
	public TelaInicial(){
		Container tela = getContentPane();
		setTitle("Celulares - Inicial");
		setLayout(null);
		
		jmnCliente = new JMenu("Cadastro");
		
		jmnBar = new JMenuBar();
		jmnBar.setVisible(true);
		jmnBar.add(jmnCliente);
		
		setSize(365, 285);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setJMenuBar(jmnBar);
		
				
		
	}

	public static void main(String[] args) {
		new TelaInicial();
	}
}
