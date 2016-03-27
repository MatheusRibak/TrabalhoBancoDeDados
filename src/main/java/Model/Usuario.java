package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Usuario {
	private String login;
	private String senha;
	private Integer nivelAcesso; // nível = 1 (corretor) = 2 (gestor)
	private Vendedor vendedor;

}