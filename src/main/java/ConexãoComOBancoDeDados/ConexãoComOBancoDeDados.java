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

public class Conex�oComOBancoDeDados {
	public static void main( String args[] ){
	 
	 try{ 
	 
		 //Come�ando a conex�o
		 MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
 
		 //Base que desejo usar
		 DB db = mongoClient.getDB( "TrabalhoBancoDeDados" );
		 System.out.println("A conex�o foi realizada com sucesso");
	 }catch(Exception e){
		 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
 }
 }
}