package utilitarios;

import javax.swing.JOptionPane;

public class MensagemSucesso {

	public void sucessoCadastrarVendedor() {
		JOptionPane.showMessageDialog(null, "Corretor cadastrado com sucesso!", "Sucesso!", JOptionPane.PLAIN_MESSAGE);
	}

	public void sucessoCadastrarCliente() {
		JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Sucesso!", JOptionPane.PLAIN_MESSAGE);
	}

	public void sucessoCadastrarCelular() {
		JOptionPane.showMessageDialog(null, "Im�vel cadastrado com sucesso!", "Sucesso!", JOptionPane.PLAIN_MESSAGE);
	}

//	public void sucessoGerarEstorno() {
	//	JOptionPane.showMessageDialog(null, "Estorno efeutado com sucesso! A venda e a nota fiscal foram removidas!",
		//		"Sucesso!", JOptionPane.PLAIN_MESSAGE);
//	}

	public void sucessoAlterarCliente() {
		JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!", "Sucesso!", JOptionPane.PLAIN_MESSAGE);
	}

	public void sucessoAlterarCorretor() {
		JOptionPane.showMessageDialog(null, "Corretor alterado com sucesso!", "Sucesso!", JOptionPane.PLAIN_MESSAGE);
	}

}
