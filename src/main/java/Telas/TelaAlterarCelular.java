package Telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utilitarios.EscolheMensagem;
import lombok.Getter;
import lombok.Setter;
import metodos.SubstituiCamposVazios;
import metodos.VerificaJtfObrigatorios;
import Componentes.CriaButton;
import Componentes.CriaField;
import Componentes.CriaLabel;
import Componentes.CriaPanel;
import Componentes.FieldEmUpper;
import DAO.GenericDAO;
import Model.Celular;

@Getter @Setter
public class TelaAlterarCelular extends JInternalFrame implements ActionListener, KeyListener{
	private static final long serialVersionUID = -6722056900391643613L;
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
	private static String titulo = "Alterar celular";
	private ArrayList<JTextField> jtfsObrig, jtfsVazio;
	private Map<JTextField, String> descricao;
	private Double valor;
	private Celular celularAlterar;
	
	public TelaAlterarCelular() {
		tela = getContentPane();
		setTitle("M&M Celulares - Alterar de celular");
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
		setClosable(true);
	}
	
	private void limparCampos(){
		jtfCadDescricao.setText("");
		jtfCadImei.setText("");
		jtfCadModelo.setText("");
		jtfCadEmpresa.setText("");
		jtfCadCameraFrontal.setText("");
		jtfCadCameraTraseira.setText("");
		jtfCadMemInt.setText("");
		jtfCadMemRam.setText("");
		jtfCadQtdChips.setText("");
		jtfCadTipoChip.setText("");
		jtfCadTela.setText("");
		jtfCadSistema.setText("");
		jtfCadPeso.setText("");
		jtfCadCor.setText("");
		jtfCadConectividade.setText("");
		jtfCadGarantia.setText("");
		jtfCadValor.setText("");
		jcbPossuiTV.setSelectedIndex(0);
	}
	
