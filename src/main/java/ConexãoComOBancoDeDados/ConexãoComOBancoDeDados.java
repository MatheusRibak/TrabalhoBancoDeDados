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

public class ConexãoComOBancoDeDados {
	public static void main( String args[] ){
	 
	 try{ 
	 
		 //Começando a conexão
		 MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
 
		 //Base que desejo usar
		 DB db = mongoClient.getDB( "TrabalhoBancoDeDados" );
		 System.out.println("A conexão foi realizada com sucesso");
	 }catch(Exception e){
		 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
 }
 }
}