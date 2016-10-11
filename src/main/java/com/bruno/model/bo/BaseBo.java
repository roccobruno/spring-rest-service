package com.bruno.model.bo;

public abstract class BaseBo {
	
	protected String codLocProg;
	private Metadata metadata = new Metadata();
	
	public String getCodLocProg() {
		return codLocProg;
	}
	public void setCodLocProg(String codLocProg) {
		this.codLocProg = codLocProg;
	}
	public Metadata getMetadata() {
		return metadata;
	}
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
}
