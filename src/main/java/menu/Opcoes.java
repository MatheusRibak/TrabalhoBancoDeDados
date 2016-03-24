package menu;

import java.util.Scanner;

public class Opcoes {
	Scanner sc = new Scanner(System.in);

	public void limparConsole() {
		for (int i = 0; i < 30; i++) {
			System.out.println();
		}
	}

	public void voltarMenuPrincipal() {
		System.out.println("Voltar ao menu principal?");
		System.out.print("Digite [S] para sim ou [N] para não");
		String opcao = sc.next();
		if (opcao.equalsIgnoreCase("s")) {
			MenuPrincipal mp = new MenuPrincipal();
			mp.menuPrincipal();
			sc.close();
		} else {
			opcaoNaoEncontrada();
		}
	}

	public void opcaoNaoEncontrada() {
		System.out.println("Opção não encontrada!\n");
		voltarMenuPrincipal();
	}

}
