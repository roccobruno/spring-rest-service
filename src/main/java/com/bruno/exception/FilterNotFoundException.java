package com.bruno.exception;

import com.bruno.utils.MessageJson;


public class FilterNotFoundException extends GeneralException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MessageJson messageJson = new MessageJson("E' stato utilizzato un filtro non esistente per la risorsa richiesta!");
	private int statusCode = 402;
	
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

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
}
