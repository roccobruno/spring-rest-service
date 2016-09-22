package com.bruno.model.json;

public class PagamentoProva {
	
	private PagamentiJson pagamento;
	
	public PagamentoProva(){}
	
	public PagamentoProva(PagamentiJson pagamento){
		this.pagamento = pagamento;
	}

	public PagamentiJson getPagamento() {
		return pagamento;
	}

	public void setPagamento(PagamentiJson pagamento) {
		this.pagamento = pagamento;
	}
	
}
