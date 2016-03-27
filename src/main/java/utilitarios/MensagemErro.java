package utilitarios;

import javax.swing.JOptionPane;

public class MensagemErro {
	private static String TITULO_MENSAGEM = "Campo(os) em branco!";
	private static int TIPO_MENSAGEM = JOptionPane.ERROR_MESSAGE;
	private String CORPO_MENSAGEM = "Erro!";

	// NECESSÁRIO APENAS TROCAR CORPO_MENSAGEM AO CRIAR NOVO METODO
	protected void erroCadastrarCliente() {
		CORPO_MENSAGEM = "Os campos de NOME, RG E CPF são obrigatorios! Preencha-os corretamente e tente novamente.";
		exibeMensagem(CORPO_MENSAGEM);
	}

	protected void erroCadastrarVendedor() {
		CORPO_MENSAGEM = "Todos os campos são obrigatórios! Preencha-os e tente novamente.";
		exibeMensagem(CORPO_MENSAGEM);
	}

	protected void erroCadastroCelular() {
		CORPO_MENSAGEM = "Todos os campos do painel 'Principal' são obrigatórios! Preencha-os e tente novamente.";
		exibeMensagem(CORPO_MENSAGEM);
	}

	private void exibeMensagem(String CORPO_MENSAGEM) {
		JOptionPane.showMessageDialog(null, CORPO_MENSAGEM, TITULO_MENSAGEM,
				TIPO_MENSAGEM);
	}
}
