package Telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Componentes.CriaButton;
import Componentes.CriaField;
import Componentes.CriaLabel;
import Componentes.CriaPanel;
import Componentes.FieldEmUpper;

public class TelaAlterarCelular extends JFrame implements ActionListener, KeyListener{
	private CriaLabel cl = new CriaLabel();
	private CriaPanel cp = new CriaPanel();
	private CriaField cf = new CriaField();
	private CriaButton cb = new CriaButton();
	private FieldEmUpper fu = new FieldEmUpper();
	private JLabel jlbCadDescricao, jlbCadImei, jlbCadModelo, jlbCadEmpresa, jlbCadCameraFrontal, jlbCadCameraTraseira,
		jlbCadMemRam, jlbCadMemInt, jlbCadQtdChips, jlbCadValor, jlbCadTipoChip, jlbCadTela, jlbCadSistema, jlbCadPeso, jlbCadCor,
			jlbCadTv, jlbCadGarantia, jlbCadConectividade, jlbOpcOpcoes;
	private JTextField jtfCadDescricao, jtfCadImei, jtfCadModelo, jtfCadEmpresa, jtfCadCameraFrontal, jtfCadCameraTraseira, 
		jtfCadMemRam, jtfCadMemInt, jtfCadQtdChips, jtfCadValor, jtfCadTipoChip, jtfCadTela, jtfCadSistema, jtfCadPeso, jtfCadCor, 
			jtfCadGarantia, jtfCadConectividade;
	private JPanel jpnCadUnica, jpnCadAdj, jpnOpcoes;
	private JLabel jlbTituloFrame;
	private Container tela;
	private JComboBox<String> jcbPossuiTV;
	private JButton jbtInfCadValor, jbtSalvar, jbtLimpar, jbtCancelar;
	private static String titulo = "Alteração de Celular";
	private ArrayList<JTextField> jtfsObrig, jtfsVazio;
	private Map<JTextField, String> descricao;
	private Double valor;
	
