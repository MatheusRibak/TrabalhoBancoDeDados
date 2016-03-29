package Telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import utilitarios.EscolheMensagem;
import metodos.CadastroCliente;
import metodos.CadastroVendedor;
import metodos.SubstituiCamposVazios;
import metodos.VerificaJtfObrigatorios;
import Componentes.CriaButton;
import Componentes.CriaField;
import Componentes.CriaLabel;
import Componentes.CriaPanel;
import Componentes.CriaRadioButton;
import Componentes.FieldEmUpper;
import Model.Cliente;

public class TelaCadastraPessoa extends JFrame implements ActionListener, KeyListener{
	private CriaLabel cl = new CriaLabel();
	private CriaPanel cp = new CriaPanel();
	private CriaField cf = new CriaField();
	private CriaButton cb = new CriaButton();
	private FieldEmUpper fu = new FieldEmUpper();
	private CriaRadioButton crb = new CriaRadioButton();
	private JLabel jlbTituloFrame, jlbProTipo;
	private JPanel jpnCadEssencial, jpnCadEndereco, jpnCadUnica, jpnOpcoes;
	private JLabel jlbCadNome, jlbCadDataNascimento, jlbCadEmail, jlbCadCelular, jlbCadResidencial,
		jlbCadSexo, jlbCadEstadoCivil, jlbCadRua, jlbCadNumero, jlbCadComplemento, jlbCadBairro, jlbCadCidade, 
			jlbCadUf, jlbCadCep, jlbCadRg, jlbCadCpf, jlbOpcOpcoes, jlbCadVendSalario, jlbCadVendComissao, jlbCadVendUsuario, 
				jlbCadVendSenha, jlbCadVendNivelAcesso;
	private JTextField jtfCadNome, jtfCadDataNascimento, jtfCadEmail, jtfCadCelular, jtfCadResidencial, jtfCadSexo, 
		jtfCadRua, jtfCadNumero, jtfCadComplemento, jtfCadBairro, jtfCadCidade, jtfCadUf, jtfCadCep, jtfCadRg, jtfCadCpf, jtfCadVendUsuario,
				jtfCadVendSenha, jtfCadVendComissao, jtfCadVendSalario;
	private JButton jbtInfDataNascimento, jbtSalvar, jbtLimpar, jbtCancelar;
	private JComboBox<String> jcbCadEstadoCivil, jcbCadVendNivelAcesso;
	private ButtonGroup btnProGrupo;
	private JRadioButton jrbCliente, jrbVendedor;
	private Container tela;
	private static String titulo = "Cadastro Pessoa Física | ";
	private ArrayList<JTextField> jtfsObrig, jtfsVazio;
	private Map<JTextField, String> descricao;
	private Date dataNascVerificar = null;
	private Double salario, comissao;
	

