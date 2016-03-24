package principal;

import java.util.Scanner;

public class Opcoes {
	Scanner sc = new Scanner(System.in);

	protected void menuPrincipal() {
		int escolha = sc.nextInt();
		//limparConsole();
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
	
	private void cadastrarCliente(){
		System.out.println("\t[CADASTRO DE CLIENTE]");
		System.out.println("Insira o nome: ");
		String nome;
		nome = sc.nextLine();
		nome = sc.nextLine();
		System.out.println(nome);
	}
	
	protected void limparConsole(){
		for(int i = 0; i < 30; i ++){
			System.out.println();
		}
	}

	private void voltarMenuPrincipal() {
		System.out.println("Voltar ao menu principal?");
		System.out.print("Tecle [S] para sim ou [N] para não");
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
