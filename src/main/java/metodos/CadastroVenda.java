package metodos;

import java.util.Date;

import Model.Celular;
import Model.Cliente;
import Model.Usuario;
import Model.Venda;
import Telas.TelaInicial;

public class CadastroVenda {
	
	public Boolean cadastrar(Date data, Cliente cliente, Usuario usuario, Celular celular) {
		Boolean cadastrado = false;
		Venda venda = new Venda();
		//alterar situacao do celular p/ n ser exibido mais
		celular.setSituacao("N");
		Object objetoCelularAlterar = celular;
		TelaInicial.getTlInicial().getDao().getDao().alterar(objetoCelularAlterar, celular.get_id());
		venda.setCelular(celular);
		venda.setCliente(cliente);
		venda.setUsuario(usuario);
		venda.setData(data);
		TelaInicial.getTlInicial().getDao().getDao().inserir(venda);
		cadastrado = true;
		return cadastrado;
	}
}
