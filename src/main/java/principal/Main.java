package principal;

import DAO.GenericDAO;
import Model.Endereco;

public class Main {

	public static void main(String[] args) {
		GenericDAO genericDao = new GenericDAO();
		
		Endereco endereco = new Endereco();
		endereco.setRua("Irineu Bornhausen");
		endereco.setNumero("1059");
		endereco.setCidade("Ponte Serrada");
		endereco.setCep("89683-000");
		endereco.setUf("SC");
		genericDao.inserir(endereco);
		
	}
	
}
