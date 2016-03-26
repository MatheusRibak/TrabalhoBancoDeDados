package Componentes;

import java.awt.Container;

import javax.swing.JLabel;

public class CriaLabel {
	
	public JLabel criarLabel(String texto, Integer col, Integer lin, Integer lar, Integer alt, JLabel label, Container container) {
		label = new JLabel(texto);
		label.setBounds(col, lin, lar, alt);
		label.setVisible(true);
		container.add(label);
		return label;
	}
	
}
