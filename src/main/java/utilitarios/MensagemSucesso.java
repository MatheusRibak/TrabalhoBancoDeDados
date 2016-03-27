package utilitarios;

import javax.swing.JOptionPane;

public class MensagemSucesso {
	private static String TITULO_MENSAGEM = "Sucesso!";
	private static int TIPO_MENSAGEM = JOptionPane.PLAIN_MESSAGE;
	private String CORPO_MENSAGEM = "Cadastrado!";

	// NECESS�RIO APENAS TROCAR CORPO_MENSAGEM AO CRIAR NOVO METODO
	public void sucessoCadastrarCliente() {
		CORPO_MENSAGEM = "Cliente cadastrado com sucesso!";
		exibeMensagem(CORPO_MENSAGEM);
	}

	public void sucessoCadastrarCelular() {
		CORPO_MENSAGEM = "Im�vel cadastrado com sucesso!";
		exibeMensagem(CORPO_MENSAGEM);
	}

	public void sucessoAlterarCliente() {
		CORPO_MENSAGEM = "Im�vel cadastrado com sucesso!";
		exibeMensagem(CORPO_MENSAGEM);
	}

	private void exibeMensagem(String CORPO_MENSAGEM) {
		JOptionPane.showMessageDialog(null, CORPO_MENSAGEM, TITULO_MENSAGEM,
				TIPO_MENSAGEM);
	}
}
