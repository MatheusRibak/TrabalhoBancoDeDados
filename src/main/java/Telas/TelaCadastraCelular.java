package Telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Componentes.CriaButton;
import Componentes.CriaField;
import Componentes.CriaLabel;
import Componentes.CriaPanel;
import Componentes.FieldEmUpper;

public class TelaCadastraCelular extends JFrame implements ActionListener, KeyListener{
	private CriaLabel cl = new CriaLabel();
	private CriaPanel cp = new CriaPanel();
	private CriaField cf = new CriaField();
	private CriaButton cb = new CriaButton();
	private FieldEmUpper fu = new FieldEmUpper();
	private JLabel jlbCadDescricao, jlbCadImei, jlbCadModelo, jlbCadEmpresa, jlbCadCamera, jlbCadMemRam, jlbCadMemInt,
		jlbCadQtdChips, jlbCadValor;
	private JTextField jtfCadDescricao, jtfCadImei, jtfCadModelo, jtfCadEmpresa, jtfCadCamera, jtfCadMemRam, jtfCadMemInt,
		jtfCadQtdChips, jtfCadValor;
	private JPanel jpnCadCelular;
	private JLabel jlbTituloFrame;
	private Container tela;
	private static String titulo = "Cadastro de Celular";
	
	public TelaCadastraCelular() {
		tela = getContentPane();
		setTitle("Celulares - Cadastro de Celular");
		setLayout(null);

		jlbTituloFrame = cl.criarTitulo(titulo, jlbTituloFrame, tela);
		
		criarCamposCadastrado();
		
		tela.setBackground(Color.white);
		setSize(800, 495);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void criarCamposCadastrado() {
		jlbCadDescricao = cl.criarLabelParaPanel("Descrição:", 5, 15, 90, 24, jlbCadDescricao, tela);
		jlbCadImei = cl.criarLabelParaPanel("IMEI:", 15, 39, 80, 24, jlbCadImei, tela);
		jlbCadModelo = cl.criarLabelParaPanel("Modelo:", 15, 63, 80, 24, jlbCadModelo, tela);
		jlbCadEmpresa = cl.criarLabelParaPanel("Empresa:", 100, 63, 160, 24, jlbCadEmpresa, tela);
		jlbCadCamera = cl.criarLabelParaPanel("Câmera:", 15, 87, 80, 24, jlbCadCamera, tela);
		jlbCadMemInt = cl.criarLabelParaPanel("Memória Interna:", 170, 87, 150, 24, jlbCadMemInt, tela);
		jlbCadMemRam = cl.criarLabelParaPanel("Memória RAM:", 385, 87, 130, 24, jlbCadMemRam, tela);
		
		jtfCadDescricao = cf.criarTextField(100, 15, 600, 24, jtfCadDescricao, tela, this);
		jtfCadImei = cf.criarTextField(100, 39, 80, 24, jtfCadImei, tela, this);
		jtfCadModelo = cf.criarTextField(100, 63, 80, 24, jtfCadModelo, tela, this);
		jtfCadEmpresa = cf.criarTextField(265, 63, 435, 24, jtfCadEmpresa, tela, this);
		jtfCadCamera = cf.criarTextField(100, 87, 80, 24, jtfCadCamera, tela, this);
		jtfCadMemInt = cf.criarTextField(325, 87, 80, 24, jtfCadMemInt, tela, this);	
		jtfCadMemRam = cf.criarTextField(520, 87, 80, 24, jtfCadMemRam, tela, this);	
		
		jpnCadCelular = cp.criarPanelSemTitulo(0, 70, 800, 300, jpnCadCelular, true, tela);
		jpnCadCelular.add(jlbCadDescricao);
		jpnCadCelular.add(jlbCadImei);
		jpnCadCelular.add(jlbCadModelo);	
		jpnCadCelular.add(jlbCadEmpresa);
		jpnCadCelular.add(jlbCadCamera);	
		jpnCadCelular.add(jlbCadMemInt);	
		jpnCadCelular.add(jlbCadMemRam);
		jpnCadCelular.add(jtfCadDescricao);
		jpnCadCelular.add(jtfCadImei);
		jpnCadCelular.add(jtfCadModelo);	
		jpnCadCelular.add(jtfCadEmpresa);	
		jpnCadCelular.add(jtfCadCamera);	
		jpnCadCelular.add(jtfCadMemInt);	
		jpnCadCelular.add(jtfCadMemRam);
		
		
	}

	public static void main(String[] args) {
		new TelaCadastraCelular();
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
