package Telas;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import Componentes.CriaButton;
import Componentes.CriaField;
import Componentes.CriaLabel;
import Componentes.CriaPanel;

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
	private CriaPanel cp = new CriaPanel();
	private JLabel jlbFundo, jlbIcon;
	private JPanel jpnLogin, jpnBackLogin;
	
	public TelaLogin() {
		Container tela = getContentPane();
		setTitle("Celulares - Login");
		setLayout(null);

		/* LOGIN LADO A LADO
		jlbIcon = cl.criarParaPanelLogin("", 21, 21, 64, 64, jlbIcon, tela);
		jlbIcon.setIcon(new ImageIcon(TelaLogin.class.getClass().getResource("/resource/social.png")));
		
		jlblogin = cl.criarParaPanelLogin("Login:", 125, 15, 100, 24, jlblogin, tela);
		jlblogin.setOpaque(true);
		jlblogin.setBackground(Color.white);
		jlblogin.setForeground(Color.black);
		jlbsenha = cl.criarParaPanelLogin("Senha:", 125, 40, 100, 24, jlbsenha, tela);
		jlbsenha.setOpaque(true);
		jlbsenha.setBackground(Color.white);
		jlbsenha.setForeground(Color.black);
		jtflogin = cf.criarTextField(225, 15, 100, 24, jtflogin, tela, this);
		jtfSenha = cf.criarPasswordField(225, 40, 100, 24, jtfSenha, tela);
		btnlogin = cb.criarBotao("Entrar", 250, 65, 75, 24, btnlogin, tela, this);
		
		jpnLogin = new JPanel();
		jpnLogin.setLayout(null);
		jpnLogin.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		//jpnLogin.setBackground(new Color(0,0,0,0));
		jpnLogin.setBounds(200, 200, 450, 105);
		jpnLogin.setVisible(true);
		tela.add(jpnLogin);

		jpnLogin.add(jlbIcon);
		jpnLogin.add(jlblogin);
		jpnLogin.add(jlbsenha);
		jpnLogin.add(jtflogin);
		jpnLogin.add(jtfSenha);
		jpnLogin.add(btnlogin);
		*/
		
		jlbIcon = cl.criarParaPanelLogin("", 193, 21, 64, 64, jlbIcon, tela);
		jlbIcon.setIcon(new ImageIcon(TelaLogin.class.getClass().getResource("/resource/social.png")));
		
		jlblogin = cl.criarParaPanelLogin("Login", 125, 100, 200, 24, jlblogin, tela);
		jlblogin.setOpaque(true);
		jlblogin.setBackground(Color.white);
		jlblogin.setForeground(Color.black);
		jlbsenha = cl.criarParaPanelLogin("Senha", 125, 150, 200, 24, jlbsenha, tela);
		jlbsenha.setOpaque(true);
		jlbsenha.setBackground(Color.white);
		jlbsenha.setForeground(Color.black);
		jtflogin = cf.criarTextField(125, 125, 200, 24, jtflogin, tela, this);
		jtfSenha = cf.criarPasswordField(125, 175, 200, 24, jtfSenha, tela);
		btnlogin = cb.criarBotao("Entrar", 245, 200, 80, 24, btnlogin, tela, this);
		
		jpnLogin = new JPanel();
		jpnLogin.setLayout(null);
		jpnLogin.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		//jpnLogin.setBorder(BorderFactory.createCompoundBorder(new EtchedBorder(), new LineBorder(Color.white)));
		jpnLogin.setBackground(Color.white);
		jpnLogin.setBounds(10, 10, 450, 300);
		jpnLogin.setVisible(true);
		//tela.add(jpnLogin);

		jpnLogin.add(jlbIcon);
		jpnLogin.add(jlblogin);
		jpnLogin.add(jlbsenha);
		jpnLogin.add(jtflogin);
		jpnLogin.add(jtfSenha);
		jpnLogin.add(btnlogin);
		
		jpnBackLogin = new JPanel();
		jpnBackLogin.setLayout(null);
		jpnBackLogin.setBorder(BorderFactory.createCompoundBorder(new EtchedBorder(), new LineBorder(Color.white)));
		jpnBackLogin.setBackground(new Color(0,0,0,0));
		jpnBackLogin.setBounds(265, 165, 470, 320);
		jpnBackLogin.setVisible(true);
		tela.add(jpnBackLogin);
		
		jpnBackLogin.add(jpnLogin);
		
		jlbFundo = cl.criarLabel(null, 0, 0, 1000, 650, jlbFundo, tela);
		jlbFundo.setIcon(new ImageIcon(TelaLogin.class.getClass().getResource("/resource/sunset_sky.jpg")));

		setSize(1000, 650);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
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