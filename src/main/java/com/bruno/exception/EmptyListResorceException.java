package com.bruno.exception;

import com.bruno.utils.MessageJson;

public class EmptyListResorceException extends Exception {
	
	private MessageJson messageJson = new MessageJson("Non e' stato trovato nessun record per la ricerca effettuata!");
	
	public void EmptyListResorceException(){}
	
	public void EmptyListResorceException(MessageJson messageJson){
		this.messageJson = messageJson;
	}

	public MessageJson getMessageJson() {
		return messageJson;
	}

	public void setMessageJson(MessageJson messageJson) {
		this.messageJson = messageJson;
	}
	
}
