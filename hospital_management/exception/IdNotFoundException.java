package com.qsp.hospital_management.exception;

public class IdNotFoundException extends RuntimeException{
	private String message;
	public String getMessage() {
		return message;
	}
	public IdNotFoundException(String message) {
		super();
		this.message = message;
	}
}
