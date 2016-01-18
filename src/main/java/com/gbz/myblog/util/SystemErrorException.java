package com.gbz.myblog.util;

public class SystemErrorException extends Exception {

	private static final long serialVersionUID = 3232508041216286258L;

	public SystemErrorException(String errorMessage) {
		super(errorMessage);
	}

	public SystemErrorException() {
		super();
	}

	public SystemErrorException(String message, Exception e) {
		super(message, e);
	}

	public SystemErrorException(Exception e) {
		super(e);
	}
}
