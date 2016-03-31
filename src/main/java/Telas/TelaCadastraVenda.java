package Telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import lombok.Getter;
import lombok.Setter;
import Componentes.CriaButton;
import Componentes.CriaField;
import Componentes.CriaLabel;
import Componentes.CriaPanel;

@Getter @Setter
public class TelaCadastraVenda extends JFrame implements ActionListener, KeyListener {
	private static final long serialVersionUID = 6196565311877436918L;
	private Container tela;
	private JLabel jlbTituloFrame, jlbCadData, jlbCadCliente, jlbCadVendedor, jlbCadCelular,
				jlbCelImei, jlbCelModelo, jlbCelEmpresa, jlbCelValor;
	private JTextField jtfCadData, jtfCadCliente, jtfCadVendedor, jtfCadCelular,
				jtfCelImei, jtfCelModelo, jtfCelEmpresa, jtfCelValor;
	private JButton jbtProCelular, jbtProCliente, jbtProVendedor;
	private JButton jbtInfoData;
	private CriaLabel cl = new CriaLabel();
	private CriaField cf = new CriaField();
	private CriaButton cb = new CriaButton();
	private CriaPanel cp = new CriaPanel();
	private JPanel jpnCadEssencial, jpnCelInfo;
	private static String titulo = "Cadastro de venda";
	
	public TelaCadastraVenda() {
		tela = getContentPane();
		setTitle("M&M Celulares - Cadastro de venda");
		setLayout(null);

		jlbTituloFrame = cl.criarTitulo(titulo, jlbTituloFrame, tela);
		
		criarCamposCadastrado();
		
		tela.setBackground(Color.white);
		setSize(800, 495);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void criarCamposCadastrado() {
		jlbCadData = cl.criarLabelParaPanel("Data:", 15, 17, 80, 24, jlbCadData, tela);
		jlbCadCelular = cl.criarLabelParaPanel("Celular:", 234, 17, 80, 24, jlbCadCelular, tela);
		jlbCadCliente = cl.criarLabelParaPanel("Cliente:", 453, 17, 80, 24, jlbCadCliente, tela);
		jlbCadVendedor = cl.criarLabelParaPanel("Vendedor:", 449, 41, 85, 24, jlbCadVendedor, tela);
		
		jtfCadData = cf.criarMaskFieldDate(100, 15, 80, 24, jtfCadData, tela);
		jtfCadData.setColumns(6);
		jtfCadCelular = cf.criarTextField(319, 15, 80, 24, jtfCadCelular, tela, this);
		jtfCadCelular.setEnabled(false);
		jtfCadCliente = cf.criarTextField(538, 15, 180, 24, jtfCadCliente, tela, this);
		jtfCadCliente.setEnabled(false);
		jtfCadVendedor = cf.criarTextField(538, 40, 180, 24, jtfCadVendedor, tela, this);
		jtfCadVendedor.setEnabled(false);
		
		String MENSAGEM_DATA = "Use o formato M�s/Dia/Ano ao inserir datas. Exemplo: 12/29/97";
		jbtInfoData = cb.criarBotaoAjuda(MENSAGEM_DATA, "?", 180, 15, 49, 24, jbtInfoData, tela, this);		
		
		jbtProCelular = cb.criarBotaoProcurar("", 399, 15, 49, 29, jbtProCelular, tela, this);
		jbtProCelular.setToolTipText("Procurar celular");
		jbtProCelular.setIcon(new ImageIcon(TelaCadastraVenda.class.getResource("/resource/tool.png")));
		
		jbtProCliente = cb.criarBotaoProcurar("", 718, 15, 49, 29, jbtProCliente, tela, this);
		jbtProCliente.setToolTipText("Procurar cliente");
		jbtProCliente.setIcon(new ImageIcon(TelaCadastraVenda.class.getResource("/resource/tool.png")));
		
		jbtProVendedor = cb.criarBotaoProcurar("", 718, 41, 49, 29, jbtProVendedor, tela, this);
		jbtProVendedor.setToolTipText("Procurar vendedor");
		jbtProVendedor.setIcon(new ImageIcon(TelaCadastraVenda.class.getResource("/resource/tool.png")));
		
		jpnCadEssencial = cp.criarPanelSemTitulo(0, 70, 788, 85, jpnCadEssencial, true, tela);
		jpnCadEssencial.add(jlbCadData);
		jpnCadEssencial.add(jlbCadCelular);
		jpnCadEssencial.add(jlbCadCliente);	
		jpnCadEssencial.add(jlbCadVendedor);
		jpnCadEssencial.add(jtfCadData);	
		jpnCadEssencial.add(jtfCadCelular);	
		jpnCadEssencial.add(jtfCadCliente);
		jpnCadEssencial.add(jtfCadVendedor);
		jpnCadEssencial.add(jbtInfoData);
		jpnCadEssencial.add(jbtProCelular);
		jpnCadEssencial.add(jbtProCliente);
		jpnCadEssencial.add(jbtProVendedor);
		
		jlbCelImei = cl.criarLabelParaPanel("IMEI:", 15, 25, 80, 24, jlbCelImei, tela);
		jlbCelModelo = cl.criarLabelParaPanel("Modelo:", 220, 25, 80, 24, jlbCelModelo, tela);
		jlbCelEmpresa = cl.criarLabelParaPanel("Empresa:", 410, 25, 80, 24, jlbCelEmpresa, tela);
		jlbCelValor = cl.criarLabelParaPanel("Valor (R$):", 605, 25, 85, 24, jlbCelValor, tela);
		
		jtfCelImei = cf.criarTextField(100, 25, 120, 24, jtfCelImei, tela, this);
		jtfCelImei.setText("Selecione o celular.");
		jtfCelImei.setEnabled(false);
		jtfCelModelo = cf.criarTextField(305, 25, 100, 24, jtfCelModelo, tela, this);
		jtfCelModelo.setText("Selecione o celular.");
		jtfCelModelo.setEnabled(false);
		jtfCelEmpresa = cf.criarTextField(495, 25, 100, 24, jtfCelEmpresa, tela, this);
		jtfCelEmpresa.setText("Selecione o celular.");
		jtfCelEmpresa.setEnabled(false);
		jtfCelValor = cf.criarTextField(695, 25, 70, 24, jtfCelValor, tela, this);
		jtfCelValor.setText("Selecione o celular.");
		jtfCelValor.setEnabled(false);
		
		jpnCelInfo = cp.criarPanel("Informa��es do celular", 0, 155, 788, 65, jpnCelInfo, true, tela);
		jpnCelInfo.add(jlbCelImei);
		jpnCelInfo.add(jlbCelModelo);	
		jpnCelInfo.add(jlbCelEmpresa);
		jpnCelInfo.add(jlbCelValor);
		jpnCelInfo.add(jtfCelImei);
		jpnCelInfo.add(jtfCelModelo);	
		jpnCelInfo.add(jtfCelEmpresa);	
		jpnCelInfo.add(jtfCelValor);	
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		new TelaCadastraVenda();
	}


}
