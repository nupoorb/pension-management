package com.cognizant.exception;

@SuppressWarnings("serial")
public class TokenInvalidException extends Exception {
	
    public TokenInvalidException() {
		super();
	}

	public TokenInvalidException(String msg) {
        super(msg);
    }
}
