package Telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
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

public class TelaCadastraPessoa extends JFrame implements ActionListener, KeyListener{
	private CriaLabel cl = new CriaLabel();
	private CriaPanel cp = new CriaPanel();
	private CriaField cf = new CriaField();
	private CriaButton cb = new CriaButton();
	private FieldEmUpper fu = new FieldEmUpper();
	private JLabel jlbTituloFrame;
	private JPanel jpnCadEssencial, jpnCadEndereco, jpnCadUnica, jpnOpcoes;
	private JLabel jlbCadNome, jlbCadDataNascimento, jlbCadEmail, jlbCadCelular, jlbCadResidencial,
		jlbCadSexo, jlbCadEstadoCivil, jlbCadRua, jlbCadNumero, jlbCadComplemento, jlbCadBairro, jlbCadCidade, 
			jlbCadUf, jlbCadCep, jlbCadRg, jlbCadCpf, jlbOpcOpcoes;
	private JTextField jtfCadNome, jtfCadDataNascimento, jtfCadEmail, jtfCadCelular, jtfCadResidencial, jtfCadSexo, 
		jtfCadRua, jtfCadNumero, jtfCadComplemento, jtfCadBairro, jtfCadCidade, jtfCadUf, jtfCadCep, jtfCadRg, jtfCadCpf;
	private JButton jbtInfDataNascimento, jbtSalvar, jbtLimpar, jbtCancelar;
	private JComboBox<String> jcbCadEstadoCivil;
	private Container tela;

