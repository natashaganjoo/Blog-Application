package com.app.blog.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.blog.payload.APIResponse;

@RestControllerAdvice
// controller advice will control all the controllers of the application
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<APIResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {

		String message = ex.getMessage();
		APIResponse apiResponse = new APIResponse(message, false);
		return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public final ResponseEntity<APIResponse> handleMethodArgNotValidExc(MethodArgumentNotValidException ex) {
//
//		String message = ex.getMessage();
//		APIResponse apiResponse = new APIResponse(message, false);
//		return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
//	}

	// if we don't want more details in message then:
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public final ResponseEntity<Map<String, String>> handleMethodArgNotValidExc(MethodArgumentNotValidException ex) {

		Map<String, String> response = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();

			response.put(fieldName, message);
		});
		return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);

	}

}
