package principal;

import java.util.Scanner;

public class OpcoesMenuLoja {
	Opcoes opcoes = new Opcoes();
	Scanner sc = new Scanner(System.in);
	
	protected void menuLoja() {
		int escolha = sc.nextInt();
		switch (escolha) {
		case 1:
			
			break;
		case 2:
			
			break;
		default:
			opcoes.opcaoNaoEncontrada();
			break;
		}
	}
	
	
	
}
