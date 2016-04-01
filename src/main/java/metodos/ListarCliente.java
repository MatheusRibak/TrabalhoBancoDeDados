package metodos;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Model.Cliente;
import Model.Usuario;
import Telas.TelaInicial;

public class ListarCliente {
	
	public void listar(DefaultTableModel dtm, String nome, String rg) {
		dtm.setRowCount(0);

		ArrayList<Cliente> clientes = TelaInicial.getTlInicial().getDao().getDao().listaQualquer(Cliente.class);

		for (Cliente cliente : clientes) {
			if ((nome.isEmpty()) && (rg.isEmpty())) {
				dtm.addRow(new String[] {cliente.get_id().toString(),cliente.getPessoa().getNome(),
						cliente.getPessoa().getRg(),
						cliente.getPessoa().getTelefoneCelular(), "CLIENTE" });
			}
		}

		if (nome.isEmpty()) {
			nome = "Não procurar $_$-$31";
		} else {
			nome = nome;
		}
		if (rg.isEmpty()) {
			rg = "Não procurar $_$-$31";
		} else {
			rg = rg;
		}

		for (Cliente cliente : clientes) {
			if (cliente.getPessoa().getNome().contains(nome.toUpperCase())
					|| (cliente.getPessoa().getRg().contains(rg.toUpperCase()))) {
				dtm.addRow(new String[] { cliente.get_id().toString(), cliente.getPessoa().getNome(),
						cliente.getPessoa().getRg(),
						cliente.getPessoa().getTelefoneCelular(), "CLIENTE" });
			}
		}

	}
}
