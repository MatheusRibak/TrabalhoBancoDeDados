package metodos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import utilitarios.EscolheMensagem;
import DAO.GenericDAO;
import Model.Celular;
import Model.Pessoa;

public class ListarCelular {

	public void listar(DefaultTableModel dtm, String descricao, String modelo, String imei, String marca) {
		GenericDAO dao = new GenericDAO();

		ArrayList<Celular> celulares = dao.listaQualquer(Celular.class);
		dtm.setRowCount(0);
		
		for(Celular celular : celulares){
			if((descricao.isEmpty()) && (modelo.isEmpty()) && imei.isEmpty() && (marca.isEmpty())){
				dtm.addRow(new String[]{celular.get_id(), celular.getModelo(), celular.getEmpresa(), celular.getIMEI()});				
			}
		}
		
		if(descricao.isEmpty()){
			descricao = "Não procurar $_$-$30";
		}else {
			descricao = descricao;
		}
		if(modelo.isEmpty()){
			modelo = "Não procurar $_$-$31";
		}else {
			modelo = modelo;
		}
		if(imei.isEmpty()){
			imei = "Não procurar $_$-$32";
		}else {
			imei = imei;
		}
		if(marca.isEmpty()){
			marca = "Não procurar $_$-$33";
		}else {
			marca = marca;
		}
		
		for(Celular celular : celulares){
				if((celular.getDescricao().contains(descricao.toUpperCase()) 
						|| (celular.getModelo().toUpperCase().contains(modelo.toUpperCase()))
							|| (celular.getIMEI().toUpperCase().contains(imei.toUpperCase()))
								|| (celular.getEmpresa().toUpperCase().contains(marca.toUpperCase())))){
					dtm.addRow(new String[]{celular.get_id(), celular.getModelo(), celular.getEmpresa(), celular.getIMEI()});		
				}
				
			}
		}
		

	
	
}
