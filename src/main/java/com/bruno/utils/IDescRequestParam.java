package com.bruno.utils;

import java.math.BigDecimal;
import java.util.Date;

public interface IDescRequestParam {
	
	final static String CUP = "Codice identificativo assegnato al progetto.";	
	final static String CIG = "Codice Identificativo della Gara (CIG) a cui si riferisce la Procedura.";
	final static String SOGGETTO = "Codice Fiscale del soggetto titolare del cup.";
	final static String FORMAGIURIDICA = "Codice della Forma Giuridica del Soggetto.";
	final static String SETTORE = "Codice della classificazione settoriale CPT.";
	final static String SOTTOSETTORE = "Codice del sottosettore di intervento.";
	final static String CATEGORIA = "Codice categoria di intervento.";
	final static String REGIONE = "Codice Istat della regione di ubicazione del progetto.";
	final static String FONTECODLOCALEPROG = "Codice Fonte di provenienza dei dati richiesti. Possibili valori: BATCHMOP;TP_MOP;BDU.";
	final static String DIMENSIONE = "Codice dimensione opera, Opere grandi, piccole e medie, in base al Quadro Economico. Possibili valori: OP(Opere Piccole),OM(Opere Madie),OG(Opere Grandi).";
	final static String TIPOLOGIALAVORI = "Codice tipologia dei lavori.";
	final static String NUMRECORDS = "Numero massimo dei record che si vogliono acquisire.";
	final static String ID = "Codice che identifica univocamente il record. Corrisponde al codice pagamento.";
	final static String AUTHORIZATIONID = "Codice da inviare nell'header della chiamata come autorizzazione!";
	final static String NUMPAGINA = "Numero della pagina per la quale si richiede lo scarico dei dati!";
	final static String ORDINAPERPAGAMENTI = "Parametro per il quale si intende ordinare i dati richiesti. Possibili valori: dataPagamento; codicePagamento; tipologiaPagamento; importo; codiceCausale; descrizioneCausale; codiceGestionale; descCodiceGestionale; note";
}
