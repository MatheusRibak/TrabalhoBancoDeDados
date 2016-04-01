package Telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Componentes.CriaButton;
import Componentes.CriaField;
import Componentes.CriaLabel;
import Componentes.CriaPanel;
import Model.Celular;
import Model.Cliente;
import Model.Usuario;
import Model.Venda;

public class TelaAlteraVenda extends JInternalFrame implements ActionListener, KeyListener{
	private static final long serialVersionUID = 6196565311877436918L;
	private Container tela;
	private JLabel jlbTituloFrame, jlbCadData, jlbCadCliente, jlbCadVendedor, jlbCadCelular,
				jlbCelImei, jlbCelModelo, jlbCelEmpresa, jlbCelValor,
				jlbCliNome, jlbCliRG, jlbCliCpf, jlbCliCidade,
				jlbUsuNome, jlbUsuLogin, jlbUsuRg, jlbUsuCpf;
	private JTextField jtfCadData, jtfCadCliente, jtfCadVendedor, jtfCadCelular,
				jtfCelImei, jtfCelModelo, jtfCelEmpresa, jtfCelValor,
				jtfCliNome, jtfCliRg, jtfCliCpf, jtfCliCidade,
				jtfUsuNome, jtfUsuLogin, jtfUsuRg, jtfUsuCpf, jtfCodigo;
	private JButton jbtCancelar;
	private CriaLabel cl = new CriaLabel();
	private CriaField cf = new CriaField();
	private CriaButton cb = new CriaButton();
	private CriaPanel cp = new CriaPanel();
	private JPanel jpnCadEssencial, jpnCelInfo, jpnCliInfo, jpnOpcoes;
	private static String titulo = "Detalhes de venda";
	private JLabel jlbOpcOpcoes, jlbCodigoVenda;
	private Date data;
	
	public TelaAlteraVenda() {
		tela = getContentPane();
		setTitle("M&M Celulares - Informação de venda");
		setLayout(null);

		jlbTituloFrame = cl.criarTitulo(titulo, jlbTituloFrame, tela);
		criarCamposCadastrado();
		
		jlbOpcOpcoes = cl.criarParaPanelCenter("Opções", 360, 5, 80, 24, jlbOpcOpcoes, tela);
		jbtCancelar = cb.criarBotao("FECHAR", 300, 33, 200, 24, jbtCancelar, tela, this);
	
		jpnOpcoes = cp.criarPanelSemTitulo(0, 350, 788, 90, jpnOpcoes, true, tela);
		jpnOpcoes.add(jlbOpcOpcoes);
		jpnOpcoes.add(jbtCancelar);
		
		tela.setBackground(Color.white);
		setSize(800, 470);
		setResizable(false);
		setVisible(true);
		setClosable(true);
	}

