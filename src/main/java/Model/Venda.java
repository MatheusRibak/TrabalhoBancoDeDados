package Model;

import java.util.Date;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Venda {
	public final static String NOME_COLLECTION = Venda.class.getSimpleName()
			.toLowerCase();
	private Date data;
	private Cliente cliente;
	private Celular celular;
	private Usuario usuario;
	private ObjectId _id;
}