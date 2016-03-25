package principal;

import java.util.ArrayList;

import org.bson.Document;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;

import DAO.GenericDAO;
import Model.Celular;
import menu.MenuPrincipal;

public class Main {
	
	public static void main(String[] args) {		
		System.out.println("Seja bem-vindo ao sistema!");
		//GenericDAO dao = new GenericDAO();
		///Celular celular = new Celular();
		//celular.setDescricao("merda");
		//celular = dao.buscar(Celular.class, "empresa", "samsung");
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		Jongo jongo = new Jongo(mongoClient.getDB("TrabalhoBancoDeDados"));
		MongoCollection collection = jongo.getCollection("Celular");
		Celular celular = collection.findOne("{empresa:'samsung'}").as(Celular.class);
		System.out.println(celular.getDescricao().toString());
		MenuPrincipal mp = new MenuPrincipal();
		
	}
	
}
