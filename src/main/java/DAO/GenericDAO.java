package DAO;

import java.util.List;

import org.jongo.Jongo;

import com.mongodb.MongoClient;

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
	
	public void inserir(Class entidade){
		
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