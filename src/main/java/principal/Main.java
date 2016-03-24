package principal;

import DAO.GenericDAO;
import Model.Celular;
import menu.MenuPrincipal;

public class Main {
	
	public static void main(String[] args) {		
		System.out.println("Seja bem-vindo ao sistema!");
		
		GenericDAO dao = new GenericDAO();
		Object objeto = dao.buscar(Celular.class, "empresa", "Samsung");
		Celular celular = (Celular) objeto;
		System.out.println(celular.getCamera());
		MenuPrincipal mp = new MenuPrincipal();
		
	}
	
}
