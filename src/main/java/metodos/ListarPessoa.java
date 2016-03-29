package metodos;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import DAO.GenericDAO;
import Model.Cliente;
import Model.Usuario;

public class ListarPessoa {

	public void listar(DefaultTableModel dtm, String nome) {
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
			if (nome.isEmpty()) {
				dtm.addRow(new String[] { cliente.getPessoa().getNome(),
						cliente.getPessoa().getRg(),
						cliente.getPessoa().getTelefoneCelular(), "CLIENTE" });
			} else {
				if (cliente.getPessoa().getNome().contains(nome.toUpperCase())) {
					dtm.addRow(new String[] { cliente.getPessoa().getNome(),
							cliente.getPessoa().getRg(),
							cliente.getPessoa().getTelefoneCelular(), "CLIENTE" });
				}
			}

		}

		for (Usuario usuario : usuarios) {
			if (nome.isEmpty()) {
				dtm.addRow(new String[] {
						usuario.getVendedor().getPessoa().getNome(),
						usuario.getVendedor().getPessoa().getRg(),
						usuario.getVendedor().getPessoa().getTelefoneCelular(),
						"VENDEDOR" });
			} else {
				if (usuario.getVendedor().getPessoa().getNome()
						.contains(nome.toUpperCase())) {
					dtm.addRow(new String[] {
							usuario.getVendedor().getPessoa().getNome(),
							usuario.getVendedor().getPessoa().getRg(),
							usuario.getVendedor().getPessoa()
									.getTelefoneCelular(), "VENDEDOR" });
				}
			}
		}

	}
}
