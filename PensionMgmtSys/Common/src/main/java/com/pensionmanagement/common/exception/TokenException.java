package com.pensionmanagement.common.exception;

public class TokenException extends Exception {
	private static final long serialVersionUID = 1L;
	public TokenException(String msg)
	{
		super("Invalid Token. ");
	}
	
}
