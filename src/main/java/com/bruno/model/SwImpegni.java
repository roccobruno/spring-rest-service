package com.bruno.model;

// Generated Sep 16, 2016 5:42:05 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * SwImpegni generated by hbm2java
 */
public class SwImpegni implements java.io.Serializable {

	private long sequSwImpegni;
	private String textKsogSoggCfiscale;
	private String textKsogFogiCodFormaGiur;
	private String descKsogFogiDescFormaGiu;
	private String codiCcupCcupAnagCcup;
	private String textCcupSipiCodSetInv;
	private String descCcupSipiDescSetCup;
	private String textCcupSspiCodSsetInv;
	private String descCcupSspiDescSsetCup;
	private String textCcupCipiCodCatInv;
	private String descCcupCipiDescCatCup;
	private String codiKregKregId;
	private String descKregKregDescRegione;
	private String textCodFonte;
	private String descDimensione;
	private String textCcupTipiCodTipInv;
	private String codiKurpUrpiCodLocProg;
	private Date dataImpegno;
	private String flgTipologiaImpegno;
	private String textFigvCodImpegno;
	private String textFigvNoteImpegno;
	private BigDecimal impoFigvImporto;

	public SwImpegni() {
	}

	public SwImpegni(long sequSwImpegni) {
		this.sequSwImpegni = sequSwImpegni;
	}

	public SwImpegni(long sequSwImpegni, String textKsogSoggCfiscale,
			String textKsogFogiCodFormaGiur, String descKsogFogiDescFormaGiu,
			String codiCcupCcupAnagCcup, String textCcupSipiCodSetInv,
			String descCcupSipiDescSetCup, String textCcupSspiCodSsetInv,
			String descCcupSspiDescSsetCup, String textCcupCipiCodCatInv,
			String descCcupCipiDescCatCup, String codiKregKregId,
			String descKregKregDescRegione, String textCodFonte,
			String descDimensione, String textCcupTipiCodTipInv,
			String codiKurpUrpiCodLocProg, Date dataImpegno,
			String flgTipologiaImpegno, String textFigvCodImpegno,
			String textFigvNoteImpegno, BigDecimal impoFigvImporto) {
		this.sequSwImpegni = sequSwImpegni;
		this.textKsogSoggCfiscale = textKsogSoggCfiscale;
		this.textKsogFogiCodFormaGiur = textKsogFogiCodFormaGiur;
		this.descKsogFogiDescFormaGiu = descKsogFogiDescFormaGiu;
		this.codiCcupCcupAnagCcup = codiCcupCcupAnagCcup;
		this.textCcupSipiCodSetInv = textCcupSipiCodSetInv;
		this.descCcupSipiDescSetCup = descCcupSipiDescSetCup;
		this.textCcupSspiCodSsetInv = textCcupSspiCodSsetInv;
		this.descCcupSspiDescSsetCup = descCcupSspiDescSsetCup;
		this.textCcupCipiCodCatInv = textCcupCipiCodCatInv;
		this.descCcupCipiDescCatCup = descCcupCipiDescCatCup;
		this.codiKregKregId = codiKregKregId;
		this.descKregKregDescRegione = descKregKregDescRegione;
		this.textCodFonte = textCodFonte;
		this.descDimensione = descDimensione;
		this.textCcupTipiCodTipInv = textCcupTipiCodTipInv;
		this.codiKurpUrpiCodLocProg = codiKurpUrpiCodLocProg;
		this.dataImpegno = dataImpegno;
		this.flgTipologiaImpegno = flgTipologiaImpegno;
		this.textFigvCodImpegno = textFigvCodImpegno;
		this.textFigvNoteImpegno = textFigvNoteImpegno;
		this.impoFigvImporto = impoFigvImporto;
	}

	public long getSequSwImpegni() {
		return this.sequSwImpegni;
	}

	public void setSequSwImpegni(long sequSwImpegni) {
		this.sequSwImpegni = sequSwImpegni;
	}

	public String getTextKsogSoggCfiscale() {
		return this.textKsogSoggCfiscale;
	}

	public void setTextKsogSoggCfiscale(String textKsogSoggCfiscale) {
		this.textKsogSoggCfiscale = textKsogSoggCfiscale;
	}

	public String getTextKsogFogiCodFormaGiur() {
		return this.textKsogFogiCodFormaGiur;
	}

	public void setTextKsogFogiCodFormaGiur(String textKsogFogiCodFormaGiur) {
		this.textKsogFogiCodFormaGiur = textKsogFogiCodFormaGiur;
	}

	public String getDescKsogFogiDescFormaGiu() {
		return this.descKsogFogiDescFormaGiu;
	}

