package Model;

import org.bson.types.ObjectId;

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
	private ObjectId _id;
	private String modelo; 
	private String empresa;  
	private String descricao;
	private String cameraTraseira;
	private String memoriaRAM; 
	private String memoria; 
	private String quantidadeChips;
	private Double valor;
	private String IMEI; 
	
	private String tamanhoDaTela;
	private String sistemaOperacional;
	private String cameraFrontal;
	private String tipoChip; 
	private String peso;
	private String garantia;
	private String cor;
	private String TV; 
	private String conectividade; 	

}
