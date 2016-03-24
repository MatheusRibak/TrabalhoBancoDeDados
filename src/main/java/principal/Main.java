package principal;

import java.time.Instant;
import java.util.Date;

import DAO.GenericDAO;
import Model.Endereco;
import Model.Pessoa;

public class Main {

	public static void main(String[] args) {
		GenericDAO genericDao = new GenericDAO();
		
		Endereco endereco = new Endereco();
		endereco.setRua("Irineu Bornhausen");
		endereco.setNumero("1059");
		endereco.setCidade("Ponte Serrada");
		endereco.setCep("89683-000");
		endereco.setUf("SC");
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Matheus Poletto");
		pessoa.setRg("6.413.12");
		pessoa.setCpf("987.123.122-90");
		Instant instant = Instant.now();
		pessoa.setDataNascimento(Date.from(instant));
		pessoa.setEndereco(endereco);
		pessoa.setTelefoneCelular("9955-5555");
		pessoa.setEmail("mm.poletto@gmail.com");
		
		genericDao.inserir(pessoa);
		
		
		
	}
	
}
