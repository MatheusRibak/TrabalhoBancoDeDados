package metodos;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import org.bson.Document;

import utilitarios.EscolheMensagem;
import DAO.GenericDAO;
import Model.Celular;
import Model.Pessoa;
import Model.Venda;

public class ListarVenda {

	public void listar(DefaultTableModel dtm) {
		GenericDAO dao = new GenericDAO();
		ArrayList<Object> cursor = new ArrayList<Object>();

		cursor = dao.listar(Pessoa.class, "Model.Venda");
		for (Object doc : cursor) {
			Venda venda = (Venda) doc;
			System.out.println(venda.getCelular());
			//Date data = doc.getDate("data")
			dtm.addRow(new String[] { venda.getData().toString(),
					venda.getVendedor().getPessoa().getNome(), venda.getCelular().getValor().toString()});
		}
		if(dtm.getRowCount() == 0){
			EscolheMensagem escolhe = new EscolheMensagem();
			escolhe.mensagemInformativa("tabela_vazia");
		}

	}
	
}
