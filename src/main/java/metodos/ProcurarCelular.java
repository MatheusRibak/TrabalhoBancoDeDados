package metodos;

import java.util.ArrayList;

import DAO.GenericDAO;
import Model.Celular;

public class ProcurarCelular {

	public Celular procurar(String id) {
		GenericDAO dao = new GenericDAO();
		ArrayList<Celular> celulares = dao.getDao().listaQualquer(Celular.class);
		Celular celularRetorno = null;
		for(Celular celular:celulares){
			if(celular.get_id().equals(id)){
				celularRetorno = celular; 
			}
		}

		
		return celularRetorno;
	}
	
	
}
