package menu;

import java.util.Scanner;

import metodos.CadastroCelular;
import metodos.CadastroCliente;
import metodos.CadastroVenda;
import metodos.CadastroVendedor;

public class MenuPrincipal {

	private static String MENSAGEM_FINAL = "Escolha uma opção e tecle ENTER... ";
	private Scanner sc = new Scanner(System.in);
	
	public MenuPrincipal() {
		menuPrincipal();
	}

	protected void menuPrincipal() {
		System.out.println("Menu principal:");
		System.out.println("[1]: Cadastrar Cliente");
		System.out.println("[2]: Cadastrar Vendedor");
		System.out.println("[3]: Cadastrar Celular");
		System.out.println("[4]: Cadastrar Venda");
		System.out.println("[5]: Cadastrar Loja");
		System.out.print(MENSAGEM_FINAL);
		int escolhaMenu = sc.nextInt();
		switch (escolhaMenu) {
		case 1:
			//CHAMA CADASTRO CLIENTE
			CadastroCliente cadCliente = new CadastroCliente();
			break;
		case 2:
			//CHAMA CADASTRO DE VENDEDOR
			CadastroVendedor cadVendedor = new CadastroVendedor();
			break;
		case 3:
			//CHAMA CADASTRO DE CELULAR
			CadastroCelular cadCelular = new CadastroCelular();
			break;
		case 4:
			//CHAMA CADASTRO DE NOVA VENDA
			CadastroVenda cadVenda = new CadastroVenda();
			break;
		default:
			break;
		}

	}
}
