package principal;

import com.mongodb.client.MongoCursor;

import DAO.GenericDAO;
import Model.Celular;
import menu.MenuPrincipal;

public class Main {
	
	public static void main(String[] args) {		
		System.out.println("Seja bem-vindo ao sistema!");
		GenericDAO dao = new GenericDAO();
		Object objeto = dao.buscar(Celular.class, "Model.Celular", "empresa", "Samsung");
		
		Celular celular = new Celular();
		celular = (Celular) objeto;
		System.out.println(celular.getDescricao());
		

		MenuPrincipal mp = new MenuPrincipal();
	}
	
}