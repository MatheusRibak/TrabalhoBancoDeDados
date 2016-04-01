package metodos;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Model.Usuario;
import Telas.TelaInicial;

public class ListarUsuario {
	
	public void listar(DefaultTableModel dtm, String nomeBk, String rgbk) {
		dtm.setRowCount(0);

		ArrayList<Usuario> usuarios = TelaInicial.getTlInicial().getDao().getDao().listaQualquer(Usuario.class);

		for (Usuario usuario : usuarios) {
			if ((nomeBk.isEmpty()) && rgbk.isEmpty()) {
				dtm.addRow(new String[] {usuario.get_id().toString(),
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
				dtm.addRow(new String[] {usuario.get_id().toString(),
						usuario.getVendedor().getPessoa().getNome(),
						usuario.getVendedor().getPessoa().getRg(),
						usuario.getVendedor().getPessoa().getTelefoneCelular(),
						"VENDEDOR" });
			}
		}
	}


}
