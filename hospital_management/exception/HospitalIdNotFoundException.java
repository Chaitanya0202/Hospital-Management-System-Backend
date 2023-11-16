package com.qsp.hospital_management.exception;

public class HospitalIdNotFoundException extends RuntimeException{
//	String message="Hospital Id Not Found Give Propere Id";
	
	private String message;
	public String getMessage() {
		return message;
	}
	public HospitalIdNotFoundException(String message) {
		super();
		this.message = message;
	}
	
}

