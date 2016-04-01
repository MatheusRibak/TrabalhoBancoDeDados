package Componentes;

import java.awt.Container;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class CriaTabela {

	public DefaultTableModel criarTableImoveis(JTable table, Container tela,
			DefaultTableModel dtmodel, List<String> colunas, int col,
			int lin, int larg, int alt) {
		table = new JTable();
		tela.add(table);
		dtmodel = new DefaultTableModel();
		for (String colNome : colunas) {
			dtmodel.addColumn(colNome);
		}
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(dtmodel);
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(col, lin, larg, alt);
		jsp.setVisible(true);
		tela.add(jsp);	
		return dtmodel;
	}
}
