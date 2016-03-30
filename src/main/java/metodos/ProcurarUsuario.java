package metodos;

import java.util.ArrayList;

import DAO.GenericDAO;
import Model.Cliente;
import Model.Usuario;

public class ProcurarUsuario {
	
	public Usuario procurar(String id) {
		GenericDAO dao = new GenericDAO();
		ArrayList<Usuario> usuarios = dao.getDao().listaQualquer(Usuario.class);
		Usuario usuarioRetorno = null;
		for(Usuario usuario:usuarios){
			if(usuario.get_id().equals(id)){
				usuarioRetorno = usuario; 
			}
		}

		
		return usuarioRetorno;
	}
	
}
