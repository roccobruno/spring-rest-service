package com.bruno.exception;

import com.bruno.utils.MessageJson;

public class NotFoundException extends ControllerException {
	
	private MessageJson messageJson = new MessageJson("URL does not exist!");
	private int statusCode = 404;
	
	public NotFoundException(){}

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
