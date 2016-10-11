package com.bruno.model.response;

public class Paging {
	
	private String previousPageLink;
	private String nextPageLink;

	public Paging(String previousPageLink,String nextPageLink){
		this.previousPageLink = previousPageLink;
		this.nextPageLink = nextPageLink;
	}
	
	public Paging(){}

	public String getPreviousPageLink() {
		return previousPageLink;
	}

	public void setPreviousPageLink(String previousPageLink) {
		this.previousPageLink = previousPageLink;
	}

	public String getNextPageLink() {
		return nextPageLink;
	}

	public void setNextPageLink(String nextPageLink) {
		this.nextPageLink = nextPageLink;
	}
}
