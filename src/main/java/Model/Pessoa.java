package Model;

import java.util.Date;

import org.bson.types.ObjectId;

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
	private ObjectId _id;
	private String nome;
	private String rg;
	private String cpf;
	private Date dataNascimento;
	private String email;
	private Endereco endereco;
	private String estadoCivil;
	private String sexo; 
	private String telefoneCelular;
	private String telefoneResidencial;



}
