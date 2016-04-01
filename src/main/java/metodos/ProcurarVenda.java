package metodos;

import java.util.ArrayList;
import Model.Venda;
import Telas.TelaInicial;

public class ProcurarVenda {

	public Venda procurar(String id) {
		ArrayList<Venda> vendas = TelaInicial.getTlInicial().getDao().listaQualquer(Venda.class);
		Venda vendaRetorno = null;
		for(Venda venda: vendas){
			if(venda.get_id().toString().equals(id)){
				vendaRetorno = venda; 
			}
		}
		return vendaRetorno;
	}
}