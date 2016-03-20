package Model;

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
	private String data;
	private Cliente cliente;
	private Celular celular;
	private Vendedor vendedor;

}
