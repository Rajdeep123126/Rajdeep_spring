package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(BookNotFoundException.class)
	
	public ResponseEntity<Errordetails> handle(BookNotFoundException ex) {
		Errordetails error = new Errordetails();
		error.setMessage(ex.getMessage());
		error.setStatuscode(HttpStatus.NOT_FOUND.value());
		error.setDatetime(LocalDateTime.now());

		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
}
