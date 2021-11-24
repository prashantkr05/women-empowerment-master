package com.capgemini.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomException extends ResponseEntityExceptionHandler {
	private static final Logger LOG = LoggerFactory.getLogger(CustomException.class);

	@ExceptionHandler(AdminAlreadyExistsException.class)
	public ResponseEntity<Object> handleAdminAlreadyExistsException() {
		LOG.error("AdminAlreadyExistsException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This admin is available in database");
		ResponseEntity<Object> response = new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
		return response;
	}

	@ExceptionHandler(AdminNotExistsException.class)
	public ResponseEntity<Object> handleAdminNotExistsExistsException() {
		LOG.error("AdminNotExistsException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This admin is not available in database");
		ResponseEntity<Object> response = new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
		return response;
	}

//	@ExceptionHandler(NoSuchRecordException.class)
//	public ResponseEntity<Object> handleNoSuchRecordException() {
//		LOG.error("handleNoSuchRecordException");
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("message", "This employee is NOT available in the database.");
//		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
//	}
}
