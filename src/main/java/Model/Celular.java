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
	private String memoriaRAM; //1GB, 2GB, etc;
	private String memoria; //memoria interna
	private String quantidadeChips;
	private Double valor;
	private String IMEI; 
	
	private String tamanhoDaTela;
	private String sistemaOperacional;
	private String cameraFrontal;
	private String tipoChip; //nano, normal, micro
	private String peso;
	private String garantia;
	private String cor;
	private String TV; // apenas sim ou não
	private String conectividade; //3g, 4g
	private String quantidade; //quantidade de ceulares que vão ser cadastrada. 
	

}
