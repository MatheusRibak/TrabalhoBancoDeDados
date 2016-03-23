package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Celular {

	public final static String NOME_COLLECTION = Celular.class.getSimpleName()
			.toLowerCase();
	private String modelo; // Exemplos: Nokia xxx, iPhone5s, Sansung s7
	private String empresa; //Nokia, Apple, entre outros. 
	private String descricao;
	private String camera;
	private String memoria;
	private Double valor;

}
