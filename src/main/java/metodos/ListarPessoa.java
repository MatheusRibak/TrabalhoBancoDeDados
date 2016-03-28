package metodos;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import utilitarios.EscolheMensagem;
import DAO.GenericDAO;
import Model.Pessoa;

public class ListarPessoa {

	public void listar(DefaultTableModel dtm) {
		GenericDAO dao = new GenericDAO();
		
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
