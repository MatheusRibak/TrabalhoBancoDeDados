package principal;

import java.util.Scanner;

public class Opcoes {

	protected void menuPrincipal() {
		Scanner sc = new Scanner(System.in);
		int escolha = 0;
		try {
			escolha = sc.nextInt();
		} catch (Exception e) {
			opcaoNaoEncontrada();
		}
		sc.close();
		switch (escolha) {
		case 1:
			System.out.println("Teclou 1");
			voltarMenuPrincipal();
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
		
	private void voltarMenuPrincipal(){
		System.out.println("Voltar ao menu principal?");
		System.out.print("Tecle [S] para sim");
		System.out.println(" ou [N] para não");
		Scanner sc = new Scanner(System.in);
		String opcao = sc.nextLine();
		//sc.close();
		if(opcao.equalsIgnoreCase("s")){
			Mensagens mensagem = new Mensagens();
			mensagem.menuPrincipal();
		}else {
			opcaoNaoEncontrada();
		}
	}
	
	protected void opcaoNaoEncontrada(){
		System.out.println("Opção não encontrada!\n");
		voltarMenuPrincipal();
	}

}
