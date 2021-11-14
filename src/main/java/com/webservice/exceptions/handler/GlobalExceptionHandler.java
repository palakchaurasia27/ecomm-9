package com.webservice.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.webservice.exceptions.AuthenticationFailedException;
import com.webservice.exceptions.InvalidProductException;
import com.webservice.exceptions.InvalidUserException;
import com.webservice.exceptions.ProductAlreadyExistException;
import com.webservice.exceptions.ProductNotFoundException;
import com.webservice.exceptions.UserAlreadyExistException;
import com.webservice.exceptions.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	ExceptionResponse response;
	
	@ExceptionHandler(value=ProductNotFoundException.class)
	public ResponseEntity<ExceptionResponse> notFoundException(ProductNotFoundException exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), 
				HttpStatus.NOT_FOUND.name(), exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler(value=InvalidProductException.class)
	public ResponseEntity<ExceptionResponse> invalidException(InvalidProductException exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), 
				HttpStatus.BAD_REQUEST.name(), exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=ProductAlreadyExistException.class)
	public ResponseEntity<ExceptionResponse> alreadyExistException(ProductAlreadyExistException exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), 
				HttpStatus.BAD_REQUEST.name(), exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse> notFoundException(UserNotFoundException exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), 
				HttpStatus.NOT_FOUND.name(), exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler(value=InvalidUserException.class)
	public ResponseEntity<ExceptionResponse> invalidException(InvalidUserException exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), 
				HttpStatus.BAD_REQUEST.name(), exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=UserAlreadyExistException.class)
	public ResponseEntity<ExceptionResponse> alreadyExistException(UserAlreadyExistException exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), 
				HttpStatus.BAD_REQUEST.name(), exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.BAD_REQUEST);
	}
		@ExceptionHandler(value=AuthenticationFailedException.class)
		public ResponseEntity<ExceptionResponse> unauthorizedException(AuthenticationFailedException exception){
			response = new ExceptionResponse(exception.getMessage(),new Date(), HttpStatus.METHOD_NOT_ALLOWED.name(), exception.getClass().getSimpleName());
			return new ResponseEntity<>(response,HttpStatus.METHOD_NOT_ALLOWED);
		}
	}
