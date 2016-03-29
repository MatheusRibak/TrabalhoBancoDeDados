package metodos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import utilitarios.EscolheMensagem;
import DAO.GenericDAO;
import Model.Celular;
import Model.Pessoa;

public class ListarPessoa {

	public void listar(DefaultTableModel dtm, String nome) {
		GenericDAO dao = new GenericDAO();

		Object objeto = dao.listaFiltro(Pessoa.class, "nome", nome);
		Pessoa pessoa = new Pessoa();
		pessoa = (Pessoa) objeto;
		System.out.println(pessoa.getNome().toString());
		
		dtm.addRow(new String[] { pessoa.getNome(), pessoa.getRg(), pessoa.getTelefoneCelular()});
		
		
		
	}
}
