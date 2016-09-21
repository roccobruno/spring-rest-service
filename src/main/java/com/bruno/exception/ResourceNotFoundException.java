package com.bruno.exception;

import com.bruno.utils.MessageJson;

public class ResourceNotFoundException extends GeneralException {
	
	private MessageJson messageJson = new MessageJson("La risorsa richiesta risulta non esistente!");
	private int statusCode = 404;
	
	public ResourceNotFoundException(){}
	
	public ResourceNotFoundException(MessageJson messageJson){
		this.messageJson = messageJson;
	}

	public MessageJson getMessageJson() {
		return messageJson;
	}

	public void setMessageJson(MessageJson messageJson) {
		this.messageJson = messageJson;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}	
	
}
