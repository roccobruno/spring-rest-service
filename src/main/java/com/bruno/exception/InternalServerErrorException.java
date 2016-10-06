package com.bruno.exception;

import com.bruno.utils.MessageJson;

public class InternalServerErrorException extends ControllerException {

	private static final long serialVersionUID = 1L;
	
	private MessageJson messageJson = new MessageJson("Si è verificato un errore interno al server! Riprovare oppure contattare l'assistenza.");
	private int statusCode = 500;
	
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	}
