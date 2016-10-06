package com.bruno.exception;

import com.bruno.utils.MessageJson;

public class BudRequestException extends ControllerException {
	
	private MessageJson messageJson = new MessageJson("E' stato inserito un id non valido!");
	private int statusCode = 400;
	
	public BudRequestException(){}
	
	public BudRequestException(MessageJson messageJson){
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