	private void camposObrigatoriosPadrao(){
		jtfsObrig = new ArrayList<JTextField>();
		jtfsObrig.add(jtfCadDescricao);
		jtfsObrig.add(jtfCadImei);
		jtfsObrig.add(jtfCadModelo);
		jtfsObrig.add(jtfCadEmpresa);
		jtfsObrig.add(jtfCadValor);
		
		jtfsVazio = new ArrayList<JTextField>();
		jtfsVazio.add(jtfCadCameraFrontal);
		jtfsVazio.add(jtfCadCameraTraseira);
		jtfsVazio.add(jtfCadMemInt);
		jtfsVazio.add(jtfCadMemRam);
		jtfsVazio.add(jtfCadQtdChips);
		jtfsVazio.add(jtfCadTipoChip);
		jtfsVazio.add(jtfCadTela);
		jtfsVazio.add(jtfCadSistema);
		jtfsVazio.add(jtfCadPeso);
		jtfsVazio.add(jtfCadCor);
		jtfsVazio.add(jtfCadConectividade);
		jtfsVazio.add(jtfCadGarantia);

		SubstituiCamposVazios sub = new SubstituiCamposVazios();
		sub.substitui(jtfsVazio);
		
		descricao = new HashMap<JTextField, String>();
		descricao.put(jtfCadDescricao, "* Descrição");
		descricao.put(jtfCadImei, "* IMEI");
		descricao.put(jtfCadModelo, "* Modelo");
		descricao.put(jtfCadEmpresa, "* Empresa");
		descricao.put(jtfCadValor, "* Valor(R$) - Entrada deve conter apenas números e ponto. Exemplo: 1.500");
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
		
	public void popularCampos(Celular celular){
		celularAlterar = celular;
		celularAlterar.set_id(celular.get_id());
		jtfCadDescricao.setText(celular.getDescricao());
		jtfCadImei.setText(celular.getIMEI());
		jtfCadModelo.setText(celular.getModelo());
		jtfCadEmpresa.setText(celular.getEmpresa());
		jtfCadCameraFrontal.setText(celular.getCameraFrontal());
		jtfCadCameraTraseira.setText(celular.getCameraTraseira());
		jtfCadMemInt.setText(celular.getMemoria());
		jtfCadMemRam.setText(celular.getMemoriaRAM());
		jtfCadQtdChips.setText(celular.getQuantidadeChips());
		jtfCadTipoChip.setText(celular.getTipoChip());
		jtfCadTela.setText(celular.getTamanhoDaTela());
		jtfCadSistema.setText(celular.getSistemaOperacional());
		jtfCadPeso.setText(celular.getPeso());
		jtfCadCor.setText(celular.getCor());
		jcbPossuiTV.setSelectedItem(celular.getTV());
		jtfCadConectividade.setText(celular.getConectividade());
		jtfCadGarantia.setText(celular.getGarantia());
		jtfCadValor.setText(celular.getValor().toString());
	}
	
	private void alterarCelular(){
		celularAlterar.setDescricao(jtfCadDescricao.getText());
		celularAlterar.setIMEI(jtfCadImei.getText());
		celularAlterar.setModelo(jtfCadModelo.getText());
		celularAlterar.setEmpresa(jtfCadEmpresa.getText());
		celularAlterar.setCameraFrontal(jtfCadCameraFrontal.getText());
		celularAlterar.setCameraTraseira(jtfCadCameraTraseira.getText());
		celularAlterar.setMemoria(jtfCadMemInt.getText());
		celularAlterar.setMemoriaRAM(jtfCadMemRam.getText());
		celularAlterar.setQuantidadeChips(jtfCadQtdChips.getText());
		celularAlterar.setTipoChip(jtfCadTipoChip.getText());
		celularAlterar.setTamanhoDaTela(jtfCadTela.getText());
		celularAlterar.setSistemaOperacional(jtfCadSistema.getText());
		celularAlterar.setPeso(jtfCadPeso.getText());
		celularAlterar.setCor(jtfCadCor.getText());
		celularAlterar.setTV(jcbPossuiTV.getSelectedItem().toString());
		celularAlterar.setConectividade(jtfCadConectividade.getText());
		celularAlterar.setGarantia(jtfCadGarantia.getText());
		celularAlterar.setValor(Double.valueOf(jtfCadValor.getText()));
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getComponent() == jtfCadDescricao){
			if(e.getSource() == jtfCadDescricao){
				fu.transformar(jtfCadDescricao);
			}
		}
		if(e.getComponent() == jtfCadCameraFrontal){
			if(e.getSource() == jtfCadCameraFrontal){
				fu.transformar(jtfCadCameraFrontal);
			}
		}
		if(e.getComponent() == jtfCadCameraTraseira){
			if(e.getSource() == jtfCadCameraTraseira){
				fu.transformar(jtfCadCameraTraseira);
			}
		}
		if(e.getComponent() == jtfCadMemInt){
			if(e.getSource() == jtfCadMemInt){
				fu.transformar(jtfCadMemInt);
			}
		}
		if(e.getComponent() == jtfCadMemRam){
			if(e.getSource() == jtfCadMemRam){
				fu.transformar(jtfCadMemRam);
			}
		}
		if(e.getComponent() == jtfCadGarantia){
			if(e.getSource() == jtfCadGarantia){
				fu.transformar(jtfCadGarantia);
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtSalvar){
			camposObrigatoriosPadrao();
			VerificaJtfObrigatorios verificador = new VerificaJtfObrigatorios();
			Boolean todosPreenchidos = verificador.verificaJtf(jtfsObrig, descricao);
			
			Boolean valorCorreto = true;
			valor = null;
			try {
				valor = Double.valueOf(jtfCadValor.getText());
			} catch (Exception f) {
				valorCorreto = false;
				verificador.setCamposMostra(verificador.getCamposMostra() + "* REMOVA CARACTERES ESPECIAIS DO CAMPO VALOR, EXEMPLO: , ! ? $ R$");
			}
			
			if((todosPreenchidos) && (valorCorreto)){
				alterarCelular();
				TelaInicial.getTlInicial().getDao().alterar(celularAlterar, celularAlterar.get_id());
				EscolheMensagem escMensagem = new EscolheMensagem();
				escMensagem.mensagemSucesso("alterar_celular");
			}else{
				JOptionPane.showMessageDialog(null, "Os campos a baixo são de preenchimento obrigatório:" + verificador.getCamposMostra());
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
	
	public static void main(String[] args) {
		new TelaAlterarCelular();
	}

}
