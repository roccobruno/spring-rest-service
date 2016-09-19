package com.bruno.model.json;

import java.math.BigDecimal;
import java.util.Date;

public class PagamentiJson {
	
	private String codLocProg;
	private Date dataPagamento;
	private String codicePagamento;
	private String tipologiaPagamento;
	private BigDecimal importo;
	private String codiceCausale;
	private String descrizioneCausale;
	private String codiceGestionale;
	private String descCodiceGestionale;
	private String note;	
	private Metadata metadata = new Metadata();
	
	public PagamentiJson(){}
	
	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
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
}
