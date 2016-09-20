package com.bruno.exception;

import com.bruno.utils.MessageJson;

public class ResourceByIdNotFound extends Exception implements IGeneralException {
	
	private MessageJson messageJson = new MessageJson("Non e' stato trovato nessun record con l'id specificato!!");
	private int statusCode = 403;
	
	public ResourceByIdNotFound(){}
	
	public ResourceByIdNotFound(MessageJson messageJson){
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
