package principal;

import java.util.ArrayList;

import org.bson.Document;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;

import DAO.GenericDAO;
import Model.Celular;
import menu.MenuPrincipal;

public class Main {
	
	public static void main(String[] args) {		
		System.out.println("Seja bem-vindo ao sistema!");
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