package com.bruno.model;

import java.io.Serializable;
import java.util.Calendar;

public class Filter implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nomeCooperativa;
	private Long numeroAccertamento;
	private String codiceFiscale;
	private String statoAccertamento;
	private String codiceTributo;
	private Long annoTributo;
	private Calendar dataDa;
	private Calendar dataA;
	private boolean assegnataMe;
	private Long idAssegnatario;
	private Long tipoIstanza;
	private Long statoIstanza;
	private boolean istanzaSpontanea;
	
	
	
	public String getStatoAccertamento() {
		return statoAccertamento;
	}
	public void setStatoAccertamento(String statoAccertamento) {
		this.statoAccertamento = statoAccertamento;
	}
	public Long getStatoIstanza() {
		return statoIstanza;
	}
	public void setStatoIstanza(Long statoIstanza) {
		this.statoIstanza = statoIstanza;
	}
	public String getNomeCooperativa() {
		return nomeCooperativa;
	}
	public void setNomeCooperativa(String nomeCooperativa) {
		this.nomeCooperativa = nomeCooperativa;
	}
	public Long getNumeroAccertamento() {
		return numeroAccertamento;
	}
	public void setNumeroAccertamento(Long numeroAccertamento) {
		this.numeroAccertamento = numeroAccertamento;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
	public String getCodiceTributo() {
		return codiceTributo;
	}
	public void setCodiceTributo(String codiceTributo) {
		this.codiceTributo = codiceTributo;
	}
	public Long getAnnoTributo() {
		return annoTributo;
	}
	public void setAnnoTributo(Long annoTributo) {
		this.annoTributo = annoTributo;
	}
	
	public Calendar getDataDa() {
		return dataDa;
	}
	public void setDataDa(Calendar dataDa) {
		this.dataDa = dataDa;
	}
	public Calendar getDataA() {
		return dataA;
	}
	public void setDataA(Calendar dataA) {
		this.dataA = dataA;
	}
	public boolean isAssegnataMe() {
		return assegnataMe;
	}
	public void setAssegnataMe(boolean assegnataMe) {
		this.assegnataMe = assegnataMe;
	}
	
	public Long getIdAssegnatario() {
		return idAssegnatario;
	}
	public void setIdAssegnatario(Long idAssegnatario) {
		this.idAssegnatario = idAssegnatario;
	}
	public Long getTipoIstanza() {
		return tipoIstanza;
	}
	public void setTipoIstanza(Long tipoIstanza) {
		this.tipoIstanza = tipoIstanza;
	}
	
	
	public boolean isIstanzaSpontanea() {
		return istanzaSpontanea;
	}
	public void setIstanzaSpontanea(boolean istanzaSpontanea) {
		this.istanzaSpontanea = istanzaSpontanea;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
