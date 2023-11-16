package com.qsp.hospital_management.exception;

public class EncounterIdNotFoundException extends RuntimeException {

	private String message;

	public String getMessage() {
		return message;
	}

	public EncounterIdNotFoundException(String message) {
		super();
		this.message = message;
	}
}
