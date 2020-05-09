package com.suresh.practice.nova.exception;

public class NovaMockServiceException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NovaMockServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public NovaMockServiceException(String message) {
		super(message);
	}

	public NovaMockServiceException(Throwable cause) {
		super(cause);
	}
}
