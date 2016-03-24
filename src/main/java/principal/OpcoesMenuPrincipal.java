package principal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import DAO.GenericDAO;
import Model.Cliente;
import Model.Endereco;
import Model.Pessoa;
import Model.Vendedor;

public class OpcoesMenuPrincipal {
	Opcoes opcoes = new Opcoes();
	Scanner sc = new Scanner(System.in);

	protected void menuPrincipal() {
		int escolha = sc.nextInt();
		// limparConsole();
		switch (escolha) {
		case 1:
			cadastrarCliente();
			break;
		case 2:
			cadastrarVendedor();
			break;
		case 3:
			System.out.println("Teclou 3");
			opcoes.voltarMenuPrincipal();
			break;
		case 4:
			System.out.println("Teclou 4");
			opcoes.voltarMenuPrincipal();
			break;
		case 5:
			System.out.println("Teclou 5");
			opcoes.voltarMenuPrincipal();
			break;
		default:
			opcoes.opcaoNaoEncontrada();
			break;
		}
	}

	private void cadastrarCliente() {
		opcoes.limparConsole();
		System.out.println("\t[CADASTRO DE CLIENTE]");
		System.out.print("Insira o nome: ");
		String nome = sc.nextLine();
		nome = sc.nextLine();
		System.out.print("Insira o RG: ");
		String rg = sc.nextLine();
		System.out.print("Insira o CPF: ");
		String cpf = sc.nextLine();
		System.out.print("Insira a data de nascimento mo formato M�s/Dia/Ano(12/29/16): ");
		String dataNascimento = sc.nextLine();
		System.out.print("Insira o email: ");
		String email = sc.nextLine();
		System.out.print("Insira o telefone celular: ");
		String telCelular = sc.nextLine();
		System.out.print("\nInsira a rua: ");
		String rua = sc.nextLine();
		System.out.print("Insira o n�mero: ");
		String numero = sc.nextLine();
		System.out.print("Insira o bairro: ");
		String bairro = sc.nextLine();
		System.out.print("Insira a cidade: ");
		String cidade = sc.nextLine();
		System.out.print("Insira a UF: ");
		String uf = sc.nextLine();
		System.out.print("Insira o CEP: ");
		String cep = sc.nextLine();
		
		System.out.println("\n\t[CONFIRME OS DADOS]");
		System.out.println("Nome: " + nome);
		System.out.println("RG: " + rg);
		System.out.println("CPF: " + cpf);
		System.out.println("Data de nascimento: " + dataNascimento);
		System.out.println("Email: " + email);
		System.out.println("Telefone: " + telCelular);
		System.out.println("Rua: " + rua);
		System.out.println("N�mero: " + numero);
		System.out.println("Bairro: " + bairro);
		System.out.println("Cidade: " + cidade);
		System.out.println("UF: " + uf);
		System.out.println("CEP: " + cep);
		
		System.out.print("\tDigite [S] para Salvar ou [C] para Cancelar... ");
		String opcao = sc.nextLine();
		if(opcao.equalsIgnoreCase("s")){
			// SALVA O ENDERE�O > CLIENTE
			Endereco endereco = new Endereco();
			endereco.setRua(rua);
			endereco.setNumero(numero);
			endereco.setBairro(bairro);
			endereco.setCidade(cidade);
			endereco.setUf(uf);
			endereco.setCep(cep);
			Pessoa pessoa = new Pessoa();
			pessoa.setNome(nome);
			pessoa.setRg(rg);
			pessoa.setCpf(cpf);
			DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
			Date dataNasc = null;
			try {
				dataNasc = (Date)formatter.parse(dataNascimento);
			} catch (ParseException e) {
				System.out.println("Erro na convers�o da data de nascimento!");
				opcoes.limparConsole();
				opcoes.voltarMenuPrincipal();
			}
			pessoa.setDataNascimento(dataNasc);
			pessoa.setEmail(email);
			pessoa.setTelefoneCelular(telCelular);
			pessoa.setEndereco(endereco);
			Cliente cliente = new Cliente();
			cliente.setPessoa(pessoa);
			GenericDAO dao = new GenericDAO();
			dao.inserir(cliente);
			System.out.println("Cadastro concl�ido com sucesso!\n");	
			opcoes.voltarMenuPrincipal();
			
		}else{
			//LIMPA CONSOLE - PODE COME�AR NOVO CADASTRO
			opcoes.limparConsole();
			System.out.println("\nDeseja come�ar um novo CADASTRO DE CLIENTE?");
			System.out.println("Digite [S] para Sim e [N] para n�o");
			opcao = sc.nextLine();
			if(opcao.equalsIgnoreCase("s")){
				cadastrarCliente();
			}else{
				opcoes.voltarMenuPrincipal();
			}
		}
	}
	
