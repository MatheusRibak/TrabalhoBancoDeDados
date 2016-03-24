package principal;

import java.util.Scanner;

public class Opcoes {
	Scanner sc = new Scanner(System.in);

	protected void limparConsole() {
		for (int i = 0; i < 30; i++) {
			System.out.println();
		}
	}

	protected void voltarMenuPrincipal() {
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
