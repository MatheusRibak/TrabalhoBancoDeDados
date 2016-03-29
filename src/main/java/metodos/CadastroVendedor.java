package metodos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import menu.Opcoes;
import DAO.GenericDAO;
import Model.Endereco;
import Model.Pessoa;
import Model.Usuario;
import Model.Vendedor;

public class CadastroVendedor {

	public Boolean cadastrar(String rua, String numero, String bairro, String cidade,
			String uf, String cep, String nome, String sexo, String estCivil, String rg, String cpf, Date dataNascimento,
				String email, String telCelular, String telResidencial, Double comissao, Double salario,
				 	String login, String senha, int nivelAcesso) {
		Boolean cadastrou = false;
		Endereco endereco = new Endereco();
		endereco.setRua(rua);
		endereco.setNumero(numero);
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
		pessoa.setDataNascimento(dataNascimento);
		pessoa.setEmail(email);
		pessoa.setTelefoneCelular(telCelular);
		pessoa.setEndereco(endereco);
		Vendedor vendedor = new Vendedor();
		vendedor.setPessoa(pessoa);
		vendedor.setComissao(comissao);
		vendedor.setSalario(salario);
		Usuario usuario = new Usuario();
		usuario.setVendedor(vendedor);
		usuario.setNivelAcesso(nivelAcesso);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		GenericDAO dao = new GenericDAO();
		dao.inserir(usuario);
		return cadastrou = true;
	}

}
