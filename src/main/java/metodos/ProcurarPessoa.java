package metodos;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import org.bson.Document;

import com.mongodb.client.MongoCursor;

import DAO.GenericDAO;
import Model.Celular;
import Model.Pessoa;

public class ProcurarPessoa {
	
	public void procurarTodos(DefaultTableModel dtm){
		GenericDAO dao = new GenericDAO();
		ArrayList<Document> cursorCelular = dao.listar(Pessoa.class, "Model.Pessoa");
		
		for(Document doc : cursorCelular){
			System.out.println(doc);
			dtm.addRow(new String[]{doc.getString("nome"), doc.getString("rg"), doc.getString("telefoneCelular")});
		}
		
		
	}

}
