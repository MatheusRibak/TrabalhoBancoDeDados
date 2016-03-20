package ConexãoComOBancoDeDados;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;

import java.util.Arrays;

import lombok.Getter;

public class ConexãoComOBancoDeDados {
	
	public static void main( String args[] ){
	 
	 try{ 
		 MongoClient mongoClient = new MongoClient( "localhost" , 27017 );//Começando a conexão
		 DB db = mongoClient.getDB( "TrabalhoBancoDeDados" ); //Base que desejo usar
		 System.out.println("Conexão com MONGODB foi realizada com sucesso!");
	 }catch(Exception e){
		 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
 }
 }

	
	
}