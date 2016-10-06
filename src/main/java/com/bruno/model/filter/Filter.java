package com.bruno.model.filter;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
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
	private Integer limit;
	private Integer numPagina = 1;	
	private Integer limitForPage = 10;
	private String filterPaginator;
	private Integer totalRecords;

	public Filter(){}
	
	
	public Filter(@Value("${mopWS.limitForPage}")Integer limitForPage){
		this.limitForPage = limitForPage;
	}
	
	public String getFilterPaginator() {
		StringBuilder builder = new StringBuilder(this.cup != null ? "&cup="+this.cup : "")
										  .append(this.cig != null ? "&cig="+this.cig : "")
//										  .append(this.soggetto != null ? "&soggetto="+this.soggetto : "")
//										  .append(this.formaGiuridica != null ? "&formaGiuridica="+this.formaGiuridica : "")
										  .append(this.settore != null ? "&settore="+this.settore : "")
										  .append(this.sottoSettore != null ? "&sottoSettore="+this.sottoSettore : "")
										  .append(this.categoria != null ? "&categoria="+this.categoria : "")
										  .append(this.regione != null ? "&regione="+this.regione : "")
										  .append(this.fonteCodLocaleProg != null ? "&fonteCodLocaleProg="+this.fonteCodLocaleProg : "")
										  .append(this.dimensione != null ? "&dimensione="+this.dimensione : "")
										  .append(this.tipologiaLavori != null ? "&tipologiaLavori="+this.tipologiaLavori : "")
										  .append(this.limit != null ? "&limit="+this.limit : "");
        return builder.toString();
	}

	public Integer getTotalRecords() {
		return totalRecords;
	}


	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}


	public void setFilterPaginator(String filterPaginator) {
		this.filterPaginator = filterPaginator;
	}

	public Integer getlimitForPage() {
		return limitForPage;
	}

	public void setlimitForPage(Integer limitForPage) {
		this.limitForPage = limitForPage;
	}

	public void setNumPagina(Integer numPagina) {
		this.numPagina = numPagina;
	}

	public Integer getNumPagina() {

		return numPagina;
	}
	
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

	public Integer getlimit() {
		return limit;
	}

	public void setlimit(Integer limit) {
		this.limit = limit;
	}	
}
