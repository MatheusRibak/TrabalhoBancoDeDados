package principal;

import java.util.Scanner;

public class Mensagens {
	
	private static String MENSAGEM_FINAL = "Escolha uma opção e tecle ENTER.. ";
	private Opcoes opcoes = new Opcoes();
	private Scanner scanner = new Scanner(System.in);
	
	protected void menuPrincipal(){
		System.out.println("Menu principal:");
			System.out.println("[1]: Cadastrar Cliente");
			System.out.println("[2]: Cadastrar Vendedor");
			System.out.println("[3]: Cadastrar Celular");
			System.out.println("[4]: Cadastrar Venda");
			System.out.println("[5]: Alterar cadastro da loja");
		System.out.print(MENSAGEM_FINAL);
		opcoes.menuPrincipal();
	}
	
	
	
}
