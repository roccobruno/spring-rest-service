package com.bruno.model;

// Generated Sep 6, 2016 2:40:20 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import com.bruno.model.json.PagamentiJson;

/**
 * SwPagamenti generated by hbm2java
 */
public class SwPagamenti implements java.io.Serializable {

	private long sequSwPagamento;
	private String soggetto;
	private String formaGiuridica;
	private String descKsogFogiDescFormaGiu;
	private String cup;
	private String settore;
	private String descCcupSipiDescSetCup;
	private String sottoSettore;
	private String descCcupSspiDescSsetCup;
	private String categoria;
	private String descCcupCipiDescCatCup;
	private String regione;
	private String descKregKregDescRegione;
	private String fonteCodLocaleProg;
	private String dimensione;
	private String tipologiaLavori;
	private String codLocProg;
	private Date dataPagamento;
	private String codicePagamento;
	private String tipologiaPagamento;
	private BigDecimal importo;
	private String codiceCausale;
	private String descrizioneCausale;
	private String codiCgelCgelId;
	private String descCgelCgelDescGest;
	private String codiceGestionale;
	private String descCodiceGestionale;
	private String note;

	public SwPagamenti() {
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



	public String getDescKsogFogiDescFormaGiu() {
		return descKsogFogiDescFormaGiu;
	}



	public void setDescKsogFogiDescFormaGiu(String descKsogFogiDescFormaGiu) {
		this.descKsogFogiDescFormaGiu = descKsogFogiDescFormaGiu;
	}



	public String getCup() {
		return cup;
	}



	public void setCup(String cup) {
		this.cup = cup;
	}



	public String getSettore() {
		return settore;
	}



	public void setSettore(String settore) {
		this.settore = settore;
	}



	public String getDescCcupSipiDescSetCup() {
		return descCcupSipiDescSetCup;
	}



	public void setDescCcupSipiDescSetCup(String descCcupSipiDescSetCup) {
		this.descCcupSipiDescSetCup = descCcupSipiDescSetCup;
	}



	public String getSottoSettore() {
		return sottoSettore;
	}



	public void setSottoSettore(String sottoSettore) {
		this.sottoSettore = sottoSettore;
	}



	public String getDescCcupSspiDescSsetCup() {
		return descCcupSspiDescSsetCup;
	}



	public void setDescCcupSspiDescSsetCup(String descCcupSspiDescSsetCup) {
		this.descCcupSspiDescSsetCup = descCcupSspiDescSsetCup;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public String getDescCcupCipiDescCatCup() {
		return descCcupCipiDescCatCup;
	}



	public void setDescCcupCipiDescCatCup(String descCcupCipiDescCatCup) {
		this.descCcupCipiDescCatCup = descCcupCipiDescCatCup;
	}



	public String getRegione() {
		return regione;
	}



	public void setRegione(String regione) {
		this.regione = regione;
	}



	public String getDescKregKregDescRegione() {
		return descKregKregDescRegione;
	}



	public void setDescKregKregDescRegione(String descKregKregDescRegione) {
		this.descKregKregDescRegione = descKregKregDescRegione;
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



	public String getCodLocProg() {
		return codLocProg;
	}

	public void setCodLocProg(String codLocProg) {
		this.codLocProg = codLocProg;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getCodicePagamento() {
		return codicePagamento;
	}

	public void setCodicePagamento(String codicePagamento) {
		this.codicePagamento = codicePagamento;
	}

	public String getTipologiaPagamento() {
		return tipologiaPagamento;
	}

	public void setTipologiaPagamento(String tipologiaPagamento) {
		this.tipologiaPagamento = tipologiaPagamento;
	}

	public BigDecimal getImporto() {
		return importo;
	}

	public void setImporto(BigDecimal importo) {
		this.importo = importo;
	}

	public String getCodiceCausale() {
		return codiceCausale;
	}

	public void setCodiceCausale(String codiceCausale) {
		this.codiceCausale = codiceCausale;
	}

	public String getDescrizioneCausale() {
		return descrizioneCausale;
	}

	public void setDescrizioneCausale(String descrizioneCausale) {
		this.descrizioneCausale = descrizioneCausale;
	}

	public String getCodiCgelCgelId() {
		return codiCgelCgelId;
	}

	public void setCodiCgelCgelId(String codiCgelCgelId) {
		this.codiCgelCgelId = codiCgelCgelId;
	}

	public String getDescCgelCgelDescGest() {
		return descCgelCgelDescGest;
	}

	public void setDescCgelCgelDescGest(String descCgelCgelDescGest) {
		this.descCgelCgelDescGest = descCgelCgelDescGest;
	}

	public String getCodiceGestionale() {
		return codiceGestionale;
	}

	public void setCodiceGestionale(String codiceGestionale) {
		this.codiceGestionale = codiceGestionale;
	}

	public String getDescCodiceGestionale() {
		return descCodiceGestionale;
	}

	public void setDescCodiceGestionale(String descCodiceGestionale) {
		this.descCodiceGestionale = descCodiceGestionale;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public long getSequSwPagamento() {
		return sequSwPagamento;
	}

	public void setSequSwPagamento(long sequSwPagamento) {
		this.sequSwPagamento = sequSwPagamento;
	}
	
	public PagamentiJson wrapperToJson(){
		
		PagamentiJson PJson = new PagamentiJson();
		PJson.setCodLocProg(this.codLocProg);
		PJson.setCodicePagamento(this.codicePagamento);
		PJson.setDataPagamento(this.dataPagamento);
		PJson.setImporto(this.importo);
		PJson.setTipologiaPagamento(this.tipologiaPagamento);
		PJson.setCodiceCausale(this.codiceCausale);
		PJson.setDescrizioneCausale(this.descrizioneCausale);
		PJson.setCodiceGestionale(this.codiceGestionale);
		PJson.setDescCodiceGestionale(this.descCodiceGestionale);
		PJson.setNote(this.note);
//		PJson.getMetadata().getLinks().setSelf("http://localhost:7001/spring-rest-service/api/v1.0/pagamenti/"+this.sequSwPagamento);
		return PJson;
	}
	
}
