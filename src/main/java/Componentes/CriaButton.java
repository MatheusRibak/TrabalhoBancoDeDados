package Componentes;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CriaButton {

	public JButton criarBotao(String texto, Integer col, Integer lin, Integer lar, Integer alt, 
			JButton button, Container tela, ActionListener action) {
		button = new JButton(texto.toUpperCase());
		button.setBounds(col, lin, lar, alt);
		button.setVisible(true);
		button.setFocusable(false);
		button.addActionListener(action);
		tela.add(button);
		return button;
	}
	
	public JButton criarBotaoAjuda(String MENSAGEM, String texto, Integer col, Integer lin, Integer lar,
			Integer alt, JButton button, Container tela, ActionListener action) {
		button = new JButton(texto.toUpperCase());
		button.setBounds(col, lin, lar, alt);
		button.setVisible(true);
		button.setFocusable(false);
		button.addActionListener(action);
		button.setToolTipText(MENSAGEM);
		button.setForeground(Color.BLACK);
		button.setBackground(Color.WHITE);
		tela.add(button);
		return button;

	}
	
	public JButton criarBotaoProcurar(String texto, Integer col, Integer lin, Integer lar, Integer alt, 
			JButton button, Container tela, ActionListener action) {
		button = new JButton(texto.toUpperCase());
		button.setBounds(col, lin, lar, alt);
		button.setVisible(true);
		button.setFocusable(false);
		button.addActionListener(action);
		button.setForeground(Color.BLACK);
		button.setBackground(Color.WHITE);
		tela.add(button);
		return button;
	}
}
