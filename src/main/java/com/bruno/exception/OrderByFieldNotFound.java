package com.bruno.exception;

import javax.servlet.http.HttpServletResponse;

import com.bruno.utils.MessageJson;

public class OrderByFieldNotFound extends ControllerException{
	
	private MessageJson messageJson = new MessageJson("Il valore del parametro ordinaPer risulta errato!");
	private int statusCode = HttpServletResponse.SC_BAD_REQUEST;

	public OrderByFieldNotFound(){}

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
