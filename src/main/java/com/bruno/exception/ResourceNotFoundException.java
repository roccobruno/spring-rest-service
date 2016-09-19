package com.bruno.exception;

import com.bruno.utils.MessageJson;

public class ResourceNotFoundException extends Exception implements IGeneralException {
	
	private MessageJson messageJson = new MessageJson("La risorsa richiesta risulta non esistente!");
	
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
}
