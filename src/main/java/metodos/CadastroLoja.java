package metodos;

import java.util.Scanner;

import DAO.GenericDAO;
import Model.Endereco;
import Model.Loja;
import menu.Opcoes;

public class CadastroLoja {
	private Opcoes opcoes = new Opcoes();
	private Scanner sc = new Scanner(System.in);
	
	public CadastroLoja() {
		cadastrar();
	}
	
	private void cadastrar(){
		opcoes.limparConsole();
		System.out.println("\t[CADASTRO DE LOJA]");
		System.out.print("Insira o nome fantasia: ");
		String nomFantasia = sc.nextLine();
		System.out.print("Insira a razão social: ");
		String razSocial = sc.nextLine();
		System.out.print("Insira o CNPJ: ");
		String cnpj = sc.nextLine();
		System.out.print("Insira o telefone: ");
		String telefone = sc.nextLine();
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
		System.out.println("Nome Fantasia: " + nomFantasia);
		System.out.println("Razão Social: " + razSocial);
		System.out.println("CNPJ: " + cnpj);
		System.out.println("Telefone: " + telefone);
		System.out.println("Rua: " + rua);
		System.out.println("Número: " + numero);
		System.out.println("Bairro: " + bairro);
		System.out.println("Cidade: " + cidade);
		System.out.println("UF: " + uf);
		System.out.println("CEP: " + cep);
		
		System.out.print("\tDigite [S] para Salvar ou [C] para Cancelar... ");
		String opcao = sc.nextLine();
		if(opcao.equalsIgnoreCase("s")){
			// SALVA O ENDEREÇO > LOJA
			Endereco endereco = new Endereco();
			endereco.setRua(rua);
			endereco.setNumero(numero);
			endereco.setBairro(bairro);
			endereco.setCidade(cidade);
			endereco.setUf(uf);
			endereco.setCep(cep);
			Loja loja = new Loja();
			loja.setNomeFantasia(nomFantasia);
			loja.setRazaoSocial(razSocial);
			loja.setCnpj(cnpj);
			loja.setTelefone(telefone);
			loja.setEndereco(endereco);
			GenericDAO dao = new GenericDAO();
			dao.inserir(loja);
			System.out.println("Cadastro concluído com sucesso!\n");	
			opcoes.voltarMenuPrincipal();
			
		}else{
			//LIMPA CONSOLE - PODE COMEÇAR NOVO CADASTRO
			opcoes.limparConsole();
			System.out.println("\nDeseja começar um novo CADASTRO DE LOJA?");
			System.out.println("Digite [S] para Sim e [N] para não");
			opcao = sc.nextLine();
			if(opcao.equalsIgnoreCase("s")){
				cadastrar();
			}else{
				opcoes.voltarMenuPrincipal();
			}
		}
		
	}

}
