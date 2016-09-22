package com.bruno.model.json;

import java.util.List;

public class PagamentiProva {
	
	private List<PagamentoProva> pagamenti;
	
	public PagamentiProva(){}
	
	public PagamentiProva(List<PagamentoProva> pagamenti){
		this.pagamenti = pagamenti;
	}

	public List<PagamentoProva> getPagamenti() {
		return pagamenti;
	}

	public void setPagamenti(List<PagamentoProva> pagamenti) {
		this.pagamenti = pagamenti;
	}
}
