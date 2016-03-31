package metodos;

import java.util.ArrayList;

import javax.swing.JTextField;

public class SubstituiCamposVazios {
	
	public void substitui(ArrayList<JTextField> jtfs) {
		for (JTextField jtf : jtfs) {
			if (jtf.getText().length() > 0) {
			} else {
				jtf.setText(" ");// para não gravar null
			}
		}
	}

	
}