	public TelaCadastraPessoa() {
		tela = getContentPane();
		setTitle("Celulares - Cadastro Pessoa Física");
		setLayout(null);

		jlbTituloFrame = cl.criarTitulo(titulo + "CLIENTE", jlbTituloFrame, tela);
		
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
		jtfCadDataNascimento.setColumns(6);
		jtfCadCelular = cf.criarTextField(100, 63, 125, 24, jtfCadCelular, tela, this);
		jtfCadResidencial = cf.criarTextField(530, 63, 170, 24, jtfCadResidencial, tela, this);
		jtfCadEmail = cf.criarTextField(100, 87, 600, 24, jtfCadEmail, tela, this);	
		
		jcbCadEstadoCivil = new JComboBox<>();
		jcbCadEstadoCivil.setBounds(275, 39, 120, 24);
		jcbCadEstadoCivil.addItem("Solteiro(a)");
		jcbCadEstadoCivil.addItem("Casado(a)");
		jcbCadEstadoCivil.addItem("Divorciado(a)");
		jcbCadEstadoCivil.addItem("Viúvo(a)");
		jcbCadEstadoCivil.addItem("Separado(a) Judicialmente");
		jcbCadEstadoCivil.setSelectedIndex(0);
		
		String MENSAGEM_DATA = "Use o formato Mês/Dia/Ano ao inserir datas. Exemplo: 12/29/97";
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
		jlbCadNumero = cl.criarLabelParaPanel("Número:", 530, 15, 80, 24, jlbCadNumero, tela);
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
	
		
		jlbProTipo = cl.criarLabelParaPanel("Tipo:", 15, 39, 80, 24, jlbProTipo, tela);
		jrbCliente = crb.criarRadioButton("Cliente", 100, 39, 70, 24, jrbCliente, tela);
		jrbCliente.addActionListener(this);
		jrbVendedor = crb.criarRadioButton("Vendedor", 175, 39, 80, 24, jrbVendedor, tela);
		jrbVendedor.addActionListener(this);
		jrbCliente.setSelected(true);
		btnProGrupo = new ButtonGroup();
		btnProGrupo.add(jrbCliente);
		btnProGrupo.add(jrbVendedor);
		
		//campos para vendedor
		jlbCadVendSalario = cl.criarLabelParaPanel("Salário:", 15, 63, 80, 24, jlbCadVendSalario, tela);
		jlbCadVendComissao = cl.criarLabelParaPanel("Comissão:", 195, 63, 80, 24, jlbCadVendComissao, tela);
		jlbCadVendUsuario = cl.criarLabelParaPanel("Usuário:", 15, 87, 80, 24, jlbCadVendUsuario, tela);
		jlbCadVendSenha = cl.criarLabelParaPanel("Senha:", 195, 87, 80, 24, jlbCadVendSenha, tela);
		jlbCadVendNivelAcesso = cl.criarLabelParaPanel("Nível de acesso:", 395, 87, 130, 24, jlbCadVendNivelAcesso, tela);
		
		jtfCadVendSalario = cf.criarTextField(100, 63, 90, 24, jtfCadVendUsuario, tela, this);
		jtfCadVendComissao = cf.criarTextField(280, 63, 80, 24, jtfCadVendComissao, tela, this);
		jtfCadVendUsuario = cf.criarTextField(100, 87, 120, 24, jtfCadVendUsuario, tela, this);
		jtfCadVendSenha = cf.criarPasswordField(280, 87, 110, 24, jtfCadVendSenha, tela);
		
		jcbCadVendNivelAcesso = new JComboBox<>();
		jcbCadVendNivelAcesso.setBounds(530, 87, 140, 24);
		jcbCadVendNivelAcesso.addItem("Normal");
		jcbCadVendNivelAcesso.addItem("Administrador do Sistema");
		jcbCadVendNivelAcesso.setSelectedIndex(1);
		
		jpnCadUnica = cp.criarPanelSemTitulo(0, 322, 800, 80, jpnCadUnica, true, tela);
		jpnCadUnica.add(jlbCadRg);
		jpnCadUnica.add(jlbCadCpf);
		jpnCadUnica.add(jtfCadRg);
		jpnCadUnica.add(jtfCadCpf);
		jpnCadUnica.add(jlbProTipo);
		jpnCadUnica.add(jrbCliente);
		jpnCadUnica.add(jrbVendedor);
		jpnCadUnica.add(jlbCadVendSalario);
		jpnCadUnica.add(jlbCadVendComissao);
		jpnCadUnica.add(jlbCadVendUsuario);
		jpnCadUnica.add(jlbCadVendSenha);
		jpnCadUnica.add(jlbCadVendNivelAcesso);
		jpnCadUnica.add(jcbCadVendNivelAcesso);
		jpnCadUnica.add(jtfCadVendSalario);
		jpnCadUnica.add(jtfCadVendComissao);
		jpnCadUnica.add(jtfCadVendUsuario);
		jpnCadUnica.add(jtfCadVendSenha);
		
		jlbCadVendUsuario.setVisible(false);
		jlbCadVendSenha.setVisible(false);
		jlbCadVendComissao.setVisible(false);
		jlbCadVendSalario.setVisible(false);
		jlbCadVendNivelAcesso.setVisible(false);
		jtfCadVendUsuario.setVisible(false);
		jtfCadVendSenha.setVisible(false);
		jtfCadVendSalario.setVisible(false);
		jtfCadVendComissao.setVisible(false);
		jcbCadVendNivelAcesso.setVisible(false);
		
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
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jrbCliente){
			jpnCadUnica.setBounds(0, 322, 800, 80);
			jpnOpcoes.setBounds(0, 400, 800, 90);
			
			jlbOpcOpcoes.setLocation(360, 5);
			jbtSalvar.setLocation(300, 33);
			jbtCancelar.setLocation(400, 33);
			jbtLimpar.setLocation(600, 33);
			
			jlbTituloFrame.setText(titulo + "CLIENTE");
			
			jlbCadVendUsuario.setVisible(false);
			jlbCadVendSenha.setVisible(false);
			jlbCadVendComissao.setVisible(false);
			jlbCadVendSalario.setVisible(false);
			jlbCadVendNivelAcesso.setVisible(false);
			jtfCadVendUsuario.setVisible(false);
			jtfCadVendSenha.setVisible(false);
			jtfCadVendSalario.setVisible(false);
			jtfCadVendComissao.setVisible(false);
			jcbCadVendNivelAcesso.setVisible(false);
		}
		
