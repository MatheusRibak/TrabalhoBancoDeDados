package Model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

	public final static String NOME_COLLECTION = Pessoa.class.getSimpleName()
			.toLowerCase();
	private String nome;
	private String rg;
	private String cpf;
	private Date dataNascimento;
	private Endereco endereco;
	private String telefoneCelular;
	private String email;

}
