package metodos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Model.Cliente;
import Model.Endereco;
import Model.Pessoa;
import Telas.TelaInicial;

public class CadastroCliente {

	public Boolean cadastrar(String rua, String numero, String complemento, String bairro, String cidade,
				String uf, String cep, String nome, String sexo, String estCivil, String rg, String cpf, Date dataNascimento,
					String email, String telCelular, String telResidencial) {
		Boolean cadastrado = false;
		Endereco endereco = new Endereco();
		endereco.setRua(rua);
		endereco.setNumero(numero);
		endereco.setComplemento(complemento);
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setUf(uf);
		endereco.setCep(cep);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setSexo(sexo);
		pessoa.setEstadoCivil(estCivil);
		pessoa.setRg(rg);
		pessoa.setCpf(cpf);
		DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		pessoa.setDataNascimento(dataNascimento);
		pessoa.setEmail(email);
		pessoa.setTelefoneCelular(telCelular);
		pessoa.setTelefoneResidencial(telResidencial);
		pessoa.setEndereco(endereco);
		
		Cliente cliente = new Cliente();
		cliente.setPessoa(pessoa);
		TelaInicial.getTlInicial().getDao().inserir(cliente);
		
		cadastrado = true;
		return cadastrado;
	}

}
