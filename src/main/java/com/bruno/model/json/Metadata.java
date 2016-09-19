package com.bruno.model.json;

public class Metadata {
	
	private Links links = new Links();
	
	public Metadata(){}
	
	public Metadata(Links links){
		this.links = links;
	}

	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}
}