	private void criarCamposCadastrado() {
		jlbCodigoVenda = cl.criarLabelParaPanel("Código:", 15, 15, 80, 24, jlbCodigoVenda, tela);
		jlbCadData = cl.criarLabelParaPanel("Data:", 15, 41, 80, 24, jlbCadData, tela);
		jlbCadCelular = cl.criarLabelParaPanel("Celular:", 234, 41, 80, 24, jlbCadCelular, tela);
		jlbCadCliente = cl.criarLabelParaPanel("Cliente:", 453, 17, 80, 24, jlbCadCliente, tela);
		jlbCadVendedor = cl.criarLabelParaPanel("Vendedor:", 449, 41, 85, 24, jlbCadVendedor, tela);
		
		jtfCodigo= cf.criarTextField(100, 15, 339, 24, jtfCodigo, tela, this);
		jtfCodigo.setEnabled(false);
		jtfCodigo.setDisabledTextColor(Color.black);
		jtfCadData = cf.criarTextField(100, 40, 140, 24, jtfCadData, tela, this);
		jtfCadData.setEnabled(false);
		jtfCadData.setDisabledTextColor(Color.black);
		jtfCadCelular = cf.criarTextField(319, 40, 120, 24, jtfCadCelular, tela, this);
		jtfCadCelular.setEnabled(false);
		jtfCadCelular.setDisabledTextColor(Color.black);
		jtfCadCliente = cf.criarTextField(538, 15, 180, 24, jtfCadCliente, tela, this);
		jtfCadCliente.setEnabled(false);
		jtfCadCliente.setDisabledTextColor(Color.black);
		jtfCadVendedor = cf.criarTextField(538, 40, 180, 24, jtfCadVendedor, tela, this);
		jtfCadVendedor.setEnabled(false);
		jtfCadVendedor.setDisabledTextColor(Color.black);
	
		
		jpnCadEssencial = cp.criarPanelSemTitulo(0, 70, 788, 85, jpnCadEssencial, true, tela);
		jpnCadEssencial.add(jlbCodigoVenda);
		jpnCadEssencial.add(jlbCadData);
		jpnCadEssencial.add(jlbCadCelular);
		jpnCadEssencial.add(jlbCadCliente);	
		jpnCadEssencial.add(jlbCadVendedor);
		jpnCadEssencial.add(jtfCodigo);
		jpnCadEssencial.add(jtfCadData);	
		jpnCadEssencial.add(jtfCadCelular);	
		jpnCadEssencial.add(jtfCadCliente);
		jpnCadEssencial.add(jtfCadVendedor);
		
		jlbCelImei = cl.criarLabelParaPanel("IMEI:", 15, 25, 80, 24, jlbCelImei, tela);
		jlbCelModelo = cl.criarLabelParaPanel("Modelo:", 220, 25, 80, 24, jlbCelModelo, tela);
		jlbCelEmpresa = cl.criarLabelParaPanel("Empresa:", 410, 25, 80, 24, jlbCelEmpresa, tela);
		jlbCelValor = cl.criarLabelParaPanel("Valor (R$):", 605, 25, 85, 24, jlbCelValor, tela);
		
		jtfCelImei = cf.criarTextField(100, 25, 120, 24, jtfCelImei, tela, this);
		jtfCelImei.setText("Selecione o celular.");
		jtfCelImei.setEnabled(false);
		jtfCelImei.setDisabledTextColor(Color.black);
		jtfCelModelo = cf.criarTextField(305, 25, 100, 24, jtfCelModelo, tela, this);
		jtfCelModelo.setText("Selecione o celular.");
		jtfCelModelo.setEnabled(false);
		jtfCelModelo.setDisabledTextColor(Color.black);
		jtfCelEmpresa = cf.criarTextField(495, 25, 100, 24, jtfCelEmpresa, tela, this);
		jtfCelEmpresa.setText("Selecione o celular.");
		jtfCelEmpresa.setEnabled(false);
		jtfCelEmpresa.setDisabledTextColor(Color.black);
		jtfCelValor = cf.criarTextField(695, 25, 70, 24, jtfCelValor, tela, this);
		jtfCelValor.setText("Selecione o celular.");
		jtfCelValor.setEnabled(false);
		jtfCelValor.setDisabledTextColor(Color.black);
		
		jpnCelInfo = cp.criarPanel("Informações do celular", 0, 155, 788, 65, jpnCelInfo, true, tela);
		jpnCelInfo.add(jlbCelImei);
		jpnCelInfo.add(jlbCelModelo);	
		jpnCelInfo.add(jlbCelEmpresa);
		jpnCelInfo.add(jlbCelValor);
		jpnCelInfo.add(jtfCelImei);
		jpnCelInfo.add(jtfCelModelo);	
		jpnCelInfo.add(jtfCelEmpresa);	
		jpnCelInfo.add(jtfCelValor);	
		
		jlbCliNome = cl.criarLabelParaPanel("Nome:", 15, 25, 80, 24, jlbCliNome, tela);
		jlbCliRG = cl.criarLabelParaPanel("RG:", 220, 25, 80, 24, jlbCliRG, tela);
		jlbCliCpf = cl.criarLabelParaPanel("CPF:", 410, 25, 80, 24, jlbCliCpf, tela);
		jlbCliCidade = cl.criarLabelParaPanel("Cidade:", 585, 25, 80, 24, jlbCliCidade, tela);
		
		jtfCliNome = cf.criarTextField(100, 25, 160, 24, jtfCliNome, tela, this);
		jtfCliNome.setText("Selecione o cliente.");
		jtfCliNome.setEnabled(false);
		jtfCliNome.setDisabledTextColor(Color.black);
		jtfCliRg= cf.criarTextField(305, 25, 100, 24, jtfCliRg, tela, this);
		jtfCliRg.setText("Selecione o cliente.");
		jtfCliRg.setEnabled(false);
		jtfCliRg.setDisabledTextColor(Color.black);
		jtfCliCpf = cf.criarTextField(495, 25, 100, 24, jtfCliCpf, tela, this);
		jtfCliCpf.setText("Selecione o cliente.");
		jtfCliCpf.setEnabled(false);
		jtfCliCpf.setDisabledTextColor(Color.black);
		jtfCliCidade = cf.criarTextField(670, 25, 98, 24, jtfCliCidade, tela, this);
		jtfCliCidade.setText("Selecione o cliente.");
		jtfCliCidade.setEnabled(false);
		jtfCliCidade.setDisabledTextColor(Color.black);
		
		jpnCliInfo = cp.criarPanel("Informações do cliente", 0, 220, 788, 65, jpnCliInfo, true, tela);
		jpnCliInfo.add(jlbCliNome);
		jpnCliInfo.add(jlbCliRG);	
		jpnCliInfo.add(jlbCliCpf);
		jpnCliInfo.add(jlbCliCidade);
		jpnCliInfo.add(jtfCliNome);
		jpnCliInfo.add(jtfCliRg);	
		jpnCliInfo.add(jtfCliCpf);	
		jpnCliInfo.add(jtfCliCidade);	
		
		jlbUsuNome = cl.criarLabelParaPanel("Nome:", 15, 25, 80, 24, jlbUsuNome, tela);
		jlbUsuLogin = cl.criarLabelParaPanel("Usuário:", 255, 25, 80, 24, jlbUsuLogin, tela);
		jlbUsuRg = cl.criarLabelParaPanel("RG:", 410, 25, 80, 24, jlbUsuRg, tela);
		jlbUsuCpf = cl.criarLabelParaPanel("CPF:", 585, 25, 80, 24, jlbUsuCpf, tela);
		
		jtfUsuNome = cf.criarTextField(100, 25, 160, 24, jtfUsuNome, tela, this);
		jtfUsuNome.setText("Selecione o vendedor.");
		jtfUsuNome.setEnabled(false);
		jtfUsuNome.setDisabledTextColor(Color.black);
		jtfUsuLogin= cf.criarTextField(340, 25, 100, 24, jtfUsuLogin, tela, this);
		jtfUsuLogin.setText("Selecione o vendedor.");
		jtfUsuLogin.setEnabled(false);
		jtfUsuLogin.setDisabledTextColor(Color.black);
		jtfUsuRg = cf.criarTextField(495, 25, 100, 24, jtfUsuRg, tela, this);
		jtfUsuRg.setText("Selecione o vendedor.");
		jtfUsuRg.setEnabled(false);
		jtfUsuRg.setDisabledTextColor(Color.black);
		jtfUsuCpf = cf.criarTextField(670, 25, 98, 24, jtfUsuCpf, tela, this);
		jtfUsuCpf.setText("Selecione o vendedor.");
		jtfUsuCpf.setEnabled(false);
		jtfUsuCpf.setDisabledTextColor(Color.black);
		
		jpnCliInfo = cp.criarPanel("Informações do vendedor", 0, 285, 788, 65, jpnCliInfo, true, tela);
		jpnCliInfo.add(jlbUsuNome);
		jpnCliInfo.add(jlbUsuLogin);	
		jpnCliInfo.add(jlbUsuRg);
		jpnCliInfo.add(jlbUsuCpf);
		jpnCliInfo.add(jtfUsuNome);
		jpnCliInfo.add(jtfUsuLogin);	
		jpnCliInfo.add(jtfUsuRg);	
		jpnCliInfo.add(jtfUsuCpf);	
	}
	
