package Telas;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import Componentes.CriaButton;
import Componentes.CriaField;
import Componentes.CriaLabel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelaLogin extends JFrame implements ActionListener, KeyListener{
	private static final long serialVersionUID = -2619511002441617106L;
	private JLabel jlblogin, jlbsenha;
	private JTextField jtflogin, jtfSenha;;
	private JButton btnlogin;
	private CriaField cf = new CriaField();
	private CriaLabel cl = new CriaLabel();
	private CriaButton cb = new CriaButton();

	public TelaLogin() {
		Container tela = getContentPane();
		setTitle("Celulares - Login");
		setLayout(null);

		jlblogin = cl.criarLabel("Login", 100, 45, 100, 50, jlblogin, tela);
		jlbsenha = cl.criarLabel("Senha", 100, 100, 100, 50, jlbsenha, tela);
		jtflogin = cf.criarTextField(150, 60, 100, 24, jtflogin, tela, this);
		jtfSenha = cf.criarPasswordField(150, 115, 100, 24, jtfSenha, tela);
		btnlogin = cb.criarBotao("Entrar", 100, 160, 150, 30, btnlogin, tela, this);

		setSize(1000, 650);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		TelaLogin app = new TelaLogin();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	
}