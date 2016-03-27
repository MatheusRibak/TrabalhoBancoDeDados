package utilitarios;

import javax.swing.JOptionPane;

public class MensagemErro {
	private static String TITULO_MENSAGEM = "Campo(os) em branco!";
	private static int TIPO_MENSAGEM = JOptionPane.ERROR_MESSAGE;
	private String CORPO_MENSAGEM = "Erro!";

	// NECESS�RIO APENAS TROCAR CORPO_MENSAGEM AO CRIAR NOVO METODO
	protected void erroCadastrarCliente() {
		CORPO_MENSAGEM = "Os campos de NOME, RG E CPF s�o obrigatorios! Preencha-os corretamente e tente novamente.";
		exibeMensagem(CORPO_MENSAGEM);
	}

	protected void erroCadastrarVendedor() {
		CORPO_MENSAGEM = "Todos os campos s�o obrigat�rios! Preencha-os e tente novamente.";
		exibeMensagem(CORPO_MENSAGEM);
	}

	protected void erroCadastroCelular() {
		CORPO_MENSAGEM = "Todos os campos do painel 'Principal' s�o obrigat�rios! Preencha-os e tente novamente.";
		exibeMensagem(CORPO_MENSAGEM);
	}

	private void exibeMensagem(String CORPO_MENSAGEM) {
		JOptionPane.showMessageDialog(null, CORPO_MENSAGEM, TITULO_MENSAGEM,
				TIPO_MENSAGEM);
	}
}
