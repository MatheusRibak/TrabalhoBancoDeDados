package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor 
@AllArgsConstructor
//nao fiz o @Setter porque tem salario e comissão

public class Vendedor {

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
