package metodos;

import java.util.ArrayList;
import Model.Cliente;
import Telas.TelaInicial;

public class ProcurarCliente {

	public Cliente procurar(String id) {
		ArrayList<Cliente> clientes = TelaInicial.getTlInicial().getDao().listaQualquer(Cliente.class);
		Cliente clienteRetorno = null;
		for(Cliente cliente:clientes){
			if(cliente.get_id().toString().equals(id)){
				clienteRetorno = cliente; 
			}
		}
		return clienteRetorno;
	}
}
