package DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.Getter;

import org.bson.Document;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import Model.Celular;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

@Getter
public class GenericDAO<T> {
	
	private static GenericDAO genericDao;
	private Jongo jongo;
	private MongoDatabase db;

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

	public Object listaFiltro(Class classe, String campo, String consulta){
		@SuppressWarnings("unchecked")
		Object objeto = jongo.getCollection(classe.getName()).findOne("{" + campo + ":'" + consulta + "'}").as(classe);
		return objeto;
		
	}
	
	public ArrayList<?> listaQualquer(Class classe){
		MongoCursor<?> cursor = (MongoCursor<?>) jongo.getCollection(classe.getName()).find().as(classe);
		ArrayList array = new ArrayList<>();
		cursor.forEach(retornado -> {
			array.add(retornado);
		});
		return array;
	}
	
	public List<Object> todos(){
		
		return null;
	}

}