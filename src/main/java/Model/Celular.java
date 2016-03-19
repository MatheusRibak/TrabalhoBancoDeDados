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
	
	private String marca;
	private String descricao; //descrição adicional se o cara quiser, ja tem camera e memoria 
	private String camera;
	private String memoria;
	private Double valor;
	

}
