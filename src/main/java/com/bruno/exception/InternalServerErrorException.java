package com.bruno.exception;

import com.bruno.utils.MessageJson;


public class InternalServerErrorException extends GeneralException {

	private Exception exception;
	private int statusCode = 500;

	public InternalServerErrorException(Exception e){
		this.exception = e;

	}

	public MessageJson getMessageJson() {
		return new MessageJson(exception.getMessage());
	}



	public int getStatusCode() {
		return statusCode;
	}


}
