package metodos;

import java.util.Scanner;

import DAO.GenericDAO;
import Model.Celular;
import Model.Endereco;
import Model.Loja;
import menu.Opcoes;

public class CadastroCelular {
	private Opcoes opcoes = new Opcoes();
	private Scanner sc = new Scanner(System.in);
	
	public CadastroCelular() {
		cadastrar();
	}
	
	private void cadastrar(){
		opcoes.limparConsole();
		System.out.println("\t[CADASTRO DE CELULAR]");
		System.out.print("Insira a marca: ");
		String marca = sc.nextLine();
		System.out.print("Insira uma descrição(opcional): ");
		String descricao = sc.nextLine();
		System.out.print("Insira a quantidade de megapixel da câmera: ");
		String megapixel = sc.nextLine();
		System.out.print("Insira a quantidade de memória do aparelho: ");
		String memoria = sc.nextLine();
		System.out.print("\nInsira o valor: R$");
		Double valor = sc.nextDouble();
		
		System.out.println("\n\t[CONFIRME OS DADOS]");
		System.out.println("Marca: " + marca);
		System.out.println("Descrição: " + descricao);
		System.out.println("Megapixel: " + megapixel);
		System.out.println("Memória: " + memoria);
		System.out.println("Valor: R$" + valor);
		
		System.out.print("\tDigite [S] para Salvar ou [C] para Cancelar... ");
		String opcao = sc.nextLine();
		opcao = sc.nextLine();
		if(opcao.equalsIgnoreCase("s")){
			// SALVA O CELULAR
			Celular celular = new Celular();
			celular.setEmpresa(marca);
			celular.setDescricao(descricao);
			celular.setCamera(megapixel);
			celular.setMemoria(memoria);
			celular.setValor(valor);
			GenericDAO dao = new GenericDAO();
			dao.inserir(celular);
			System.out.println("Cadastro concluído com sucesso!\n");	
			opcoes.voltarMenuPrincipal();
			
		}else{
			//LIMPA CONSOLE - PODE COMEÇAR NOVO CADASTRO
			opcoes.limparConsole();
			System.out.println("\nDeseja começar um novo CADASTRO DE CELULAR?");
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
