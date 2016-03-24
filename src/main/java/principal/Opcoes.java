package principal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import DAO.GenericDAO;
import Model.Endereco;
import Model.Pessoa;

public class Opcoes {
	Scanner sc = new Scanner(System.in);

	protected void menuPrincipal() {
		int escolha = sc.nextInt();
		// limparConsole();
		switch (escolha) {
		case 1:
			cadastrarCliente();
			break;
		case 2:
			System.out.println("Teclou 2");
			voltarMenuPrincipal();
			break;
		case 3:
			System.out.println("Teclou 3");
			voltarMenuPrincipal();
			break;
		case 4:
			System.out.println("Teclou 4");
			voltarMenuPrincipal();
			break;
		case 5:
			System.out.println("Teclou 5");
			voltarMenuPrincipal();
			break;
		default:
			opcaoNaoEncontrada();
			break;
		}
	}

	private void cadastrarCliente() {
		limparConsole();
		System.out.println("\t[CADASTRO DE CLIENTE]");
		System.out.print("Insira o nome: ");
		String nome = sc.nextLine();
		nome = sc.nextLine();
		System.out.print("Insira o RG: ");
		String rg = sc.nextLine();
		System.out.print("Insira o CPF: ");
		String cpf = sc.nextLine();
		System.out.print("Insira a data de nascimento mo formato Dia/Mês/Ano(29/12/2016): ");
		String dataNascimento = sc.nextLine();
		System.out.print("Insira o email: ");
		String email = sc.nextLine();
		System.out.print("Insira o telefone celular: ");
		String telCelular = sc.nextLine();
		System.out.print("\nInsira a rua: ");
		String rua = sc.nextLine();
		System.out.print("Insira o número: ");
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
		System.out.println("Número: " + numero);
		System.out.println("Bairro: " + bairro);
		System.out.println("Cidade: " + cidade);
		System.out.println("UF: " + uf);
		System.out.println("CEP: " + cep);
		
		System.out.print("\tDigite [S] para Salvar ou [C] para Cancelar... ");
		String opcao = sc.nextLine();
		if(opcao.equalsIgnoreCase("s")){
			// SALVA O CLIENTE E ENDEREÇO
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
				System.out.println("Erro na conversão da data de nascimento!");
				limparConsole();
				voltarMenuPrincipal();
			}
			pessoa.setDataNascimento(dataNasc);
			pessoa.setEmail(email);
			pessoa.setTelefoneCelular(telCelular);
			pessoa.setEndereco(endereco);
			GenericDAO dao = new GenericDAO();
			dao.inserir(pessoa);
			System.out.println("Cadastro conclúido com sucesso!\n");	
			voltarMenuPrincipal();
			
		}else{
			//LIMPA CONSOLE - PODE COMEÇAR NOVO CADASTRO
			limparConsole();
			System.out.println("\nDeseja começar um novo CADASTRO DE CLIENTE?");
			System.out.println("Digite [S] para Sim e [N] para não");
			opcao = sc.nextLine();
			if(opcao.equalsIgnoreCase("s")){
				cadastrarCliente();
			}else{
				voltarMenuPrincipal();
			}
		}
	}

	protected void limparConsole() {
		for (int i = 0; i < 30; i++) {
			System.out.println();
		}
	}

	private void voltarMenuPrincipal() {
		System.out.println("Voltar ao menu principal?");
		System.out.print("Digite [S] para sim ou [N] para não");
		String opcao = sc.next();
		if (opcao.equalsIgnoreCase("s")) {
			Mensagens mensagem = new Mensagens();
			mensagem.menuPrincipal();
			sc.close();
		} else {
			opcaoNaoEncontrada();
		}
	}

	protected void opcaoNaoEncontrada() {
		System.out.println("Opção não encontrada!\n");
		voltarMenuPrincipal();
	}

}
