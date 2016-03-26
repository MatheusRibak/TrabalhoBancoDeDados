package Model;

import Model.Venda;

public class NotaFiscal {
	//private Integer idNotaFiscal;
	private String dataEmissao;
	private Double valorTotal;
	private Loja loja;

	private Venda venda;

	public NotaFiscal(String dataEmissao, Double valorTotal, 
			Venda venda, Loja loja) {
		super();
		//this.idNotaFiscal = idNotaFiscal;
		this.dataEmissao = dataEmissao;
		this.valorTotal = valorTotal;
		
		this.venda = venda;
		this.loja = loja;
	}

	public NotaFiscal() {
		super();
	}

	//public Integer getIdNotaFiscal() {
		//return idNotaFiscal;
//	}

	//public void setIdNotaFiscal(Integer idNotaFiscal) {
		//this.idNotaFiscal = idNotaFiscal;
//	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

}
