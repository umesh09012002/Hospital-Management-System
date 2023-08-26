package com.qsp.hospital_app.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.hospital_app.util.ResponseStructure;

@ControllerAdvice
public class ApplicationHandlerException extends ResponseEntityExceptionHandler{
	
	ResponseStructure<String> structure = new ResponseStructure<>();
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(IdNotFoundException exception)
	{
		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("ID Not Found");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmailNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> emailNotFoundExceptionHandler(EmailNotFoundException exception)
	{
		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Email Not Found");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> errors = ex.getAllErrors();
		Map<String, String> map = new LinkedHashMap<>();
		for (ObjectError error : errors) {
			String fieldName = ((FieldError) error).getField();
			String message = ((FieldError) error).getDefaultMessage();
			map.put(fieldName, message);
		}
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
	}

}
