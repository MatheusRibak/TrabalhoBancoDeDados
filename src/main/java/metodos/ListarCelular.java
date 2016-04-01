package metodos;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Model.Celular;
import Telas.TelaInicial;

public class ListarCelular {

	public void listar(DefaultTableModel dtm, String descricao, String modelo, String imei, String marca) {
		ArrayList<Celular> celulares = TelaInicial.getTlInicial().getDao().listaQualquer(Celular.class);
		dtm.setRowCount(0);
		
		for(Celular celular : celulares){
			if((descricao.isEmpty()) && (modelo.isEmpty()) && imei.isEmpty() && (marca.isEmpty()) && (celular.getSituacao().equalsIgnoreCase("P"))){
				dtm.addRow(new String[]{celular.get_id().toString(), celular.getModelo(), celular.getEmpresa(), celular.getIMEI()});				
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
				if((celular.getDescricao().toUpperCase().contains(descricao.toUpperCase()) 
						|| (celular.getModelo().toUpperCase().contains(modelo.toUpperCase()))
							|| (celular.getIMEI().toUpperCase().contains(imei.toUpperCase()))
								|| (celular.getEmpresa().toUpperCase().contains(marca.toUpperCase())))){
					if(celular.getSituacao().equalsIgnoreCase("P")){
						dtm.addRow(new String[]{celular.get_id().toString(), celular.getModelo(), celular.getEmpresa(), celular.getIMEI()});
					}
				}
				
			}
		}
		

	
	
}