		if(e.getSource() == jrbVendedor){
			jpnCadUnica.setBounds(0, 322, 675, 143);
			jpnOpcoes.setBounds(670, 322, 123, 143);
			
			jlbOpcOpcoes.setLocation(10, 15);
			jbtSalvar.setLocation(10, 39);
			jbtCancelar.setLocation(10, 63);
			jbtLimpar.setLocation(10, 87);
			
			jlbTituloFrame.setText(titulo + "VENDEDOR");
			
			jlbCadVendUsuario.setVisible(true);
			jlbCadVendSenha.setVisible(true);
			jlbCadVendComissao.setVisible(true);
			jlbCadVendSalario.setVisible(true);
			jlbCadVendNivelAcesso.setVisible(true);
			jtfCadVendUsuario.setVisible(true);
			jtfCadVendSenha.setVisible(true);
			jtfCadVendSalario.setVisible(true);
			jtfCadVendComissao.setVisible(true);
			jcbCadVendNivelAcesso.setVisible(true);
		}
		
		if(e.getSource() == jbtLimpar){
			limparCampos();
		}
		
		if(e.getSource() == jbtCancelar){
			this.dispose();
		}
		
		if(e.getSource() == jbtSalvar){
			if(jrbCliente.isSelected()){
				verificaCadastroCliente();
			}
			
			if(jrbVendedor.isSelected()){
				verificaCadastroVendedor();
			}
			
		}
		
	}
	
	private void camposObrigatoriosPadrao(){
		jtfsObrig = new ArrayList<JTextField>();
		jtfsObrig.add(jtfCadNome);
		jtfsObrig.add(jtfCadRua);
		jtfsObrig.add(jtfCadNumero);
		jtfsObrig.add(jtfCadComplemento);
		jtfsObrig.add(jtfCadBairro);
		jtfsObrig.add(jtfCadCidade);
		jtfsObrig.add(jtfCadUf);
		jtfsObrig.add(jtfCadCep);
		jtfsObrig.add(jtfCadRg);
		jtfsObrig.add(jtfCadCpf);
		
		jtfsVazio = new ArrayList<JTextField>();
		jtfsVazio.add(jtfCadSexo);
		jtfsVazio.add(jtfCadCelular);
		jtfsVazio.add(jtfCadResidencial);
		jtfsVazio.add(jtfCadEmail);
		SubstituiCamposVazios sub = new SubstituiCamposVazios();
		sub.substitui(jtfsVazio);
		
		descricao = new HashMap<JTextField, String>();
		descricao.put(jtfCadNome, "* Nome");
		descricao.put(jtfCadRua, "* Rua");
		descricao.put(jtfCadNumero, "* Número");
		descricao.put(jtfCadComplemento, "* Complemento");
		descricao.put(jtfCadBairro, "* Bairro");
		descricao.put(jtfCadCidade, "* Cidade");
		descricao.put(jtfCadUf, "* UF");
		descricao.put(jtfCadCep, "* Cep");
		descricao.put(jtfCadRg, "* RG");
		descricao.put(jtfCadCpf, "* CPF");
		descricao.put(jtfCadVendSalario, "* Salário");
		descricao.put(jtfCadVendComissao, "* Comissão");
		descricao.put(jtfCadVendUsuario, "* Usuário");
		descricao.put(jtfCadVendSenha, "* Senha");
	}
	
	private void verificaCadastroVendedor() {
		camposObrigatoriosPadrao();
		//adiciona campos obrigatorios de vendedor
		jtfsObrig.add(jtfCadVendSalario);
		jtfsObrig.add(jtfCadVendComissao);
		jtfsObrig.add(jtfCadVendUsuario);
		jtfsObrig.add(jtfCadVendSenha);
		
		VerificaJtfObrigatorios verificador = new VerificaJtfObrigatorios();
		Boolean todosPreenchidos = verificador.verificaJtf(jtfsObrig, descricao);
		
		Boolean dataCorreta = true;
		Date dataNascVerificar = null;
		try {
			DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
			dataNascVerificar = (Date)formatter.parse(jtfCadDataNascimento.getText().toString());
		} catch (ParseException e) {
			dataCorreta = false;
			verificador.setCamposMostra(verificador.getCamposMostra() + "* Data de nascimento - Use o formato Mês/Dia/Ano - Ex: 12/25/15.");
		}		
		
		Boolean valorSalarioCorreto = true;
		Boolean valorComissaoCorretor = true;
		salario = null;
		comissao = null;
		
		//verifica salario
		try {
			salario = Double.valueOf(jtfCadVendSalario.getText());
		} catch (Exception e) {
			valorSalarioCorreto = false;
			verificador.setCamposMostra(verificador.getCamposMostra() + "\n* REMOVA CARACTERES ESPECIAIS DO CAMPO SALÁRIO, EXEMPLO: , ! ? $ R$");
		}
		
		//verifica comissao
		try {
			comissao = Double.valueOf(jtfCadVendComissao.getText());
		} catch (Exception e) {
			valorComissaoCorretor = false;
			verificador.setCamposMostra(verificador.getCamposMostra() + "\n* REMOVA CARACTERES ESPECIAIS DO CAMPO COMISSÃO, EXEMPLO: , ! ? $ R$");
		}
	
		
		if((todosPreenchidos) && (dataCorreta) && (valorSalarioCorreto) && (valorComissaoCorretor)){
			cadastrarVendedor();
		}else{
			JOptionPane.showMessageDialog(null, "Os campos a baixo são de preenchimento obrigatório:" + verificador.getCamposMostra());
		}
		
		
	}

	private void cadastrarVendedor() {
		CadastroVendedor cadVendedor = new CadastroVendedor();
		Boolean cadastrou = cadVendedor.cadastrar(jtfCadRua.getText(), jtfCadNumero.getText(), jtfCadBairro.getText(), jtfCadCidade.getText(), jtfCadUf.getText(), jtfCadCep.getText(), jtfCadNome.getText(), jtfCadSexo.getText(), jcbCadEstadoCivil.getSelectedItem().toString(), jtfCadRg.getText(), jtfCadCpf.getText(), dataNascVerificar, jtfCadEmail.getText(), jtfCadCelular.getText(), jtfCadResidencial.getText(), comissao, salario, jtfCadVendUsuario.getText(), jtfCadVendSenha.getText(), jcbCadVendNivelAcesso.getSelectedIndex());
		
		EscolheMensagem escMensagem = new EscolheMensagem();
		if(cadastrou){
			escMensagem.mensagemSucesso("cadastro_cliente");
		}else{
			escMensagem.mensagemErro("cadastro_cliente");
		}
	
	}

	private void verificaCadastroCliente() {	
		camposObrigatoriosPadrao();
		VerificaJtfObrigatorios verificador = new VerificaJtfObrigatorios();
		Boolean todosPreenchidos = verificador.verificaJtf(jtfsObrig, descricao);
		
		Boolean dataCorreta = true;
		try {
			DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
			dataNascVerificar = (Date)formatter.parse(jtfCadDataNascimento.getText().toString());
		} catch (ParseException e) {
			dataCorreta = false;
			verificador.setCamposMostra(verificador.getCamposMostra() + "* Data de nascimento - Use o formato Mês/Dia/Ano - Ex: 12/25/15.");
		}		
		
		if((todosPreenchidos) && (dataCorreta)){
			cadastrarCliente();
		}else{
			JOptionPane.showMessageDialog(null, "Os campos a baixo são de preenchimento obrigatório:" + verificador.getCamposMostra());
		}
		
		
	}

	private void cadastrarCliente() {		
		CadastroCliente cadCliente = new CadastroCliente();
		Boolean cadastrou = cadCliente.cadastrar(jtfCadRua.getText(), jtfCadNumero.getText(), jtfCadBairro.getText(), jtfCadCidade.getText(), jtfCadUf.getText(), jtfCadCep.getText(), jtfCadNome.getText(), jtfCadSexo.getText(), jcbCadEstadoCivil.getSelectedItem().toString(), jtfCadRg.getText(), jtfCadCpf.getText(), dataNascVerificar, jtfCadEmail.getText(), jtfCadCelular.getText(), jtfCadResidencial.getText());
		EscolheMensagem escMensagem = new EscolheMensagem();
		if(cadastrou){
			escMensagem.mensagemSucesso("cadastro_cliente");
		}else{
			escMensagem.mensagemErro("cadastro_cliente");
		}
	
	}

	private void limparCampos(){
		jtfCadNome.setText("");
		jtfCadSexo.setText("");
		jtfCadDataNascimento.setText("");
		jtfCadCelular.setText("");
		jtfCadResidencial.setText("");
		jtfCadEmail.setText("");
		jtfCadRua.setText("");
		jtfCadBairro.setText("");
		jtfCadComplemento.setText("");
		jtfCadNumero.setText("");
		jtfCadCidade.setText("");
		jtfCadUf.setText("");
		jtfCadCep.setText("");
		jtfCadRg.setText("");
		jtfCadCpf.setText("");
		jtfCadVendSalario.setText("");
		jtfCadVendComissao.setText("");
		jtfCadVendUsuario.setText("");
		jtfCadVendSenha.setText("");
		jcbCadVendNivelAcesso.setSelectedIndex(1);
		jcbCadEstadoCivil.setSelectedIndex(0);
	}
}
