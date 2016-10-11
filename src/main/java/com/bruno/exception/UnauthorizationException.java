package com.bruno.exception;

import javax.servlet.http.HttpServletResponse;

import com.bruno.utils.MessageJson;

public class UnauthorizationException extends ControllerException {
	
	private MessageJson messageJson = new MessageJson("Non Autorizzato!");
	private int statusCode = HttpServletResponse.SC_UNAUTHORIZED;
	
	public UnauthorizationException(){}
	
	public UnauthorizationException(MessageJson messageJson){
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
