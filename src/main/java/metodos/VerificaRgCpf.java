package metodos;

import java.util.ArrayList;

import DAO.GenericDAO;
import Model.Pessoa;

public class VerificaRgCpf {

	public Boolean verificar(String rg, String cpf) {
		Boolean ok = true;
		GenericDAO dao = new GenericDAO();
		ArrayList<Pessoa> pessoas = dao.getDao().listaQualquer(Pessoa.class);
		for (Pessoa pessoa : pessoas) {
			if ((pessoa.getRg() == rg) || (pessoa.getCpf() == cpf)) {
				ok = false;
			}
		}

		return ok;
	}
}
