package Componentes;

import java.awt.Container;

import javax.swing.JRadioButton;

public class CriaRadioButton {

	public JRadioButton criarRadioButton(String texto, Integer col, Integer lin, Integer lar, Integer alt,
			JRadioButton radioButton, Container tela) {
		radioButton = new JRadioButton(texto);
		radioButton.setBounds(col, lin, lar, alt);
		radioButton.setVisible(true);
		radioButton.setFocusable(false);
		return radioButton;
	}

	
}
