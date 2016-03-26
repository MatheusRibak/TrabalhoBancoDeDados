package Componentes;

import java.awt.Container;

import javax.swing.JButton;

public class CriaButton {

	public JButton criarBotao(String texto, Integer col, Integer lin, Integer lar, Integer alt, JButton button, Container tela) {
		button = new JButton(texto);
		button.setBounds(col, lin, lar, alt);
		button.setVisible(true);
		tela.add(button);
		return button;

	}
	
}
