package metodos;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import utilitarios.EscolheMensagem;
import Model.Venda;
import Telas.TelaInicial;

public class ListarVenda {

	public void listar(DefaultTableModel dtm) {
		List<Venda> vendas = TelaInicial.getTlInicial().getDao().listaQualquer(Venda.class);
		for (Venda venda : vendas) {
			dtm.addRow(new String[] { venda.getData().toString(),
					venda.getVendedor().getPessoa().getNome(), venda.getCelular().getValor().toString()});
			
		}
		if(dtm.getRowCount() == 0){
			EscolheMensagem escolhe = new EscolheMensagem();
			escolhe.mensagemInformativa("tabela_vazia");
		}

	}
	
}
