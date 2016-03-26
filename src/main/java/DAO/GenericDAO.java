package DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import Model.Celular;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCursor;

public class GenericDAO<T> {
	
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

	public Object buscar(Class classe, String collectionNome ,String campoConsulta, String cond){
		MongoCollection collection = jongo.getCollection(collectionNome);
		Object objeto = collection.findOne("{"+campoConsulta+":'"+cond+"'}").as(classe);
		return objeto;
	}

	/*public MongoCursor<Object> listar(Class classe, String collectionNome ,String campoConsulta, String cond){
		MongoCollection collection = jongo.getCollection(collectionNome);
		Object objeto = collection.findOne("{"+campoConsulta+":'"+cond+"'}").as(classe);
		
		//MongoCursor<Object> cursor = collection.find().as(classe);
		
	}*/
	
	public List<Object> todos(){
		
		return null;
	}

}