	public void popularVenda(Venda venda){
		jtfCodigo.setText(venda.get_id().toString());
		String dataConvertida = String.valueOf(venda.getData().toInstant());
		String leng = "";
		leng = dataConvertida.substring(0, 10);
		jtfCadData.setText(leng);
		jtfCadCelular.setText(venda.getCelular().getIMEI());
		jtfCadCliente.setText(venda.getCliente().getPessoa().getNome());
		jtfCadVendedor.setText(venda.getUsuario().getVendedor().getPessoa().getNome());
		
		popularCelular(venda.getCelular());
		popularCliente(venda.getCliente());
		popularVendedor(venda.getUsuario());
	}

	public void popularCelular(Celular celular){
		jtfCadCelular.setText(celular.getIMEI());
		jtfCelImei.setText(celular.getIMEI());
		jtfCelModelo.setText(celular.getModelo());
		jtfCelEmpresa.setText(celular.getEmpresa());
		jtfCelValor.setText(celular.getValor().toString());
	}
	
	public void popularCliente(Cliente cliente){
		jtfCadCliente.setText(cliente.getPessoa().getNome());
		jtfCliNome.setText(cliente.getPessoa().getNome());
		jtfCliRg.setText(cliente.getPessoa().getRg());
		jtfCliCpf.setText(cliente.getPessoa().getCpf());
		jtfCliCidade.setText(cliente.getPessoa().getEndereco().getCidade());
	}
	
	public void popularVendedor(Usuario vendedor){
		jtfCadVendedor.setText(vendedor.getVendedor().getPessoa().getNome());
		jtfUsuNome.setText(vendedor.getVendedor().getPessoa().getNome());
		jtfUsuLogin.setText(vendedor.getLogin());
		jtfUsuRg.setText(vendedor.getVendedor().getPessoa().getRg());
		jtfUsuCpf.setText(vendedor.getVendedor().getPessoa().getCpf());
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
		if(e.getSource() == jbtCancelar){
			//TelaInicial.getTlInicial().getTlAlterarVenda();
		}
	}
	
	
	public static void main(String[] args) {
		new TelaAlteraVenda();
	}
}