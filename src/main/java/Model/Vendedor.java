package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Vendedor {

	public final static String NOME_COLLECTION = Vendedor.class.getSimpleName()
			.toLowerCase();
	private Pessoa pessoa;
	private Double salario;
	private Double comissao;

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

}
