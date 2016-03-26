package utilitarios;

import javax.swing.JOptionPane;

public class MensagemErro {

	// erros de cadastro
	protected void erroCadastrarCliente() {
		JOptionPane.showMessageDialog(null,
				"Os campos de NOME, RG E CPF são obrigatorios! Preencha-os corretamente e tente novamente.",
				"Campo(os) em branco", JOptionPane.ERROR_MESSAGE);
	}

	protected void erroCadastrarVendedor() {
		JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios! Preencha-os e tente novamente.",
				"Campo(os) em branco", JOptionPane.ERROR_MESSAGE);
	}

	protected void erroCadastroCelular() {
		JOptionPane.showMessageDialog(null,
				"Todos os campos do painel 'Principal' são obrigatórios! Preencha-os e tente novamente.",
				"Campo(os) em branco", JOptionPane.ERROR_MESSAGE);
	}

	// erros de pesquisa
//	protected void erroPesquisarRg() {
	//	JOptionPane.showMessageDialog(null, "Impossível pesquisar por um RG vazio!", "Alerta!",
		//		JOptionPane.ERROR_MESSAGE);
	//}

}
