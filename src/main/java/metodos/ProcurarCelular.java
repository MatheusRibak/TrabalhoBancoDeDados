package metodos;

import java.util.ArrayList;

import Model.Celular;
import Telas.TelaInicial;

public class ProcurarCelular {

	public Celular procurar(String id) {
		ArrayList<Celular> celulares = TelaInicial.getTlInicial().getDao().getDao().listaQualquer(Celular.class);
		Celular celularRetorno = null;
		for(Celular celular:celulares){
			if(celular.get_id().toString().equals(id)){
				celularRetorno = celular; 
			}
		}

		
		return celularRetorno;
	}
	
	
}
