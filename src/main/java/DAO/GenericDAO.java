package DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bson.Document;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import Model.Celular;

import com.mongodb.Block;
import com.mongodb.Cursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

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
		db = mongoClient.getDatabase("TrabalhoBancoDeDados");
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

	public ArrayList<?> listar(Class classe, String collectionNome){
		FindIterable<Document> iterable = db.getCollection(collectionNome).find();
		
		ArrayList<Document> docs = new ArrayList<Document>();
		iterable.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		        //System.out.println(document);
		    	docs.add(document);
		    }
		});
		return docs;
		
	}
	
	public List<Object> todos(){
		
		return null;
	}

}