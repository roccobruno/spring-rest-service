package com.bruno.model.response;

import java.util.List;

public class RisultatiRicerca<T> {

	private final Long totalRecords;
    private final List<T> results;    
	private final Paging paging;

    public RisultatiRicerca(Long totalRecords,List<T> results, Paging paging) {
    	this.totalRecords = totalRecords;
        this.results = results;
        this.paging = paging;
    }

	public Long getTotalRecords() {
		return totalRecords;
	}

	public List<T> getResults() {
		return results;
	}

	public Paging getPaging() {
		return paging;
	}    
    
}
