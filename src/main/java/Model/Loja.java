package Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Loja {
	
	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;
	private Endereco endereco;
	private String telefone;

}
