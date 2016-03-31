package Componentes;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CriaLabel {
	
	public JLabel criarLabel(String texto, Integer col, Integer lin, Integer lar, Integer alt, JLabel label, Container container) {
		label = new JLabel(texto);
		label.setBounds(col, lin, lar, alt);
		label.setVisible(true);
		container.add(label);
		return label;
	}
	
	public JLabel criarLabelParaPanel(String texto, Integer col, Integer lin, Integer lar, Integer alt, JLabel label, Container container) {
		label = new JLabel(texto.toUpperCase(), SwingConstants.RIGHT);
		label.setFont(new Font("ARIAL", Font.PLAIN, 14));
		label.setForeground(Color.BLACK);
		label.setBounds(col, lin, lar, alt);
		label.setVisible(true);
		container.add(label);
		return label;
	}
	
	public JLabel criarParaPanelCenter(String texto, Integer col, Integer lin, Integer lar, Integer alt, JLabel label, Container container) {
		label = new JLabel(texto.toUpperCase(), SwingConstants.CENTER);
		label.setFont(new Font("ARIAL", Font.PLAIN, 14));
		label.setForeground(Color.BLACK);
		label.setBounds(col, lin, lar, alt);
		label.setVisible(true);
		container.add(label);
		return label;
	}
	
	public JLabel criarParaPanelLogin(String texto, Integer col, Integer lin, Integer lar, Integer alt, JLabel label, Container container) {
		label = new JLabel(texto.toUpperCase(), SwingConstants.CENTER);
		label.setFont(new Font("ARIAL", Font.PLAIN, 14));
		label.setForeground(Color.BLACK);
		label.setBounds(col, lin, lar, alt);
		label.setVisible(true);
		container.add(label);
		return label;
	}
	
	public JLabel criarTitulo(String texto, JLabel label, Container container) {
		label = new JLabel(texto.toUpperCase(), SwingConstants.CENTER);
		label.setFont(new Font("ARIAL", Font.PLAIN, 18));
		label.setBounds(0, 10, 800, 50);
		label.setVisible(true);
		container.add(label);
		return label;
	}
	
	public JLabel criarTituloIcone(JLabel label, Container container) {
		label = new JLabel();
		label.setBounds(13, 13, 32, 32);
		label.setVisible(true);
		container.add(label);
		return label;
	}
	
}
