package com.bruno.model.bo;

import java.util.List;

public class RisultatiRicerca<T> {

	private final Long totalRecords;
    private final List<T> results;
    private Paging paging;


    public RisultatiRicerca(Long totalRecords,List<T> results, Paging paging) {
    	this.totalRecords = totalRecords;
        this.results = results;
        this.paging = paging;
    }    
    

    public Long getTotalRecords() {
		return totalRecords;
	}


	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

    public List<T> getResults() {
        return results;
    }
}
