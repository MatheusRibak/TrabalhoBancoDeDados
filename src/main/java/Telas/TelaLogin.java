package Telas;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import Componentes.CriaButton;
import Componentes.CriaField;
import Componentes.CriaLabel;

import java.awt.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelaLogin extends JFrame {
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
		jtflogin = cf.criarTextField(150, 60, 100, 24, jtflogin, tela);
		jtfSenha = cf.criarPasswordField(150, 115, 100, 24, jtfSenha, tela);
		btnlogin = cb.criarBotao("Entrar", 100, 160, 150, 30, btnlogin, tela);

		setSize(365, 285);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		TelaLogin app = new TelaLogin();
	}
}