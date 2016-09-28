package com.bruno.model.response;

import java.util.List;

public class RisultatiRicerca<T> extends BaseResult {

    private final List<T> results;

    public RisultatiRicerca(Long totalRecords,List<T> results, Paging paging) {
    	super(totalRecords, paging);
        this.results = results;
    }    
    
    public List<T> getResults() {
        return results;
    }
}
