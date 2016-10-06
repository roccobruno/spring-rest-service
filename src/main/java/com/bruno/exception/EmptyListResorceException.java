package com.bruno.exception;

import com.bruno.utils.MessageJson;

public class EmptyListResorceException extends ControllerException {
	
	private MessageJson messageJson = new MessageJson("Non e' stato trovato nessun record per la ricerca effettuata!");
	private int statusCode = 401;
	
	public EmptyListResorceException(){}
	
	public EmptyListResorceException(MessageJson messageJson){
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
