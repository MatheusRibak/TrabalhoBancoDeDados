package metodos;

import java.util.ArrayList;

import DAO.GenericDAO;
import Model.Cliente;

public class ProcurarCliente {

	public Cliente procurar(String id) {
		GenericDAO dao = new GenericDAO();
		ArrayList<Cliente> clientes = dao.getDao().listaQualquer(Cliente.class);
		Cliente clienteRetorno = null;
		for(Cliente cliente:clientes){
			if(cliente.get_id().equals(id)){
				clienteRetorno = cliente; 
			}
		}

		
		return clienteRetorno;
	}
	
}
