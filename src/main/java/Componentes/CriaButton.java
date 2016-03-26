package Componentes;

import javax.swing.JButton;

public class CriaButton {

	public JButton criarBotao(String texto, Integer col, Integer lin, Integer lar, Integer alt, JButton button) {
		button = new JButton(texto);
		button.setBounds(col, lin, lar, alt);
		button.setVisible(true);
		return button;

	}
	
}
