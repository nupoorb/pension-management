package com.pensionmanagement.common.model;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceResponse<T> {
	private boolean success;
	private Errors error;
	private T data;
	private String responseMessage;
	
	
	@Data
	@Builder
	public static class Errors {
		private HttpStatus errorCode;
		private String errorMessage;
	}
	
}
