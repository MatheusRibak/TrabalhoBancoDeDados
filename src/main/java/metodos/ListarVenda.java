package metodos;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import utilitarios.EscolheMensagem;
import DAO.GenericDAO;
import Model.Venda;

public class ListarVenda {

	public void listar(DefaultTableModel dtm) {
		GenericDAO dao = new GenericDAO();

		List<Venda> vendas = dao.listaQualquer(Venda.class);
		for (Venda venda : vendas) {
			dtm.addRow(new String[] { venda.getData().toString(),
					venda.getVendedor().getPessoa().getNome(), venda.getCelular().getValor().toString()});
		}
		if(dtm.getRowCount() == 0){
			EscolheMensagem escolhe = new EscolheMensagem();
			escolhe.mensagemInformativa("tabela_vazia");
		}

	}
	
}
