package com.bruno.model;

import java.io.Serializable;

public class Filter implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String cup;	
	private String cig;		
	private String soggetto;
	private String formaGiuridica;
	private String settore;
	private String sottoSettore;
	private String categoria;
	private String regione;
	private String fonteCodLocaleProg;
	private String dimensione;
	private String tipologiaLavori;
	private String numRecords;
	private String ordinaPer;
	
	
	public Filter(){}
	
	public String getCig() {
		return cig;
	}

	public void setCig(String cig) {
		this.cig = cig;
	}

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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public String getFonteCodLocaleProg() {
		return fonteCodLocaleProg;
	}

	public void setFonteCodLocaleProg(String fonteCodLocaleProg) {
		this.fonteCodLocaleProg = fonteCodLocaleProg;
	}

	public String getDimensione() {
		return dimensione;
	}

	public void setDimensione(String dimensione) {
		this.dimensione = dimensione;
	}

	public String getTipologiaLavori() {
		return tipologiaLavori;
	}

	public void setTipologiaLavori(String tipologiaLavori) {
		this.tipologiaLavori = tipologiaLavori;
	}

	public String getNumRecords() {
		return numRecords;
	}

	public void setNumRecords(String numRecords) {
		this.numRecords = numRecords;
	}

	public String getOrdinaPer() {
		return ordinaPer;
	}

	public void setOrdinaPer(String ordinaPer) {
		this.ordinaPer = ordinaPer;
	}	
}
