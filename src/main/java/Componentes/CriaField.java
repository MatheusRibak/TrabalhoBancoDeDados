package Componentes;

import javax.swing.JTextField;

public class CriaField {
	
	public JTextField criarTextField(Integer col, Integer lin, Integer lar, Integer alt, JTextField textField) {
		textField = new JTextField();
		textField.setBounds(col, lin, lar, alt);
		textField.setVisible(true);
		return textField;

	}

}
