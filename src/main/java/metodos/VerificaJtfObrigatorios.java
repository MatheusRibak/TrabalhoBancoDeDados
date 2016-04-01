package metodos;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.JTextField;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VerificaJtfObrigatorios {
	private String camposMostra = "\n";
	public Boolean verificaJtf(ArrayList<JTextField> jtfs,
			Map<JTextField, String> descricao) {
		Boolean ok = true;
		for (JTextField jtf : jtfs) {
			if (jtf.getText().length() > 0) {
			} else {
				camposMostra = camposMostra + descricao.get(jtf) + "\n";
				ok = false;
			}
		}
		return ok;
	}
}