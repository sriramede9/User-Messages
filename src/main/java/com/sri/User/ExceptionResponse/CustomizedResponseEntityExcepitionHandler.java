package com.sri.User.ExceptionResponse;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sri.User.controller.UserNotFoundException;

@ControllerAdvice
public class CustomizedResponseEntityExcepitionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> NoSuchUserException(Exception ex, WebRequest request) {
		
		ExceptionResponse exceptionresponse=new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionresponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	
}
