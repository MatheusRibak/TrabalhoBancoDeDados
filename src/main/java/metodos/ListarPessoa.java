package metodos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.bson.Document;

import utilitarios.EscolheMensagem;
import utilitarios.MensagemInformativa;
import DAO.GenericDAO;
import Model.Pessoa;
import Model.Venda;

public class ListarPessoa {

	public void listar(DefaultTableModel dtm) {
		GenericDAO dao = new GenericDAO();
		/*ArrayList<Document> cursor = new ArrayList<Document>();

		cursor = dao.listar(Pessoa.class, "Model.Pessoa");
		for (Document doc : cursor) {
			dtm.addRow(new String[] { doc.getString("nome"),
					doc.getString("rg"), doc.getString("telefoneCelular") });
		}
		if(dtm.getRowCount() == 0){
			EscolheMensagem escolhe = new EscolheMensagem();
			escolhe.mensagemInformativa("tabela_vazia");
		}*/
		
		List<Pessoa> pessoas = dao.listaQualquer(Pessoa.class);
		for (Pessoa pessoa : pessoas) {
			dtm.addRow(new String[] { pessoa.getNome(),
					pessoa.getRg(), pessoa.getTelefoneCelular()});
		}
		if(dtm.getRowCount() == 0){
			EscolheMensagem escolhe = new EscolheMensagem();
			escolhe.mensagemInformativa("tabela_vazia");
		}
		

	}
}
