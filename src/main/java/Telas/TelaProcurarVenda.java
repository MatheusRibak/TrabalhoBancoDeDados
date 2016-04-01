package Telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import metodos.ListarVenda;
import metodos.ProcurarCelular;
import metodos.ProcurarVenda;
import Componentes.CriaButton;
import Componentes.CriaField;
import Componentes.CriaLabel;
import Componentes.CriaPanel;
import Componentes.FieldEmUpper;
import Model.Celular;
import Model.Venda;

public class TelaProcurarVenda extends JInternalFrame implements ActionListener, KeyListener{
	private static final long serialVersionUID = -9172268853152388303L;
	private JLabel jlbTituloFrame, jlbProCliente, jlbProVendedor, jlbOpcOpcoes;
	private JPanel jpnCamposBusca, jpnOpcoes;
	private CriaLabel cl = new CriaLabel();
	private CriaPanel cp = new CriaPanel();
	private CriaField cf = new CriaField();
	private CriaButton cb = new CriaButton();
	FieldEmUpper fu = new FieldEmUpper();
	private JTextField jtfProCliente, jtfProVendedor;
	private JButton jbtProcurar, jbtNovo, jbtExcluir, jbtDetalhes;
	private Container tela;
	private JTable jtbVendas;
	private DefaultTableModel dtmVendas = new DefaultTableModel();
	private static String titulo = "Procurar por venda";
	
	public TelaProcurarVenda() {
		tela = getContentPane();
		setTitle("M&M Celulares - Procurar venda");
		setLayout(null);
		
		jlbTituloFrame = cl.criarTitulo(titulo, jlbTituloFrame, tela);
		criarCamposBusca();
		criarTabela();
		criarOpcoesResultado();
				
		tela.setBackground(Color.white);
		setSize(800, 587);
		setResizable(false);
		setVisible(true);
		setClosable(true);
	}
	
	private void criarOpcoesResultado() {
		jlbOpcOpcoes = cl.criarParaPanelCenter("Opções", 360, 5, 80, 24, jlbOpcOpcoes, tela);
		jbtDetalhes = cb.criarBotao("Detalhes", 300, 33, 100, 24, jbtDetalhes, tela, this);
		jbtExcluir = cb.criarBotao("Excluir", 400, 33, 100, 24, jbtExcluir, tela, this);
		
		jpnOpcoes = cp.criarPanelSemTitulo(0, 470, 800, 90, jpnOpcoes, true, tela);
		jpnOpcoes.add(jlbOpcOpcoes);
		jpnOpcoes.add(jbtDetalhes);
		jpnOpcoes.add(jbtExcluir);
	}

	private void criarTabela() {
		ArrayList<String> colunas = new ArrayList<String>();
		colunas.add("ID");
		colunas.add("CLIENTE");
		colunas.add("VENDEDOR");
		colunas.add("VALOR(R$)");
		
		jtbVendas = new JTable();
		tela.add(jtbVendas);
		dtmVendas = new DefaultTableModel();
		for (String colNome : colunas) {
			dtmVendas.addColumn(colNome);
		}
		jtbVendas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtbVendas.setModel(dtmVendas);
		JScrollPane jsp = new JScrollPane(jtbVendas);
		jsp.setBounds(0, 170, 800, 300);
		jsp.setVisible(true);
		tela.add(jsp);	
	}

	private void criarCamposBusca() {
		jlbProCliente = cl.criarLabelParaPanel("Cliente:", 5, 15, 90, 24, jlbProCliente, tela);
		jlbProVendedor = cl.criarLabelParaPanel("Vendedor:", 5, 39, 90, 24, jlbProVendedor, tela);
		
		jtfProCliente = cf.criarTextField(100, 15, 600, 24, jtfProCliente, tela, this);
		jtfProVendedor = cf.criarTextField(100, 39, 600, 24, jtfProVendedor, tela, this);
		
		jbtNovo = cb.criarBotao("Novo", 500, 63, 100, 24, jbtNovo, tela, this);
		jbtProcurar = cb.criarBotao("Procurar", 600, 63, 100, 24, jbtProcurar, tela, this);	
		
		jpnCamposBusca = cp.criarPanelSemTitulo(0, 70, 800, 100, jpnCamposBusca, true, tela);
		jpnCamposBusca.add(jlbProCliente);
		jpnCamposBusca.add(jtfProCliente);
		jpnCamposBusca.add(jlbProVendedor);
		jpnCamposBusca.add(jtfProVendedor);
		jpnCamposBusca.add(jbtNovo);
		jpnCamposBusca.add(jbtProcurar);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getComponent() == jtfProCliente){
			if(e.getSource() == jtfProCliente){
				fu.transformar(jtfProCliente);
			}
		}
		if(e.getComponent() == jtfProVendedor){
			if(e.getSource() == jtfProVendedor){
				fu.transformar(jtfProVendedor);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == jbtProcurar){
			ListarVenda lv = new ListarVenda();
			lv.listar(dtmVendas, jtfProCliente.getText(), jtfProVendedor.getText());	
		}
		if(evt.getSource() == jbtDetalhes){
			if(jtbVendas.getSelectedRow() != -1){
				String id = String.valueOf(dtmVendas.getValueAt(jtbVendas.getSelectedRow(), 0));
				ProcurarVenda pv = new ProcurarVenda();
				Venda venda = pv.procurar(id);
				TelaInicial.getTlInicial().esconderTelas();
				TelaInicial.getTlInicial().getTlAlterarVenda().setVisible(true);
				TelaInicial.getTlInicial().getTlAlterarVenda().popularVenda(venda);
			}else{
				JOptionPane.showMessageDialog(null, "Selecione uma venda para carregar os detalhes!", "Informação", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(evt.getSource() == jbtExcluir){
			if(jtbVendas.getSelectedRow() != -1){
			String id = String.valueOf(dtmVendas.getValueAt(jtbVendas.getSelectedRow(), 0));
			ProcurarVenda pv = new ProcurarVenda();
			Venda venda = pv.procurar(id);
			ListarVenda lv = new ListarVenda();
			Object objetoVenda = venda;
			TelaInicial.getTlInicial().getDao().getDao().remove(objetoVenda, venda.get_id());
			lv.listar(dtmVendas, jtfProCliente.getText(), jtfProVendedor.getText());
			}else{
				JOptionPane.showMessageDialog(null, "Selecione uma venda para excluir!", "Informação", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(evt.getSource() == jbtNovo){
			TelaInicial.getTlInicial().esconderTelas();
			TelaInicial.getTlInicial().getTlCadastrarVenda().setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new TelaProcurarVenda();
	}
}