package Telas;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Componentes.CriaLabel;

public class TelaCadastroCliente extends JFrame{

	private static final long serialVersionUID = -4250909026834805108L;
	private JLabel jlbTituloFrame, jlbTituloIcone;
	private CriaLabel cl = new CriaLabel();
	
	
	public TelaCadastroCliente() {
		Container tela = getContentPane();
		setTitle("Celulares - Cadastro Cliente");
		setLayout(null);
		
		jlbTituloFrame = cl.criarTitulo("Cadastro de Cliente", jlbTituloFrame, tela);
		jlbTituloIcone = cl.criarTituloIcone(jlbTituloIcone, tela);
		jlbTituloIcone.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/resource/TelaCadastroCliente_novo.png")));
		
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new TelaCadastroCliente();
	}

}
