package Conex�oComOBancoDeDados;
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

public class Conex�oComOBancoDeDados {
	
	public static void main( String args[] ){
	 
	 try{ 
		 MongoClient mongoClient = new MongoClient( "localhost" , 27017 );//Come�ando a conex�o
		 DB db = mongoClient.getDB( "TrabalhoBancoDeDados" ); //Base que desejo usar
		 System.out.println("Conex�o com MONGODB foi realizada com sucesso!");
	 }catch(Exception e){
		 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
 }
 }

	
	
}