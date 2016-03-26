package Telas;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import Componentes.CriaField;
import Componentes.CriaLabel;

import java.awt.*;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class TelaLogin extends JFrame {
	private static final long serialVersionUID = -2619511002441617106L;
	private JTextField jtflogin;
	private JButton btnlogin;
	private JLabel jlblogin, jlbsenha;
	private JPasswordField Senha;
	private CriaField cf = new CriaField();
	private CriaLabel cl = new CriaLabel();

	public TelaLogin() {
		Container tela = getContentPane();
		setTitle("Nome Sistema - Login");
		setLayout(null);
		
		jlblogin = cl.criarLabel("Login", 100, 45, 100, 50, jlblogin);
		jlbsenha = new JLabel("Senha");
		btnlogin = new JButton("Login");
		jtflogin = new JTextField();
		Senha = new JPasswordField();
		jtflogin.setBounds(150, 60, 100, 25);
		Senha.setBounds(150, 115, 100, 25);
		jlblogin.setBounds(100, 45, 100, 50);
		jlbsenha.setBounds(100, 100, 100, 50);
		btnlogin.setBounds(100, 160, 150, 30);
		tela.add(jtflogin);
		tela.add(Senha);
		tela.add(jlblogin);
		tela.add(jlbsenha);
		tela.add(btnlogin);
		setSize(365, 285);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.white);
	}

	public static void main(String args[]) {
		TelaLogin app = new TelaLogin();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}