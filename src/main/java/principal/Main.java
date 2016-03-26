package principal;

import org.bson.Document;

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
/*
 * 		MongoClient mongoClient = new MongoClient("localhost", 27017);
		Jongo jongo = new Jongo(mongoClient.getDB("TrabalhoBancoDeDados"));
		MongoCollection collection = jongo.getCollection("Model.Celular");
		Celular celular = collection.findOne("{empresa:'Samsung'}").as(Celular.class);
		System.out.println(celular.getDescricao());
 */