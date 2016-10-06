package com.bruno.exception;

import com.bruno.utils.MessageJson;


public class FilterNotFoundException extends ControllerException {
	
	private static final long serialVersionUID = 1L;
	
	private MessageJson messageJson = new MessageJson("E' stato utilizzato un request parameter non esistente per la risorsa richiesta!");
	private int statusCode = 400;
	
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
