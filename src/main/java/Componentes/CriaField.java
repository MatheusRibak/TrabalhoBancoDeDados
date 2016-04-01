package Componentes;

import java.awt.Container;
import java.awt.event.KeyListener;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class CriaField {
	
	public JTextField criarTextField(Integer col, Integer lin, Integer lar, 
			Integer alt, JTextField textField, Container tela, KeyListener mouse) {
		textField = new JTextField();
		textField.setBounds(col, lin, lar, alt);
		textField.setVisible(true);
		textField.addKeyListener(mouse);
		tela.add(textField);
		return textField;
	}
	
	public JTextField criarPasswordField(Integer col, Integer lin, Integer lar, Integer alt,
			JTextField textField, Container tela) {
		textField = new JPasswordField();
		textField.setBounds(col, lin, lar, alt);
		textField.setVisible(true);
		tela.add(textField);
		return textField;
	}
	
	public JTextField criarMaskFieldDate(Integer col, Integer lin, Integer lar, Integer alt,
			JTextField textField, Container tela){
		try {
			textField = new JFormattedTextField(new MaskFormatter("##/##/##"));
		} catch (ParseException e) {
			textField = new JTextField();
		}
		textField.setBounds(col, lin, lar, alt);
		textField.setVisible(true);
		textField.setText("MMDDANO");
		tela.add(textField);
		return textField;
	}
}
