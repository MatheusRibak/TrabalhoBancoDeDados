package Componentes;

import java.awt.Container;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CriaField {
	
	public JTextField criarTextField(Integer col, Integer lin, Integer lar, Integer alt, JTextField textField, Container tela) {
		textField = new JTextField();
		textField.setBounds(col, lin, lar, alt);
		textField.setVisible(true);
		tela.add(textField);
		return textField;

	}
	
	public JTextField criarPasswordField(Integer col, Integer lin, Integer lar, Integer alt, JTextField textField, Container tela) {
		textField = new JPasswordField();
		textField.setBounds(col, lin, lar, alt);
		textField.setVisible(true);
		tela.add(textField);
		return textField;

	}

}
