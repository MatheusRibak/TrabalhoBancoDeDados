package Componentes;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class CriaMenu {

	public JMenuItem criarMenuItem(JMenuItem jmi, String titulo, JMenu jm, ActionListener action) {
		jmi = new JMenuItem(titulo);
		jm.add(jmi);
		jm.addActionListener(action);
		return jmi;
	}

}
