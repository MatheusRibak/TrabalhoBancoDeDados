package Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Loja {

	public final static String NOME_COLLECTION = Loja.class.getSimpleName()
			.toLowerCase();
	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;
	private Endereco endereco;
	private String telefone;

}
