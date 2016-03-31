package Telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import utilitarios.EscolheMensagem;
import metodos.SubstituiCamposVazios;
import metodos.VerificaJtfObrigatorios;
import Componentes.CriaButton;
import Componentes.CriaField;
import Componentes.CriaLabel;
import Componentes.CriaPanel;
import Componentes.CriaRadioButton;
import DAO.GenericDAO;
import Model.Cliente;
import Model.Usuario;

public class TelaAlterarPessoa extends JInternalFrame implements ActionListener, KeyListener{
	private static final long serialVersionUID = 2503016552788031157L;
	private CriaLabel cl = new CriaLabel();
	private CriaPanel cp = new CriaPanel();
	private CriaField cf = new CriaField();
	private CriaButton cb = new CriaButton();
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
	private static String titulo = "Alterar Pessoa Física | ";
	private ArrayList<JTextField> jtfsObrig, jtfsVazio;
	private Map<JTextField, String> descricao;
	private Date dataNascVerificar = null;
	private Double salario, comissao;
	private Usuario usuarioAlterar = null;
	private Cliente clienteAlterar = null;
	

	public TelaAlterarPessoa() {
		tela = getContentPane();
		setTitle("Celulares - Alteração de Pessoa Física");
		setLayout(null);

		jlbTituloFrame = cl.criarTitulo(titulo + "CLIENTE", jlbTituloFrame, tela);
		
		criarCamposCadastrado();
		
		jlbOpcOpcoes = cl.criarParaPanelCenter("Opções", 360, 5, 80, 24, jlbOpcOpcoes, tela);
		jbtLimpar = cb.criarBotao("Limpar", 600, 33, 100, 24, jbtLimpar, tela, this);
		jbtSalvar = cb.criarBotao("Alterar", 300, 33, 100, 24, jbtSalvar, tela, this);
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
		setClosable(true);
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
		//jtfCadVendSenha = cf.criarPasswordField(280, 87, 110, 24, jtfCadVendSenha, tela);
		jtfCadVendSenha = cf.criarTextField(280, 87, 110, 24, jtfCadVendSenha, tela, this);
		
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
	
	private void alterarCliente(){
		clienteAlterar.getPessoa().setNome(jtfCadNome.getText());
		clienteAlterar.getPessoa().setSexo(jtfCadSexo.getText());
		clienteAlterar.getPessoa().setTelefoneCelular(jtfCadCelular.getText());
		clienteAlterar.getPessoa().setTelefoneResidencial(jtfCadResidencial.getText());
		clienteAlterar.getPessoa().getEndereco().setRua(jtfCadRua.getText());
		clienteAlterar.getPessoa().getEndereco().setNumero(jtfCadNumero.getText());
		clienteAlterar.getPessoa().getEndereco().setComplemento(jtfCadComplemento.getText());
		clienteAlterar.getPessoa().getEndereco().setBairro(jtfCadBairro.getText());
		clienteAlterar.getPessoa().getEndereco().setCidade(jtfCadCidade.getText());
		clienteAlterar.getPessoa().getEndereco().setUf(jtfCadUf.getText());
		clienteAlterar.getPessoa().getEndereco().setCep(jtfCadCep.getText());
		
		clienteAlterar.getPessoa().setRg(jtfCadRg.getText());
		clienteAlterar.getPessoa().setCpf(jtfCadCpf.getText());
	}
	
	private void usuarioAlterar(){
		usuarioAlterar.getVendedor().getPessoa().setNome(jtfCadNome.getText());
		usuarioAlterar.getVendedor().getPessoa().setSexo(jtfCadSexo.getText());
		usuarioAlterar.getVendedor().getPessoa().setTelefoneCelular(jtfCadCelular.getText());
		usuarioAlterar.getVendedor().getPessoa().setTelefoneResidencial(jtfCadResidencial.getText());
		usuarioAlterar.getVendedor().getPessoa().getEndereco().setRua(jtfCadRua.getText());
		usuarioAlterar.getVendedor().getPessoa().getEndereco().setNumero(jtfCadNumero.getText());
		usuarioAlterar.getVendedor().getPessoa().getEndereco().setComplemento(jtfCadComplemento.getText());
		usuarioAlterar.getVendedor().getPessoa().getEndereco().setBairro(jtfCadBairro.getText());
		usuarioAlterar.getVendedor().getPessoa().getEndereco().setCidade(jtfCadCidade.getText());
		usuarioAlterar.getVendedor().getPessoa().getEndereco().setUf(jtfCadUf.getText());
		usuarioAlterar.getVendedor().getPessoa().getEndereco().setCep(jtfCadCep.getText());
		
		usuarioAlterar.getVendedor().getPessoa().setRg(jtfCadRg.getText());
		usuarioAlterar.getVendedor().getPessoa().setCpf(jtfCadCpf.getText());
		
		usuarioAlterar.getVendedor().setSalario(Double.valueOf(jtfCadVendSalario.getText()));
		usuarioAlterar.getVendedor().setComissao(Double.valueOf(jtfCadVendComissao.getText()));
		usuarioAlterar.setLogin(jtfCadVendUsuario.getText());
		usuarioAlterar.setSenha(jtfCadVendSenha.getText());
		usuarioAlterar.setNivelAcesso(jcbCadVendNivelAcesso.getSelectedIndex());
	}
	
	public void popularCliente(Cliente cliente){
		clienteAlterar = cliente;
		clienteAlterar.set_id(cliente.get_id());
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
		
		jtfCadDataNascimento.setVisible(false);
		jlbCadDataNascimento.setVisible(false);
		jbtInfDataNascimento.setVisible(false);
		jtfCadNome.setText(cliente.getPessoa().getNome());
		jtfCadSexo.setText(cliente.getPessoa().getSexo());
		jtfCadCelular.setText(cliente.getPessoa().getTelefoneCelular());
		jtfCadEmail.setText(cliente.getPessoa().getEmail());
		
		jtfCadRua.setText(cliente.getPessoa().getEndereco().getRua());
		jtfCadNumero.setText(cliente.getPessoa().getEndereco().getNumero());
		jtfCadComplemento.setText(cliente.getPessoa().getEndereco().getComplemento());
		jtfCadBairro.setText(cliente.getPessoa().getEndereco().getBairro());
		jtfCadCidade.setText(cliente.getPessoa().getEndereco().getCidade());
		jtfCadUf.setText(cliente.getPessoa().getEndereco().getUf());
		jtfCadCep.setText(cliente.getPessoa().getEndereco().getCep());
		
		jrbCliente.setSelected(true);
		jtfCadRg.setText(cliente.getPessoa().getRg());
		jtfCadCpf.setText(cliente.getPessoa().getCpf());
		
		jrbCliente.setEnabled(false);
		jrbVendedor.setEnabled(false);
		
		jcbCadEstadoCivil.setSelectedItem(cliente.getPessoa().getEstadoCivil());
	}
		
	public void popularUsuario(Usuario usuario){
		usuarioAlterar = usuario;
		usuarioAlterar.set_id(usuario.get_id());
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
		
		jtfCadDataNascimento.setVisible(false);
		jlbCadDataNascimento.setVisible(false);
		jbtInfDataNascimento.setVisible(false);
		jtfCadNome.setText(usuario.getVendedor().getPessoa().getNome());
		jtfCadSexo.setText(usuario.getVendedor().getPessoa().getSexo());
		jtfCadCelular.setText(usuario.getVendedor().getPessoa().getTelefoneCelular());
		jtfCadEmail.setText(usuario.getVendedor().getPessoa().getEmail());
		
		jtfCadRua.setText(usuario.getVendedor().getPessoa().getEndereco().getRua());
		jtfCadNumero.setText(usuario.getVendedor().getPessoa().getEndereco().getNumero());
		jtfCadComplemento.setText(usuario.getVendedor().getPessoa().getEndereco().getComplemento());
		jtfCadBairro.setText(usuario.getVendedor().getPessoa().getEndereco().getBairro());
		jtfCadCidade.setText(usuario.getVendedor().getPessoa().getEndereco().getCidade());
		jtfCadUf.setText(usuario.getVendedor().getPessoa().getEndereco().getUf());
		jtfCadCep.setText(usuario.getVendedor().getPessoa().getEndereco().getCep());
		
		jtfCadRg.setText(usuario.getVendedor().getPessoa().getRg());
		jtfCadCpf.setText(usuario.getVendedor().getPessoa().getCpf());
		
		jrbVendedor.setSelected(true);
		jtfCadVendSalario.setText(usuario.getVendedor().getSalario().toString());
		jtfCadVendComissao.setText(usuario.getVendedor().getComissao().toString());
		jtfCadVendUsuario.setText(usuario.getLogin());
		jtfCadVendSenha.setText(usuario.getSenha());
		
		jcbCadEstadoCivil.setSelectedItem(usuario.getVendedor().getPessoa().getEstadoCivil());
		jcbCadVendNivelAcesso.setSelectedIndex(usuario.getNivelAcesso());
		
		jrbCliente.setEnabled(false);
		jrbVendedor.setEnabled(false);
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
		if(e.getSource() == jbtSalvar){
			if(jrbCliente.isSelected()){
				camposObrigatoriosPadrao();
				VerificaJtfObrigatorios verificador = new VerificaJtfObrigatorios();
				Boolean todosPreenchidos = verificador.verificaJtf(jtfsObrig, descricao);
				if(todosPreenchidos){
					alterarCliente();
					GenericDAO dao = new GenericDAO();
					dao.alterar(clienteAlterar, clienteAlterar.get_id());
					EscolheMensagem escMensagem = new EscolheMensagem();
					escMensagem.mensagemSucesso("alterar_cliente");
				}else{
					JOptionPane.showMessageDialog(null, "Os campos a baixo são de preenchimento obrigatório:" + verificador.getCamposMostra());
				}
			}
			if(jrbVendedor.isSelected()){
				camposObrigatoriosPadrao();
				jtfsObrig.add(jtfCadVendSalario);
				jtfsObrig.add(jtfCadVendComissao);
				jtfsObrig.add(jtfCadVendUsuario);
				jtfsObrig.add(jtfCadVendSenha);
				
				VerificaJtfObrigatorios verificador = new VerificaJtfObrigatorios();
				Boolean todosPreenchidos = verificador.verificaJtf(jtfsObrig, descricao);
				
				Boolean valorSalarioCorreto = true;
				Boolean valorComissaoCorretor = true;
				salario = null;
				comissao = null;
				
				//verifica salario
				try {
					salario = Double.valueOf(jtfCadVendSalario.getText());
				} catch (Exception a) {
					valorSalarioCorreto = false;
					verificador.setCamposMostra(verificador.getCamposMostra() + "\n* REMOVA CARACTERES ESPECIAIS DO CAMPO SALÁRIO, EXEMPLO: , ! ? $ R$");
				}
				
				//verifica comissao
				try {
					comissao = Double.valueOf(jtfCadVendComissao.getText());
				} catch (Exception f) {
					valorComissaoCorretor = false;
					verificador.setCamposMostra(verificador.getCamposMostra() + "\n* REMOVA CARACTERES ESPECIAIS DO CAMPO COMISSÃO, EXEMPLO: , ! ? $ R$");
				}
				
				if((todosPreenchidos) && (valorSalarioCorreto) && (valorComissaoCorretor)){
					usuarioAlterar();
					GenericDAO dao = new GenericDAO();
					dao.alterar(clienteAlterar, clienteAlterar.get_id());
					EscolheMensagem escMensagem = new EscolheMensagem();
					escMensagem.mensagemSucesso("alterar_vendedor");
				}else{
					JOptionPane.showMessageDialog(null, "Os campos a baixo são de preenchimento obrigatório:" + verificador.getCamposMostra());
				}
			}
		}
			if(e.getSource() == jbtLimpar){
				int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja realmente limpar todos os campos do formulário?", "Confirmação", JOptionPane.WARNING_MESSAGE);
				if(confirmacao == 0){
					limparCampos();
				}
			}
			if(e.getSource() == jbtCancelar){
				limparCampos();
				this.dispose();
			}
			
	}
	
	public static void main(String[] args){
		new TelaAlterarPessoa();
	}
}
