package metodos;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import utilitarios.EscolheMensagem;
import DAO.GenericDAO;
import Model.Celular;
import Model.Pessoa;

public class ListarCelular {

	public void listar(DefaultTableModel dtm) {
		GenericDAO dao = new GenericDAO();

		List<Celular> celulares = dao.listaQualquer(Pessoa.class);
		for (Celular celular : celulares) {
			dtm.addRow(new String[] { celular.getModelo(),
					celular.getEmpresa(), celular.getIMEI()});
		}
		if(dtm.getRowCount() == 0){
			EscolheMensagem escolhe = new EscolheMensagem();
			escolhe.mensagemInformativa("tabela_vazia");
		}

	}
	
}
