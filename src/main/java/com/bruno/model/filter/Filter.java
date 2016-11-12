package com.bruno.model.filter;

import java.io.IOException;
import java.io.Serializable;
import com.bruno.service.filejob.FileJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Filter implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(Filter.class);
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
	private Integer numRecords;
	private Integer numPagina = 1;		
	private Integer numRecordsForPage = 10;
	private String filterPaginator;
	private Integer totalRecords;
	private String ordinaPer;


	public Filter() {}

	public Filter(Integer numeroDiRecord) {

	}

//	public Filter(@Value("${mopWS.numRecordsForPage}") Integer numRecordsForPage){
//		this.numRecordsForPage = numRecordsForPage;
//	}

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
										  .append(this.numRecords != null ? "&numRecords="+this.numRecords : "")
										  .append(this.ordinaPer != null ? "&ordinaPer="+this.ordinaPer : "");
        return builder.toString();
	}

	public String getCup() {
		return cup;
	}

	public void setCup(String cup) {
		this.cup = cup;
	}

	public String getCig() {
		return cig;
	}

	public void setCig(String cig) {
		this.cig = cig;
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

	public Integer getNumRecords() {
		return numRecords;
	}

	public void setNumRecords(Integer numRecords) {
		this.numRecords = numRecords;
	}

	public Integer getNumPagina() {
		return numPagina;
	}

	public void setNumPagina(Integer numPagina) {
		this.numPagina = numPagina;
	}

	public Integer getNumRecordsForPage() {
		return numRecordsForPage;
	}

	public void setNumRecordsForPage(Integer numRecordsForPage) {
		this.numRecordsForPage = numRecordsForPage;
	}

	public Integer getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}

	public String getOrdinaPer() {
		return ordinaPer;
	}

	public void setOrdinaPer(String ordinaPer) {
		this.ordinaPer = ordinaPer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String toJson() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {

            return "";
        }
    }

	public static Filter getFilterFromJob(final FileJob job) {
		Filter fitler = new Filter();
		try {
			fitler = new ObjectMapper().readValue(job.getConfig().getBytes(),Filter.class);
		} catch (IOException e) {
			log.error("Error in parsing Filter json : "+job.getConfig());
		}
		return fitler;
	}
}
