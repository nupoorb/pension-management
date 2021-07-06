package com.pensionmanagement.common.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pensionmanagement.common.model.ServiceResponse;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResponseHandler<T> {
	public <R> ResponseEntity<R> defaultResponse(T data) {
		ServiceResponse<T> responseModel = (ServiceResponse<T>) ServiceResponse.builder()
				.success(true)
				.data(data)
				.build();
		
		return new ResponseEntity<R>((R) responseModel, HttpStatus.OK);
	}

	public <R> ResponseEntity<R> defaultResponse(T data, String message) {
		ServiceResponse<T> responseModel = (ServiceResponse<T>) ServiceResponse.builder()
				.success(true)
				.responseMessage(message)
				.data(data)
				.build();
		return new ResponseEntity<R>((R) responseModel, HttpStatus.OK);
	}

	public <R> ResponseEntity<R> defaultResponse(T data, String message, HttpStatus status) {
		ServiceResponse<T> responseModel = (ServiceResponse<T>) ServiceResponse.builder()
				.success(true)
				.responseMessage(message)
				.data(data)
				.build();
		return new ResponseEntity<R>((R) responseModel, status);
	}

	public <R> ResponseEntity<R> defaultResponse(String message, HttpStatus status) {
		ServiceResponse<T> responseModel = (ServiceResponse<T>) ServiceResponse.builder()
				.success(true)
				.responseMessage(message)
				.build();
		return new ResponseEntity<R>((R) responseModel, status);
	}
}
