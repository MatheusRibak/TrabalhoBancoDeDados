package DAO;

import java.util.List;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.MongoClient;

public class GenericDAO {
	//test
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

	public Object buscar(Class classe, Integer id){
		
		return null;
	}

	public List<Object> todos(){
		
		return null;
	}

}