	private void cadastrarVendedor() {
		opcoes.limparConsole();
		System.out.println("\t[CADASTRO DE VENDEDOR]");
		System.out.print("Insira o nome: ");
		String nome = sc.nextLine();
		nome = sc.nextLine();
		System.out.print("Insira o RG: ");
		String rg = sc.nextLine();
		System.out.print("Insira o CPF: ");
		String cpf = sc.nextLine();
		System.out.print("Insira a data de nascimento mo formato M�s/Dia/Ano(12/29/16): ");
		String dataNascimento = sc.nextLine();
		System.out.print("Insira o email: ");
		String email = sc.nextLine();
		System.out.print("Insira o telefone celular: ");
		String telCelular = sc.nextLine();
		System.out.print("\nInsira a rua: ");
		String rua = sc.nextLine();
		System.out.print("Insira o n�mero: ");
		String numero = sc.nextLine();
		System.out.print("Insira o bairro: ");
		String bairro = sc.nextLine();
		System.out.print("Insira a cidade: ");
		String cidade = sc.nextLine();
		System.out.print("Insira a UF: ");
		String uf = sc.nextLine();
		System.out.print("Insira o CEP: ");
		String cep = sc.nextLine();
		System.out.print("\nInsira a comiss�o: ");
		Double comissao = sc.nextDouble();
		System.out.print("Insira o sal�rio: R$");
		Double salario = sc.nextDouble();
		
		System.out.println("\n\t[CONFIRME OS DADOS]");
		System.out.println("Nome: " + nome);
		System.out.println("RG: " + rg);
		System.out.println("CPF: " + cpf);
		System.out.println("Data de nascimento: " + dataNascimento);
		System.out.println("Email: " + email);
		System.out.println("Telefone: " + telCelular);
		System.out.println("Rua: " + rua);
		System.out.println("N�mero: " + numero);
		System.out.println("Bairro: " + bairro);
		System.out.println("Cidade: " + cidade);
		System.out.println("UF: " + uf);
		System.out.println("CEP: " + cep);
		System.out.println("Comiss�o: " + comissao);
		System.out.println("Sal�rio: R$" + salario);
		
		System.out.print("\tDigite [S] para Salvar ou [C] para Cancelar... ");
		String opcao = sc.nextLine();
		opcao = sc.nextLine();
		if(opcao.equalsIgnoreCase("s")){
			// SALVA ENDERE�O > PESSOA > VENDEDOR
			Endereco endereco = new Endereco();
			endereco.setRua(rua);
			endereco.setNumero(numero);
			endereco.setBairro(bairro);
			endereco.setCidade(cidade);
			endereco.setUf(uf);
			endereco.setCep(cep);
			Pessoa pessoa = new Pessoa();
			pessoa.setNome(nome);
			pessoa.setRg(rg);
			pessoa.setCpf(cpf);
			DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
			Date dataNasc = null;
			try {
				dataNasc = (Date)formatter.parse(dataNascimento);
			} catch (ParseException e) {
				System.out.println("Erro na convers�o da data de nascimento!");
				opcoes.limparConsole();
				opcoes.voltarMenuPrincipal();
			}
			pessoa.setDataNascimento(dataNasc);
			pessoa.setEmail(email);
			pessoa.setTelefoneCelular(telCelular);
			pessoa.setEndereco(endereco);
			Vendedor vendedor = new Vendedor();
			vendedor.setPessoa(pessoa);
			vendedor.setComissao(comissao);
			vendedor.setSalario(salario);
			GenericDAO dao = new GenericDAO();
			dao.inserir(vendedor);
			System.out.println("Cadastro concl�ido com sucesso!\n");	
			opcoes.voltarMenuPrincipal();
			
		}else{
			//LIMPA CONSOLE - PODE COME�AR NOVO CADASTRO
			opcoes.limparConsole();
			System.out.println("\nDeseja come�ar um novo CADASTRO DE VENDEDOR?");
			System.out.println("Digite [S] para Sim e [N] para n�o");
			opcao = sc.nextLine();
			if(opcao.equalsIgnoreCase("s")){
				cadastrarCliente();
			}else{
				opcoes.voltarMenuPrincipal();
			}
		}
	}
}
