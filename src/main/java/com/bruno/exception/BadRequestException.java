package com.bruno.exception;

import javax.servlet.http.HttpServletResponse;

import com.bruno.utils.MessageJson;

public class BadRequestException extends ControllerException {
	
	private MessageJson messageJson = new MessageJson("E' stato inserito un id non valido!");
	private int statusCode = HttpServletResponse.SC_BAD_REQUEST;
	
	public BadRequestException(){}
	
	public BadRequestException(MessageJson messageJson){
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
