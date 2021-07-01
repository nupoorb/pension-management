package com.pensionmanagement.pensiondisbursement.exception;

@SuppressWarnings("serial")
public class TokenException extends Exception {
	
    public TokenException() {
		super();
	}

	public TokenException(String msg) {
        super(msg);
    }
}
