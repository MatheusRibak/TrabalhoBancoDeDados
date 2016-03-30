package metodos;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import DAO.GenericDAO;
import Model.Cliente;
import Model.Usuario;

public class ListarPessoa {

	public void listar(DefaultTableModel dtm, String nome, String rg) {
		GenericDAO dao = new GenericDAO();
		// só funciona se tiver um, arrumar
		/*
		 * (Object objeto = dao.listaFiltro(Pessoa.class, "nome", nome); Pessoa
		 * pessoa = new Pessoa(); pessoa = (Pessoa) objeto;
		 */
		dtm.setRowCount(0);

		ArrayList<Cliente> clientes = dao.getDao().listaQualquer(Cliente.class);
		ArrayList<Usuario> usuarios = dao.getDao().listaQualquer(Usuario.class);

		for (Cliente cliente : clientes) {
			if ((nome.isEmpty()) && (rg.isEmpty())) {
				dtm.addRow(new String[] {cliente.get_id(),cliente.getPessoa().getNome(),
						cliente.getPessoa().getRg(),
						cliente.getPessoa().getTelefoneCelular(), "CLIENTE" });
			}
		}

		String nomeBk = nome, rgbk = rg;

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
				dtm.addRow(new String[] { cliente.getPessoa().get_id(), cliente.getPessoa().getNome(),
						cliente.getPessoa().getRg(),
						cliente.getPessoa().getTelefoneCelular(), "CLIENTE" });
			}
		}
		
		for (Usuario usuario : usuarios) {
			if ((nomeBk.isEmpty()) && rgbk.isEmpty()) {
				dtm.addRow(new String[] {usuario.get_id(),
						usuario.getVendedor().getPessoa().getNome(),
						usuario.getVendedor().getPessoa().getRg(),
						usuario.getVendedor().getPessoa().getTelefoneCelular(),
						"VENDEDOR" });
			}
		}
		
		if (nomeBk.isEmpty()) {
			nomeBk = "Não procurar $_$-$31";
		} else {
			nomeBk = nomeBk;
		}
		if (rgbk.isEmpty()) {
			rgbk = "Não procurar $_$-$31";
		} else {
			rgbk = rgbk;
		}

		for (Usuario usuario : usuarios) {
			if ((usuario.getVendedor().getPessoa().getNome().contains(nomeBk
					.toUpperCase()))
					|| usuario.getVendedor().getPessoa().getRg()
							.contains(rgbk.toUpperCase())) {
				dtm.addRow(new String[] {usuario.get_id(),
						usuario.getVendedor().getPessoa().getNome(),
						usuario.getVendedor().getPessoa().getRg(),
						usuario.getVendedor().getPessoa().getTelefoneCelular(),
						"VENDEDOR" });
			}
		}
	}

}
