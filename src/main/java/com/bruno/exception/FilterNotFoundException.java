package com.bruno.exception;

import com.bruno.utils.MessageJson;


public class FilterNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MessageJson messageJson = new MessageJson("E' stato utilizzato un filtro non esistente per la risorsa richiesta!");
	
	public FilterNotFoundException(){}	

	public MessageJson getMessageJson() {
		return messageJson;
	}

	public void setMessageJson(MessageJson messageJson) {
		this.messageJson = messageJson;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
