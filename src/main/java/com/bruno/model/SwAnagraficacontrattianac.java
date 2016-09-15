package com.bruno.model;

// Generated Sep 6, 2016 2:40:20 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * SwAnagraficacontrattianac generated by hbm2java
 */
public class SwAnagraficacontrattianac implements java.io.Serializable {

	private long sequSwAnagcontratti;
	private String textKsogSogCfiscaleStApp;
	private String textKsogSogDenStApp;
	private String textKsogSoggCfiscale;
	private String textKsogSoggDenominazione;
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
	private String textCcupTipiCodTipInv;
	private String codiKcigCcigCodCig;
	private String codiFmpgCodDocumento;
	private String descFmpgOggettoDocum;
	private Date dataContratto;
	private BigDecimal importoContratto;
	private BigDecimal importoFineContratto;
	private Date dataFineContratto;

	public SwAnagraficacontrattianac() {
	}

	public SwAnagraficacontrattianac(long sequSwAnagcontratti) {
		this.sequSwAnagcontratti = sequSwAnagcontratti;
	}

	public SwAnagraficacontrattianac(long sequSwAnagcontratti,
			String textKsogSogCfiscaleStApp, String textKsogSogDenStApp,
			String textKsogSoggCfiscale, String textKsogSoggDenominazione,
			String textKsogFogiCodFormaGiur, String descKsogFogiDescFormaGiu,
			String codiCcupCcupAnagCcup, String textCcupSipiCodSetInv,
			String descCcupSipiDescSetCup, String textCcupSspiCodSsetInv,
			String descCcupSspiDescSsetCup, String textCcupCipiCodCatInv,
			String descCcupCipiDescCatCup, String codiKregKregId,
			String descKregKregDescRegione, String textCodFonte,
			String textCcupTipiCodTipInv, String codiKcigCcigCodCig,
			String codiFmpgCodDocumento, String descFmpgOggettoDocum,
			Date dataContratto, BigDecimal importoContratto,
			BigDecimal importoFineContratto, Date dataFineContratto) {
		this.sequSwAnagcontratti = sequSwAnagcontratti;
		this.textKsogSogCfiscaleStApp = textKsogSogCfiscaleStApp;
		this.textKsogSogDenStApp = textKsogSogDenStApp;
		this.textKsogSoggCfiscale = textKsogSoggCfiscale;
		this.textKsogSoggDenominazione = textKsogSoggDenominazione;
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
		this.textCcupTipiCodTipInv = textCcupTipiCodTipInv;
		this.codiKcigCcigCodCig = codiKcigCcigCodCig;
		this.codiFmpgCodDocumento = codiFmpgCodDocumento;
		this.descFmpgOggettoDocum = descFmpgOggettoDocum;
		this.dataContratto = dataContratto;
		this.importoContratto = importoContratto;
		this.importoFineContratto = importoFineContratto;
		this.dataFineContratto = dataFineContratto;
	}

	public long getSequSwAnagcontratti() {
		return this.sequSwAnagcontratti;
	}

	public void setSequSwAnagcontratti(long sequSwAnagcontratti) {
		this.sequSwAnagcontratti = sequSwAnagcontratti;
	}

	public String getTextKsogSogCfiscaleStApp() {
		return this.textKsogSogCfiscaleStApp;
	}

	public void setTextKsogSogCfiscaleStApp(String textKsogSogCfiscaleStApp) {
		this.textKsogSogCfiscaleStApp = textKsogSogCfiscaleStApp;
	}

	public String getTextKsogSogDenStApp() {
		return this.textKsogSogDenStApp;
	}

	public void setTextKsogSogDenStApp(String textKsogSogDenStApp) {
		this.textKsogSogDenStApp = textKsogSogDenStApp;
	}

	public String getTextKsogSoggCfiscale() {
		return this.textKsogSoggCfiscale;
	}

	public void setTextKsogSoggCfiscale(String textKsogSoggCfiscale) {
		this.textKsogSoggCfiscale = textKsogSoggCfiscale;
	}

	public String getTextKsogSoggDenominazione() {
		return this.textKsogSoggDenominazione;
	}

	public void setTextKsogSoggDenominazione(String textKsogSoggDenominazione) {
		this.textKsogSoggDenominazione = textKsogSoggDenominazione;
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

	public String getTextCcupTipiCodTipInv() {
		return this.textCcupTipiCodTipInv;
	}

	public void setTextCcupTipiCodTipInv(String textCcupTipiCodTipInv) {
		this.textCcupTipiCodTipInv = textCcupTipiCodTipInv;
	}

	public String getCodiKcigCcigCodCig() {
		return this.codiKcigCcigCodCig;
	}

	public void setCodiKcigCcigCodCig(String codiKcigCcigCodCig) {
		this.codiKcigCcigCodCig = codiKcigCcigCodCig;
	}

	public String getCodiFmpgCodDocumento() {
		return this.codiFmpgCodDocumento;
	}

	public void setCodiFmpgCodDocumento(String codiFmpgCodDocumento) {
		this.codiFmpgCodDocumento = codiFmpgCodDocumento;
	}

	public String getDescFmpgOggettoDocum() {
		return this.descFmpgOggettoDocum;
	}

	public void setDescFmpgOggettoDocum(String descFmpgOggettoDocum) {
		this.descFmpgOggettoDocum = descFmpgOggettoDocum;
	}

	public Date getDataContratto() {
		return this.dataContratto;
	}

	public void setDataContratto(Date dataContratto) {
		this.dataContratto = dataContratto;
	}

	public BigDecimal getImportoContratto() {
		return this.importoContratto;
	}

	public void setImportoContratto(BigDecimal importoContratto) {
		this.importoContratto = importoContratto;
	}

	public BigDecimal getImportoFineContratto() {
		return this.importoFineContratto;
	}

	public void setImportoFineContratto(BigDecimal importoFineContratto) {
		this.importoFineContratto = importoFineContratto;
	}

	public Date getDataFineContratto() {
		return this.dataFineContratto;
	}

	public void setDataFineContratto(Date dataFineContratto) {
		this.dataFineContratto = dataFineContratto;
	}

}
