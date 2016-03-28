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
	private JLabel jlbCadDescricao, jlbCadImei, jlbCadModelo, jlbCadEmpresa, jlbCadCameraFrontal, jlbCadCameraTraseira,
		jlbCadMemRam, jlbCadMemInt, jlbCadQtdChips, jlbCadValor, jlbCadTipoChip, jlbCadTela;
	private JTextField jtfCadDescricao, jtfCadImei, jtfCadModelo, jtfCadEmpresa, jtfCadCameraFrontal, jtfCadCameraTraseira, 
		jtfCadMemRam, jtfCadMemInt, jtfCadQtdChips, jtfCadValor, jtfCadTipoChip, jtfCadTela;
	private JPanel jpnCadUnica, jpnCadAdj;
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
		
		jtfCadDescricao = cf.criarTextField(100, 15, 600, 24, jtfCadDescricao, tela, this);
		jtfCadImei = cf.criarTextField(100, 39, 80, 24, jtfCadImei, tela, this);
		jtfCadModelo = cf.criarTextField(100, 63, 80, 24, jtfCadModelo, tela, this);
		jtfCadEmpresa = cf.criarTextField(265, 63, 435, 24, jtfCadEmpresa, tela, this);
			
		jpnCadUnica = cp.criarPanelSemTitulo(0, 70, 800, 100, jpnCadUnica, true, tela);
		jpnCadUnica.add(jlbCadDescricao);
		jpnCadUnica.add(jlbCadImei);
		jpnCadUnica.add(jlbCadModelo);	
		jpnCadUnica.add(jlbCadEmpresa);
		jpnCadUnica.add(jtfCadDescricao);
		jpnCadUnica.add(jtfCadImei);
		jpnCadUnica.add(jtfCadModelo);	
		jpnCadUnica.add(jtfCadEmpresa);	
		
		jlbCadCameraFrontal = cl.criarLabelParaPanel("Câmera frontal:", 15, 15, 150, 24, jlbCadCameraFrontal, tela);
		jlbCadCameraTraseira = cl.criarLabelParaPanel("Câmera traseira:", 250, 15, 150, 24, jlbCadCameraTraseira, tela);
		jlbCadMemInt = cl.criarLabelParaPanel("Memória Interna:", 15, 39, 150, 24, jlbCadMemInt, tela);
		jlbCadMemRam = cl.criarLabelParaPanel("Memória RAM:", 270, 39, 130, 24, jlbCadMemRam, tela);
		jlbCadQtdChips = cl.criarLabelParaPanel("Quantidade de chips:", 5, 63, 160, 24, jlbCadQtdChips, tela);
		jlbCadTipoChip = cl.criarLabelParaPanel("Tipo de chip:", 270, 63, 130, 24, jlbCadTipoChip, tela);
		jlbCadTela = cl.criarLabelParaPanel("Tamanho da tela:", 15, 87, 150, 24, jlbCadTela, tela);
		
		jtfCadCameraFrontal = cf.criarTextField(175, 15, 80, 24, jtfCadCameraFrontal, tela, this);
		jtfCadCameraTraseira = cf.criarTextField(405, 15, 80, 24, jtfCadCameraTraseira, tela, this);
		jtfCadMemInt = cf.criarTextField(175, 39, 80, 24, jtfCadMemInt, tela, this);	
		jtfCadMemRam = cf.criarTextField(405, 39, 80, 24, jtfCadMemRam, tela, this);	
		jtfCadQtdChips = cf.criarTextField(175, 63, 80, 24, jtfCadQtdChips, tela, this);
		jtfCadTipoChip = cf.criarTextField(405, 64, 295, 24, jtfCadTipoChip, tela, this);
		jtfCadTela = cf.criarTextField(175, 87, 80, 24, jtfCadTela, tela, this);
		
		jpnCadAdj = cp.criarPanelSemTitulo(0, 170, 800, 150, jpnCadAdj, true, tela);
		jpnCadAdj.add(jlbCadCameraFrontal);	
		jpnCadAdj.add(jlbCadCameraTraseira);
		jpnCadAdj.add(jlbCadMemInt);	
		jpnCadAdj.add(jlbCadMemRam);
		jpnCadAdj.add(jlbCadQtdChips);
		jpnCadAdj.add(jlbCadTipoChip);
		jpnCadAdj.add(jlbCadTela);
		jpnCadAdj.add(jtfCadCameraFrontal);	
		jpnCadAdj.add(jtfCadCameraTraseira);	
		jpnCadAdj.add(jtfCadMemInt);	
		jpnCadAdj.add(jtfCadMemRam);
		jpnCadAdj.add(jtfCadQtdChips);
		jpnCadAdj.add(jtfCadTipoChip);
		jpnCadAdj.add(jtfCadTela);
		
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
