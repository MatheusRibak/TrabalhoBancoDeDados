package utilitarios;

import javax.swing.JOptionPane;

public class MensagemInformativa {
	private static String TITULO_MENSAGEM = "Informação!";
	private static int TIPO_MENSAGEM = JOptionPane.PLAIN_MESSAGE;
	private String CORPO_MENSAGEM = "Cadastrado!";

	protected void informativoTabelaVazia() {
		CORPO_MENSAGEM = "Não existem cadastros para serem exibidos!";
		exibeMensagem(CORPO_MENSAGEM);
	}
	
	private void exibeMensagem(String CORPO_MENSAGEM) {
		JOptionPane.showMessageDialog(null, CORPO_MENSAGEM, TITULO_MENSAGEM,
				TIPO_MENSAGEM);
	}
}