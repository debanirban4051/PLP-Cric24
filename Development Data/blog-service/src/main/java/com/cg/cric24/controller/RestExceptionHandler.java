package com.cg.cric24.controller;

/**
 * @author Anirban
 * @version 1.0
 * 
 * 
 * */

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.cric24.dto.UDEDetails;
import com.cg.cric24.exception.BlogNotFoundException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BlogNotFoundException.class)
	@ResponseBody
	public ResponseEntity<Object> handleInvalidEntry(BlogNotFoundException ex){
		UDEDetails error = new UDEDetails();
		error.setTimestamp(new Date());
		error.setMessage(ex.getMessage());
		error.setDetails(ex.getUriDetails());
		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND );
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		return new ResponseEntity<>(errors, headers, status);

	}

}