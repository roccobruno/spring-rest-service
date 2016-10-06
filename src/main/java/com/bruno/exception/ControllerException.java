package com.bruno.exception;

import com.bruno.utils.MessageJson;

public abstract class ControllerException extends Throwable {

	public abstract MessageJson getMessageJson();
	public abstract int getStatusCode();
}
