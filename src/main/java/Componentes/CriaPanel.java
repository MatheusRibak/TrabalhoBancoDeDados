package Componentes;

import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class CriaPanel {

	public JPanel criarPanel(String texto, Integer col, Integer lin, Integer lar,
			Integer alt, JPanel panel,
			Boolean visibilidade, Container tela) {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder(texto));
		panel.setBounds(col, lin, lar, alt);
		panel.setVisible(visibilidade);
		tela.add(panel);
		return panel;
	}
	
	public JPanel criarPanelSemTitulo(Integer col, Integer lin, Integer lar, Integer alt,
			JPanel panel, Boolean visibilidade, Container tela) {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder(""));
		panel.setBounds(col, lin, lar, alt);
		panel.setVisible(visibilidade);
		tela.add(panel);
		return panel;
	}
}
