package metodos;

import javax.swing.table.DefaultTableModel;

import DAO.GenericDAO;
import Model.Pessoa;

public class ProcurarPessoa {
	
	public void procurarTodos(DefaultTableModel dtm){
		GenericDAO dao = new GenericDAO();
		dao.listar(Pessoa.class, "Model.Pessoa");
	}

}
