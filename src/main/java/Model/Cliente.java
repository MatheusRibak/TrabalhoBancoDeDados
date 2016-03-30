package Model;

import org.jongo.marshall.jackson.oid.MongoObjectId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

	public final static String NOME_COLLECTION = Cliente.class.getSimpleName()
			.toLowerCase();
	private Pessoa pessoa;
	@MongoObjectId
	private String _id;

}
