package metodos;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import Model.Venda;
import Telas.TelaInicial;

public class ListarVenda {

	public void listar(DefaultTableModel dtm, String cliente, String vendedor) {
		dtm.setRowCount(0);
		List<Venda> vendas = TelaInicial.getTlInicial().getDao().listaQualquer(Venda.class);
		for (Venda venda : vendas) {
			if((cliente.isEmpty()) && (vendedor.isEmpty())){
					dtm.addRow(new String[] { venda.get_id().toString(),
					venda.getCliente().getPessoa().getNome(), venda.getUsuario().getVendedor().getPessoa().getNome(), 
					venda.getCelular().getValor().toString()});
			}
		}		
		if(cliente.isEmpty()){
			cliente = "Não procurar $_$-$30";
		}else{
			cliente = cliente;
		}
		if(vendedor.isEmpty()){
			vendedor = "Não procurar $_$-$30";
		}else{
			vendedor = vendedor;
		}
		for(Venda venda : vendas){
			if((venda.getCliente().getPessoa().getNome().toUpperCase().contains(cliente.toUpperCase()))
					|| venda.getUsuario().getVendedor().getPessoa().getNome().toUpperCase().contains(vendedor.toUpperCase())){
						dtm.addRow(new String[] { venda.get_id().toString(),
						venda.getCliente().getPessoa().getNome(), venda.getUsuario().getVendedor().getPessoa().getNome(), venda.getCelular().getValor().toString()});
			}
		}
	}
}