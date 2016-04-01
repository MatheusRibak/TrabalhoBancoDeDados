package Telas;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import Componentes.CriaButton;
import Componentes.CriaField;
import Componentes.CriaLabel;
import Componentes.CriaPanel;
import DAO.GenericDAO;
import Model.Usuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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
		setTitle("M&M Celulares - Tela de login");
		setLayout(null);
		
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
		jtflogin.setText("convidado");
		jtfSenha = cf.criarPasswordField(125, 175, 200, 24, jtfSenha, tela);
		jtfSenha.setText("123456");
		btnlogin = cb.criarBotao("Entrar", 245, 200, 80, 24, btnlogin, tela, this);
		
		jpnLogin = new JPanel();
		jpnLogin.setLayout(null);
		jpnLogin.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		jpnLogin.setBackground(Color.white);
		jpnLogin.setBounds(10, 10, 450, 300);
		jpnLogin.setVisible(true);

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

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnlogin){
			Boolean usuarioCorreto = false;
			if((jtflogin.getText().equals("convidado")) && jtfSenha.getText().equals("123456")){
				usuarioCorreto = true;
			}
			
			GenericDAO dao = new GenericDAO();
			ArrayList<Usuario> usuarios = dao.getDao().listaQualquer(Usuario.class);
			for(Usuario usuario : usuarios){
				if((usuario.getLogin().equals(jtflogin.getText())) && usuario.getSenha().equals(jtfSenha.getText())){
					usuarioCorreto = true;
				}
			}
			if (usuarioCorreto) {
				TelaInicial.getTlInicial().setVisible(true);;
				this.dispose();
			}else{
				JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!", "Falha para autenticar", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		TelaLogin app = new TelaLogin();
	}
}