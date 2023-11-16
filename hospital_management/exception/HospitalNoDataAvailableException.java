package com.qsp.hospital_management.exception;

public class HospitalNoDataAvailableException extends RuntimeException{
	private String message;
	public String getMessage() {
		return message;
	}
	public HospitalNoDataAvailableException(String message) {
		super();
		this.message = message;
	}
}
