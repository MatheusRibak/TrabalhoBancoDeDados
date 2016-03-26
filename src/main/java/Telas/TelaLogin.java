package Telas;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import java.awt.*;
import java.awt.event.*;

public class TelaLogin extends JFrame {
	JTextField jtflogin;
	JButton btnlogin;
	JLabel jlblogin, jlbsenha;

	JPasswordField Senha;

	public TelaLogin() {

		Container tela = getContentPane();
		setLayout(null);
		setTitle("Nome Sistema - Login");
		jlblogin = new JLabel("Login");
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