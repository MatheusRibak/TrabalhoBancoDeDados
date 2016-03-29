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
		System.out.print("Insira a quantidade de megapixel da câmera Traseira: ");
		String cameraTraseira = sc.nextLine();
		System.out.print("Insira a quantidade de megapixel da câmera Frontal:");
		String cameraFrontal = sc.nextLine();
		System.out.print("Insira a quantidade de memória do aparelho: ");
		String memoria = sc.nextLine();
		System.out.print("Insira a memória RAM do aparelho: ");
		String memoriaRAM = sc.nextLine();
		System.out.print("Informe o tipo de chip do aparelho:");
		String tipoChip = sc.nextLine();
		System.out.print("Insira a quantidade de chips do aparalho:");
		String quantidadeChips = sc.nextLine();
		System.out.print("Insira o tamanho da tela do aparelho: ");
		String tamanhoTela = sc.nextLine();
		System.out.print("Informe o sistema operacional do aparelho:");
		String sistemaOperacional = sc.nextLine();
		System.out.print("Informe o peso do aparelho:");
		String peso = sc.nextLine();
		System.out.print("Por favor informe a garantia do aparelho:");
		String garantia = sc.nextLine();
		System.out.print("Por favor informe a cor do aparelho");
		String cor = sc.nextLine();
		System.out.print("Por favor informe se o celular possui TV:");
		String possuiTV = sc.nextLine();
		System.out.print("Por favor informe a conectividade do aparelho:");
		String conect = sc.nextLine();
		System.out.print("Por favor informe o IMEI do aparelho:");
		String imei = sc.nextLine();
		System.out.print("\nInsira o valor: R$");
		Double valor = sc.nextDouble();
		
		System.out.println("\n\t[CONFIRME OS DADOS]");
		System.out.println("Marca: " + marca);
		System.out.println("Descrição: " + descricao);
		System.out.println("Megapixel Câmera Traseira: " + cameraTraseira);
		System.out.println("Megapixel Câmera Frontal: " +cameraTraseira);
		System.out.println("Memória: " + memoria);
		System.out.println("Memória RAM: " + memoriaRAM);
		System.out.println("Tipo de Chip:" +tipoChip);
		System.out.println("Quantidade de Chips: " + quantidadeChips);
		System.out.println("Tamanho da tela: " +tamanhoTela);
		System.out.println("Sistema Operacional: "+sistemaOperacional);
		System.out.println("Peso: "+peso);
		System.out.println("Garantia: " +garantia);
		System.out.println("Cor: "+cor);
		System.out.println("Possui TV? "+possuiTV);
		System.out.println("Tipo de conectividade :"+conect);
		System.out.println("IMEI: "+imei);
		System.out.println("Valor: R$" + valor);
		
		System.out.print("\tDigite [S] para Salvar ou [C] para Cancelar... ");
		String opcao = sc.nextLine();
		opcao = sc.nextLine();
		if(opcao.equalsIgnoreCase("s")){
			// SALVA O CELULAR
			Celular celular = new Celular();
			celular.setEmpresa(marca);
			celular.setDescricao(descricao);
			celular.setCameraFrontal(cameraTraseira);
			celular.setMemoria(memoria);
			celular.setMemoriaRAM(memoriaRAM);
			celular.setQuantidadeChips(quantidadeChips);
			celular.setValor(valor);
			celular.setCameraFrontal(cameraFrontal);
			celular.setTamanhoDaTela(tamanhoTela);
			celular.setSistemaOperacional(sistemaOperacional);
			celular.setTipoChip(tipoChip);
			celular.setPeso(peso);
			celular.setGarantia(garantia);
			celular.setCor(cor);
			celular.setTV(possuiTV);
			celular.setConectividade(conect);
			celular.setIMEI(imei);
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