	public TelaAlterarCelular() {
		tela = getContentPane();
		setTitle("Celulares - Alteração de Celular");
		setLayout(null);

		jlbTituloFrame = cl.criarTitulo(titulo, jlbTituloFrame, tela);
		
		criarCamposCadastrado();
		
		jlbOpcOpcoes = cl.criarParaPanelCenter("Opções", 360, 5, 80, 24, jlbOpcOpcoes, tela);
		jbtLimpar = cb.criarBotao("Limpar", 600, 33, 100, 24, jbtLimpar, tela, this);
		jbtSalvar = cb.criarBotao("Salvar", 300, 33, 100, 24, jbtSalvar, tela, this);
		jbtCancelar = cb.criarBotao("Cancelar", 400, 33, 100, 24, jbtCancelar, tela, this);
	
		jpnOpcoes = cp.criarPanelSemTitulo(0, 400, 800, 90, jpnOpcoes, true, tela);
		jpnOpcoes.add(jlbOpcOpcoes);
		jpnOpcoes.add(jbtLimpar);
		jpnOpcoes.add(jbtSalvar);
		jpnOpcoes.add(jbtCancelar);
		
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
		jtfCadImei = cf.criarTextField(100, 39, 167, 24, jtfCadImei, tela, this);
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
		jlbCadSistema = cl.criarLabelParaPanel("Sist. Operacional:", 15, 111, 150, 24, jlbCadSistema, tela);
		jlbCadPeso = cl.criarLabelParaPanel("Peso do aparelho:", 15, 135, 150, 24, jlbCadPeso, tela);
		jlbCadCor = cl.criarLabelParaPanel("Cor:", 200, 135, 100, 24, jlbCadCor, tela);
		jlbCadTv = cl.criarLabelParaPanel("Possui TV:", 336, 135, 150, 24, jlbCadTv, tela);
		jlbCadConectividade = cl.criarLabelParaPanel("Conectividade:", 15, 159, 150, 24, jlbCadConectividade, tela);
		jlbCadGarantia = cl.criarLabelParaPanel("Garantia:", 15, 183, 150, 24, jlbCadGarantia, tela);
		jlbCadValor = cl.criarLabelParaPanel("Valor(R$):", 15, 207, 150, 24, jlbCadValor, tela);
		
		jtfCadCameraFrontal = cf.criarTextField(175, 15, 80, 24, jtfCadCameraFrontal, tela, this);
		jtfCadCameraTraseira = cf.criarTextField(405, 15, 80, 24, jtfCadCameraTraseira, tela, this);
		jtfCadMemInt = cf.criarTextField(175, 39, 80, 24, jtfCadMemInt, tela, this);	
		jtfCadMemRam = cf.criarTextField(405, 39, 80, 24, jtfCadMemRam, tela, this);	
		jtfCadQtdChips = cf.criarTextField(175, 63, 80, 24, jtfCadQtdChips, tela, this);
		jtfCadTipoChip = cf.criarTextField(405, 64, 295, 24, jtfCadTipoChip, tela, this);
		jtfCadTela = cf.criarTextField(175, 87, 80, 24, jtfCadTela, tela, this);
		jtfCadSistema = cf.criarTextField(175, 111, 230, 24, jtfCadSistema, tela, this);
		jtfCadPeso = cf.criarTextField(175, 135, 80, 24, jtfCadPeso, tela, this);
		jtfCadCor = cf.criarTextField(305, 135, 100, 24, jtfCadCor, tela, this);
		jtfCadConectividade = cf.criarTextField(175, 159, 530, 24, jtfCadConectividade, tela, this);
		jtfCadGarantia = cf.criarTextField(175, 183, 530, 24, jtfCadGarantia, tela, this);		
		jtfCadValor = cf.criarTextField(175, 207, 80, 24, jtfCadValor, tela, this);		
		
		jcbPossuiTV = new JComboBox<>();
		jcbPossuiTV.setBounds(490, 135, 80, 24);
		jcbPossuiTV.addItem("NÃO");
		jcbPossuiTV.addItem("SIM");
		jcbPossuiTV.setSelectedIndex(0);
		
		String MENSAGEM_VALOR = "Use apenas pontos no valor. Exemplo: 1.500 para mil e quinhentos reais.";
		jbtInfCadValor = cb.criarBotaoAjuda(MENSAGEM_VALOR, "?", 255, 207, 49, 24, jbtInfCadValor, tela, this);	
		
		jpnCadAdj = cp.criarPanelSemTitulo(0, 170, 800,	237, jpnCadAdj, true, tela);
		jpnCadAdj.add(jlbCadCameraFrontal);	
		jpnCadAdj.add(jlbCadCameraTraseira);
		jpnCadAdj.add(jlbCadMemInt);	
		jpnCadAdj.add(jlbCadMemRam);
		jpnCadAdj.add(jlbCadQtdChips);
		jpnCadAdj.add(jlbCadTipoChip);
		jpnCadAdj.add(jlbCadTela);
		jpnCadAdj.add(jlbCadSistema);
		jpnCadAdj.add(jlbCadPeso);
		jpnCadAdj.add(jlbCadCor);
		jpnCadAdj.add(jlbCadTv);
		jpnCadAdj.add(jlbCadConectividade);
		jpnCadAdj.add(jlbCadGarantia);
		jpnCadAdj.add(jlbCadValor);
		jpnCadAdj.add(jtfCadCameraFrontal);	
		jpnCadAdj.add(jtfCadCameraTraseira);	
		jpnCadAdj.add(jtfCadMemInt);	
		jpnCadAdj.add(jtfCadMemRam);
		jpnCadAdj.add(jtfCadQtdChips);
		jpnCadAdj.add(jtfCadTipoChip);
		jpnCadAdj.add(jtfCadTela);
		jpnCadAdj.add(jtfCadSistema);
		jpnCadAdj.add(jtfCadPeso);
		jpnCadAdj.add(jtfCadCor);
		jpnCadAdj.add(jtfCadConectividade);
		jpnCadAdj.add(jtfCadGarantia);
		jpnCadAdj.add(jtfCadValor);
		jpnCadAdj.add(jcbPossuiTV);
		jpnCadAdj.add(jbtInfCadValor);
	}
	
	public static void main(String[] args) {
		new TelaAlterarCelular();
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
