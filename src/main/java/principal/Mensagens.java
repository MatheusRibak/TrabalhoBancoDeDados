package principal;

public class Mensagens {
	
	private static String MENSAGEM_FINAL = "Escolha uma opção e tecle ENTER... ";
	
	protected void menuPrincipal(){
		System.out.println("Menu principal:");
			System.out.println("[1]: Cadastrar Cliente");
			System.out.println("[2]: Cadastrar Vendedor");
			System.out.println("[3]: Cadastrar Celular");
			System.out.println("[4]: Cadastrar Venda");
			System.out.println("[5]: Alterar cadastro da loja");
		System.out.print(MENSAGEM_FINAL);
		OpcoesMenuPrincipal omp = new OpcoesMenuPrincipal();
		omp.menuPrincipal();
	}
	
	protected void menuLoja(){
		System.out.println("Menu Loja:");
			System.out.println("[1]: Cadastrar loja");
			System.out.println("[2]: Alterar loja");
		System.out.print(MENSAGEM_FINAL);
	}
	
	
}
