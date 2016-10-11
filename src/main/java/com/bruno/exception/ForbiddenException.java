package com.bruno.exception;

import javax.servlet.http.HttpServletResponse;

import com.bruno.utils.MessageJson;

public class ForbiddenException extends ControllerException{
	
	private MessageJson messageJson = new MessageJson("Non Autorizzato!");
	private int statusCode = HttpServletResponse.SC_FORBIDDEN;
	
	public ForbiddenException(){}

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
