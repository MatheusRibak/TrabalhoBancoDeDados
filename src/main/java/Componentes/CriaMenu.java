package Componentes;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class CriaMenu {

	public JMenuItem criarMenuItem(JMenuItem jmi, String titulo, JMenu jm) {
		jmi = new JMenuItem(titulo);
		jm.add(jmi);
		return jmi;
	}
}
