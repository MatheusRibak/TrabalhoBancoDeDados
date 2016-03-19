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
	
	private String nome;
	private String rg;
	private String cpf;
	private Date dataNascimento;
	private Endereco endereco;
	private String telefoneCelular;
	private String email;


}
