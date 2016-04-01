package metodos;

import Model.Celular;
import Telas.TelaInicial;

public class CadastroCelular {
	
	public Boolean cadastrar(String modelo, String empresa, String descricao, String cameraTraseira,
			String memoriaRam, String memoria, String quantidadeChips, Double valor, String imei, String tamanhoDatela,
				String sistemaOperacional, String cameraFrontal, String tipoChip, String peso, String garantia, String cor,
					String tv, String conectividade) {
		Boolean cadastrado = false;
		Celular celular = new Celular();
		celular.setModelo(modelo);
		celular.setEmpresa(empresa);
		celular.setDescricao(descricao);
		celular.setCameraTraseira(cameraTraseira);
		celular.setMemoriaRAM(memoriaRam);
		celular.setMemoria(memoria);
		celular.setQuantidadeChips(quantidadeChips);
		celular.setValor(valor);
		celular.setIMEI(imei);
		celular.setTamanhoDaTela(tamanhoDatela);
		celular.setSistemaOperacional(sistemaOperacional);
		celular.setCameraFrontal(cameraFrontal);
		celular.setTipoChip(tipoChip);
		celular.setPeso(peso);
		celular.setGarantia(garantia);
		celular.setCor(cor);
		celular.setTV(tv);
		celular.setConectividade(conectividade);
		celular.setSituacao("P");
		TelaInicial.getTlInicial().getDao().getDao().inserir(celular);
		cadastrado = true;
		return cadastrado;
	}
}