	public void setDescKsogFogiDescFormaGiu(String descKsogFogiDescFormaGiu) {
		this.descKsogFogiDescFormaGiu = descKsogFogiDescFormaGiu;
	}

	public String getCodiCcupCcupAnagCcup() {
		return this.codiCcupCcupAnagCcup;
	}

	public void setCodiCcupCcupAnagCcup(String codiCcupCcupAnagCcup) {
		this.codiCcupCcupAnagCcup = codiCcupCcupAnagCcup;
	}

	public String getTextCcupSipiCodSetInv() {
		return this.textCcupSipiCodSetInv;
	}

	public void setTextCcupSipiCodSetInv(String textCcupSipiCodSetInv) {
		this.textCcupSipiCodSetInv = textCcupSipiCodSetInv;
	}

	public String getDescCcupSipiDescSetCup() {
		return this.descCcupSipiDescSetCup;
	}

	public void setDescCcupSipiDescSetCup(String descCcupSipiDescSetCup) {
		this.descCcupSipiDescSetCup = descCcupSipiDescSetCup;
	}

	public String getTextCcupSspiCodSsetInv() {
		return this.textCcupSspiCodSsetInv;
	}

	public void setTextCcupSspiCodSsetInv(String textCcupSspiCodSsetInv) {
		this.textCcupSspiCodSsetInv = textCcupSspiCodSsetInv;
	}

	public String getDescCcupSspiDescSsetCup() {
		return this.descCcupSspiDescSsetCup;
	}

	public void setDescCcupSspiDescSsetCup(String descCcupSspiDescSsetCup) {
		this.descCcupSspiDescSsetCup = descCcupSspiDescSsetCup;
	}

	public String getTextCcupCipiCodCatInv() {
		return this.textCcupCipiCodCatInv;
	}

	public void setTextCcupCipiCodCatInv(String textCcupCipiCodCatInv) {
		this.textCcupCipiCodCatInv = textCcupCipiCodCatInv;
	}

	public String getDescCcupCipiDescCatCup() {
		return this.descCcupCipiDescCatCup;
	}

	public void setDescCcupCipiDescCatCup(String descCcupCipiDescCatCup) {
		this.descCcupCipiDescCatCup = descCcupCipiDescCatCup;
	}

	public String getCodiKregKregId() {
		return this.codiKregKregId;
	}

	public void setCodiKregKregId(String codiKregKregId) {
		this.codiKregKregId = codiKregKregId;
	}

	public String getDescKregKregDescRegione() {
		return this.descKregKregDescRegione;
	}

	public void setDescKregKregDescRegione(String descKregKregDescRegione) {
		this.descKregKregDescRegione = descKregKregDescRegione;
	}

	public String getTextCodFonte() {
		return this.textCodFonte;
	}

	public void setTextCodFonte(String textCodFonte) {
		this.textCodFonte = textCodFonte;
	}

	public String getDescDimensione() {
		return this.descDimensione;
	}

	public void setDescDimensione(String descDimensione) {
		this.descDimensione = descDimensione;
	}

	public String getTextCcupTipiCodTipInv() {
		return this.textCcupTipiCodTipInv;
	}

	public void setTextCcupTipiCodTipInv(String textCcupTipiCodTipInv) {
		this.textCcupTipiCodTipInv = textCcupTipiCodTipInv;
	}

	public String getCodiKurpUrpiCodLocProg() {
		return this.codiKurpUrpiCodLocProg;
	}

	public void setCodiKurpUrpiCodLocProg(String codiKurpUrpiCodLocProg) {
		this.codiKurpUrpiCodLocProg = codiKurpUrpiCodLocProg;
	}

	public Date getDataImpegno() {
		return this.dataImpegno;
	}

	public void setDataImpegno(Date dataImpegno) {
		this.dataImpegno = dataImpegno;
	}

	public String getFlgTipologiaImpegno() {
		return this.flgTipologiaImpegno;
	}

	public void setFlgTipologiaImpegno(String flgTipologiaImpegno) {
		this.flgTipologiaImpegno = flgTipologiaImpegno;
	}

	public String getTextFigvCodImpegno() {
		return this.textFigvCodImpegno;
	}

	public void setTextFigvCodImpegno(String textFigvCodImpegno) {
		this.textFigvCodImpegno = textFigvCodImpegno;
	}

	public String getTextFigvNoteImpegno() {
		return this.textFigvNoteImpegno;
	}

	public void setTextFigvNoteImpegno(String textFigvNoteImpegno) {
		this.textFigvNoteImpegno = textFigvNoteImpegno;
	}

	public BigDecimal getImpoFigvImporto() {
		return this.impoFigvImporto;
	}

	public void setImpoFigvImporto(BigDecimal impoFigvImporto) {
		this.impoFigvImporto = impoFigvImporto;
	}

}
