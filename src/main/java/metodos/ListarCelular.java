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
				dtm.addRow(new String[]{celular.getModelo(), celular.getEmpresa(), celular.getIMEI()});				
			}
		}
		
		if(descricao.isEmpty()){
			descricao = "$$94/^:D";
		}else {
			descricao = descricao;
		}
		if(modelo.isEmpty()){
			modelo = "$$94/^:D";
		}else {
			modelo = modelo;
		}
		if(imei.isEmpty()){
			imei = "$$94/^:D";
		}else {
			imei = imei;
		}
		if(marca.isEmpty()){
			marca = "$$94/^:D";
		}else {
			marca = marca;
		}
		
		for(Celular celular : celulares){
				if((celular.getDescricao().contains(descricao.toUpperCase()) 
						|| (celular.getModelo().toUpperCase().contains(modelo.toUpperCase()))
							|| (celular.getIMEI().toUpperCase().contains(imei.toUpperCase()))
								|| (celular.getEmpresa().toUpperCase().contains(marca.toUpperCase())))){
					dtm.addRow(new String[]{celular.getModelo(), celular.getEmpresa(), celular.getIMEI()});		
				}
				
			}
		}
		

	
	
}
