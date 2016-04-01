package metodos;

import java.util.ArrayList;

import Model.Usuario;
import Telas.TelaInicial;

public class ProcurarUsuario {
	
	public Usuario procurar(String id) {
		ArrayList<Usuario> usuarios = TelaInicial.getTlInicial().getDao().listaQualquer(Usuario.class);
		Usuario usuarioRetorno = null;
		for(Usuario usuario:usuarios){
			if(usuario.get_id().toString().equals(id)){
				usuarioRetorno = usuario; 
			}
		}
		return usuarioRetorno;
	}
}