	public TelaCadastraPessoa() {
		tela = getContentPane();
		setTitle("Celulares - Cadastro Pessoa F�sica");
		setLayout(null);

		jlbTituloFrame = cl.criarTitulo("Cadastro de Pessoa F�sica", jlbTituloFrame, tela);
		
		criarCamposCadastrado();
		
		jlbOpcOpcoes = cl.criarParaPanelCenter("Op��es", 360, 5, 80, 24, jlbOpcOpcoes, tela);
		jbtLimpar = cb.criarBotao("Limpar", 600, 33, 100, 24, jbtLimpar, tela, this);
		jbtSalvar = cb.criarBotao("Salvar", 300, 33, 100, 24, jbtSalvar, tela, this);
		jbtCancelar = cb.criarBotao("Cancelar", 400, 33, 100, 24, jbtCancelar, tela, this);
	
		jpnOpcoes = cp.criarPanelSemTitulo(0, 377, 800, 90, jpnOpcoes, true, tela);
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
		jlbCadNome = cl.criarLabelParaPanel("Nome:", 15, 15, 80, 24, jlbCadNome, tela);
		jlbCadSexo = cl.criarLabelParaPanel("Sexo:", 15, 39, 80, 24, jlbCadSexo, tela);
		jlbCadEstadoCivil = cl.criarLabelParaPanel("Est. Civil:", 175, 39, 95, 24, jlbCadEstadoCivil, tela);
		jlbCadDataNascimento = cl.criarLabelParaPanel("Data de nascimento:", 405, 39, 160, 24, jlbCadDataNascimento, tela);
		jlbCadResidencial = cl.criarLabelParaPanel("Telefone residencial:", 340, 63, 185, 24, jlbCadResidencial, tela);
		jlbCadCelular = cl.criarLabelParaPanel("Celular:", 15, 63, 80, 24, jlbCadCelular, tela);
		jlbCadEmail = cl.criarLabelParaPanel("E-mail:", 15, 87, 80, 24, jlbCadEmail, tela);
		
		jtfCadNome = cf.criarTextField(100, 15, 600, 24, jtfCadNome, tela, this);
		jtfCadSexo = cf.criarTextField(100, 39, 80, 24, jtfCadSexo, tela, this);
		jtfCadDataNascimento = cf.criarMaskFieldDate(570, 39, 80, 24, jtfCadDataNascimento, tela);
		jtfCadCelular = cf.criarTextField(100, 63, 125, 24, jtfCadCelular, tela, this);
		jtfCadResidencial = cf.criarTextField(530, 63, 170, 24, jtfCadResidencial, tela, this);
		jtfCadEmail = cf.criarTextField(100, 87, 600, 24, jtfCadEmail, tela, this);	
		
		jcbCadEstadoCivil = new JComboBox<>();
		jcbCadEstadoCivil.setBounds(275, 39, 120, 24);
		jcbCadEstadoCivil.addItem("Solteiro(a)");
		jcbCadEstadoCivil.addItem("Casado(a)");
		jcbCadEstadoCivil.addItem("Divorciado(a)");
		jcbCadEstadoCivil.addItem("Vi�vo(a)");
		jcbCadEstadoCivil.addItem("Separado(a) Judicialmente");
		jcbCadEstadoCivil.setSelectedIndex(-1);
		
		String MENSAGEM_DATA = "Use o formato M�s/Dia/Ano ao inserir datas. Exemplo: 12/29/97";
		jbtInfDataNascimento = cb.criarBotaoAjuda(MENSAGEM_DATA, "?", 650, 39, 49, 24, jbtInfDataNascimento, tela, this);		
		
		jpnCadEssencial = cp.criarPanelSemTitulo(0, 70, 800, 125, jpnCadEssencial, true, tela);
		jpnCadEssencial.add(jlbCadNome);
		jpnCadEssencial.add(jlbCadEmail);
		jpnCadEssencial.add(jlbCadDataNascimento);	
		jpnCadEssencial.add(jlbCadResidencial);
		jpnCadEssencial.add(jlbCadCelular);	
		jpnCadEssencial.add(jlbCadSexo);	
		jpnCadEssencial.add(jlbCadEstadoCivil);
		jpnCadEssencial.add(jtfCadNome);
		jpnCadEssencial.add(jtfCadEmail);
		jpnCadEssencial.add(jtfCadDataNascimento);	
		jpnCadEssencial.add(jtfCadCelular);	
		jpnCadEssencial.add(jtfCadResidencial);	
		jpnCadEssencial.add(jtfCadSexo);	
		jpnCadEssencial.add(jbtInfDataNascimento);
		jpnCadEssencial.add(jcbCadEstadoCivil);
		
		jlbCadRua = cl.criarLabelParaPanel("Rua:", 15, 15, 80, 24, jlbCadRua, tela);
		jlbCadNumero = cl.criarLabelParaPanel("N�mero:", 530, 15, 80, 24, jlbCadNumero, tela);
		jlbCadComplemento = cl.criarLabelParaPanel("Complemento:", 30, 39, 120, 24, jlbCadComplemento, tela);
		jlbCadBairro = cl.criarLabelParaPanel("Bairro:", 15, 63, 80, 24, jlbCadBairro, tela);
		jlbCadCidade = cl.criarLabelParaPanel("Cidade:", 15, 87, 80, 24, jlbCadCidade, tela);
		jlbCadUf = cl.criarLabelParaPanel("UF:", 300, 87, 120, 24, jlbCadUf, tela);
		jlbCadCep = cl.criarLabelParaPanel("CEP:", 500, 87, 80, 24, jlbCadCep, tela);
		
		jtfCadRua = cf.criarTextField(100, 15, 440, 24, jtfCadRua, tela, this);
		jtfCadNumero = cf.criarTextField(620, 15, 80, 24, jtfCadNumero, tela, this);
		jtfCadComplemento = cf.criarTextField(155, 39, 545, 24, jtfCadComplemento, tela, this);
		jtfCadBairro = cf.criarTextField(100, 63, 600, 24, jtfCadBairro, tela, this);
		jtfCadCidade = cf.criarTextField(100, 87, 290, 24, jtfCadCidade, tela, this);
		jtfCadUf = cf.criarTextField(425, 87, 50, 24, jtfCadUf, tela, this);
		jtfCadCep = cf.criarTextField(590, 87, 110, 24, jtfCadCep, tela, this);
				
		jpnCadEndereco = cp.criarPanelSemTitulo(0, 195, 800, 127, jpnCadEndereco, true, tela);
		jpnCadEndereco.add(jlbCadRua);
		jpnCadEndereco.add(jlbCadNumero);
		jpnCadEndereco.add(jlbCadComplemento);
		jpnCadEndereco.add(jlbCadBairro);
		jpnCadEndereco.add(jlbCadCidade);
		jpnCadEndereco.add(jlbCadUf);
		jpnCadEndereco.add(jlbCadCep);
		jpnCadEndereco.add(jtfCadRua);
		jpnCadEndereco.add(jtfCadNumero);
		jpnCadEndereco.add(jtfCadComplemento);
		jpnCadEndereco.add(jtfCadBairro);
		jpnCadEndereco.add(jtfCadCidade);
		jpnCadEndereco.add(jtfCadUf);
		jpnCadEndereco.add(jtfCadCep);
		
		jlbCadRg = cl.criarLabelParaPanel("RG:", 15, 15, 80, 24, jlbCadRg, tela);
		jlbCadCpf = cl.criarLabelParaPanel("CPF:", 150, 15, 80, 24, jlbCadCpf, tela);
		
		jtfCadRg = cf.criarTextField(100, 15, 90, 24, jtfCadRg, tela, this);
		jtfCadCpf = cf.criarTextField(240, 15, 120, 24, jtfCadCpf, tela, this);
		
		jpnCadUnica = cp.criarPanelSemTitulo(0, 322, 800, 55, jpnCadUnica, true, tela);
		jpnCadUnica.add(jlbCadRg);
		jpnCadUnica.add(jlbCadCpf);
		jpnCadUnica.add(jtfCadRg);
		jpnCadUnica.add(jtfCadCpf);
	}

	public static void main(String[] args) {
		new TelaCadastraPessoa();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getComponent() == jtfCadNome){
			if(e.getSource() == jtfCadNome){
				fu.transformar(jtfCadNome);
			}
		}
		if(e.getComponent() == jtfCadSexo){
			if(e.getSource() == jtfCadSexo){
				fu.transformar(jtfCadSexo);
			}
		}
		
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
