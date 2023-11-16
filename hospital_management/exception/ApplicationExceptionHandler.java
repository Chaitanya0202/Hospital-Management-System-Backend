package com.qsp.hospital_management.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.hospital_management.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(HospitalIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(HospitalIdNotFoundException ex) {
	
		ResponseStructure<String>structure = new ResponseStructure<String>();
		structure.setMessage("Id NOt Found Exception");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData(ex.getMessage());
		return new   ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError>errors=ex.getAllErrors();
		Map<String, String> map=new HashMap<String, String>();
		
		for(ObjectError objectError:errors) {
			FieldError error=(FieldError)objectError;
			String fieldNmae=error.getField();
			String message=error.getDefaultMessage();
			map.put(fieldNmae, message);
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
		
	}
	
	

}
