package com.bruno.model.response;

public abstract class BaseResult {
	
	private final Long totalRecords;
	private final Paging paging;
	
	public BaseResult(Long totalRecords,Paging paging){
		this.totalRecords = totalRecords;
		this.paging = paging;
	}

	public Long getTotalRecords() {
		return totalRecords;
	}

	public Paging getPaging() {
		return paging;
	}
}
