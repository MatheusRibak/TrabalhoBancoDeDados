package DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import Model.Celular;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCursor;

public class GenericDAO {
	
	private static GenericDAO genericDao;
	private Jongo jongo;

	public static GenericDAO getDao() {
		if (genericDao == null) {
			genericDao = new GenericDAO();
		}
		return genericDao;
	}


	public GenericDAO() {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		jongo = new Jongo(mongoClient.getDB("TrabalhoBancoDeDados"));
	}
	
	public void inserir(Object entidade){
		MongoCollection collection = jongo.getCollection(entidade.getClass().getName());
		collection.insert(entidade);
	}

	public void alterar(Class entidade){
		
	}

	public void excluir(Class entidade){
		
	}

	public Celular buscar(Class classe, String campoConsulta, String cond){
		System.out.println("buscar");
		MongoCollection collection = jongo.getCollection(classe.getName());
		System.out.println("collection");
		Celular celular = collection.findOne("{" + campoConsulta + ":'" + cond + "'}").as(Celular.class);
		System.out.println("collection.findone");
		return celular;
	}

	public List<Object> todos(){
		
		return null;
	}

}