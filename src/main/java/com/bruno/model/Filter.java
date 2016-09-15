package com.bruno.model;

import java.io.Serializable;

public class Filter implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String cup;	
	private String soggetto;
	private String formaGiuridica;
	private String settore;
	private String sottoSettore;
	
	public Filter(){}
	
	public String getCup() {
		return cup;
	}
	public void setCup(String cup) {
		this.cup = cup;
	}
	public String getSoggetto() {
		return soggetto;
	}
	public void setSoggetto(String soggetto) {
		this.soggetto = soggetto;
	}
	public String getFormaGiuridica() {
		return formaGiuridica;
	}
	public void setFormaGiuridica(String formaGiuridica) {
		this.formaGiuridica = formaGiuridica;
	}
	public String getSettore() {
		return settore;
	}
	public void setSettore(String settore) {
		this.settore = settore;
	}
	
	public String getSottoSettore() {
		return sottoSettore;
	}
	
	public void setSottoSettore(String sottoSettore) {
		this.sottoSettore = sottoSettore;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
