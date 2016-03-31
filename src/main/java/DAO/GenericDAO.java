package DAO;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import Model.Cliente;
import Model.Entidade;
import Model.Usuario;

import com.mongodb.MongoClient;


@Getter
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
		jongo = new Jongo(mongoClient.getDB("TrabalhoBancoDeDados2"));
	}
	
	public void inserir(Object entidade){
		MongoCollection collection = jongo.getCollection(entidade.getClass().getName());
		collection.insert(entidade);
		
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
	
	public void remove(Object objeto, ObjectId id){
		MongoCollection collection = jongo.getCollection(objeto.getClass().getName());
		collection.remove("{_id: #}", id);
	}
	
	public void alterar(Object objeto, ObjectId id){
		MongoCollection collection = jongo.getCollection(objeto.getClass().getName());
		collection.update("{_id: #}", id).with(objeto);
		//https://www.youtube.com/watch?v=9CuH8lHFGsA
	}
}