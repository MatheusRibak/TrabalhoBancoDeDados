package principal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import com.mongodb.client.MongoCursor;

import DAO.GenericDAO;
import Model.Celular;
import Model.Cliente;
import Model.Endereco;
import Model.Pessoa;
import Model.Venda;
import Model.Vendedor;
import menu.MenuPrincipal;

public class Main {
	
	public static void main(String[] args) {		
		System.out.println("Seja bem-vindo ao sistema!");
		GenericDAO dao = new GenericDAO();
		//Object objeto = dao.buscar(Celular.class, "Model.Celular", "empresa", "Samsung");
		
		//Celular celular = new Celular();
		//celular = (Celular) objeto;
		//System.out.println(celular.getDescricao());
		
		Date dataNasc = null;
		try {
			DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
			dataNasc = (Date)formatter.parse("01/24/07");
		} catch (ParseException e) {
			System.out.println("Erro na conversão da data de nascimento!");
		}		
		
		Endereco endereco1 = new Endereco("aaa", "aaa", "aaa", "aaaa", "aaaaa", "aaaa", "aaaa");
		Pessoa pessoa = new Pessoa("teste", "1212", "121212", dataNasc, "mtotom@", endereco1, "aaa", "aa", "312313", "111221");
		
		//Cliente cliente1 = new Cliente(pessoa);
		//Vendedor vendedor1 = new Vendedor(pessoa, 1500.0, 10.0);
		
		//Celular celular = new Celular("gt1212", "samsung", "asasasa", "13", "1", "500mb", "1", 500.0, "310310931093*/1212");
		
		//Date dataVenda = null;
		/*try {
			DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
			dataVenda = (Date)formatter.parse("03/28/16");
		} catch (ParseException e) {
			System.out.println("Erro na conversão da data de nascimento!");
		}		
		//Venda venda1 = new Venda(dataVenda, cliente1, celular, vendedor1);*/
		dao.inserir(pessoa);

		MenuPrincipal mp = new MenuPrincipal();
	}
	
}