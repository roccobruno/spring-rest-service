package com.bruno.model.response;

import java.util.List;

import com.bruno.model.bo.PagamentiBo;

public class RisultatoPagamenti extends BaseResult {
	
	private final List<PagamentiBo> results;   

    public RisultatoPagamenti(Long totalRecords,List<PagamentiBo> results, Paging paging) {
    	super(totalRecords, paging);
        this.results = results;
    }

	public List<PagamentiBo> getResults() {
		return results;
	}
}
