package utilitarios;

public class EscolheMensagem {

	public void mensagemErro(String descricao) {
		MensagemErro menErro = new MensagemErro();
		switch (descricao) {
		case "cadastro_cliente":
			menErro.erroCadastrarCliente();
			break;
		case "cadastro_celular":
			menErro.erroCadastroCelular();
			break;
		default:
			break;
		}
	}

	public void mensagemSucesso(String descricao) {
		MensagemSucesso menSucesso = new MensagemSucesso();
		switch (descricao) {
		case "cadastro_cliente":
			menSucesso.sucessoCadastrarCliente();
			break;
		case "cadastro_celular":
			menSucesso.sucessoCadastrarCelular();
			break;	
		case "alterar_cliente":
			menSucesso.sucessoAlterarCliente();
			break;	
		case "alterar_vendedor":
			menSucesso.sucessoAlterarCliente();
			break;	
		case "alterar_celular":
			menSucesso.sucessoAlterarCelular();
			break;	
		default:
			break;
		}
	}

	public void mensagemInformativa(String descricao) {
		MensagemInformativa menInformativa = new MensagemInformativa();
		switch (descricao) {
		case "tabela_vazia":
			menInformativa.informativoTabelaVazia();
			break;
		default:
			break;
		}
	}

}
