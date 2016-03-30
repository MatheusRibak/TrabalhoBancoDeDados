package Model;

import org.jongo.marshall.jackson.oid.MongoObjectId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
	
	public final static String NOME_COLLECTION = Usuario.class.getSimpleName()
			.toLowerCase();
	@MongoObjectId
	private String _id;
	private String login;
	private String senha;
	private Integer nivelAcesso; // nível = 1 (Vendedor) = 2 (Gestor)
	private Vendedor vendedor;

}