package com.employee.restapi_crud.exception;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employee.restapi_crud.dto.ErrorDTO;



@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(DataExistsException.class)
@ResponseStatus(value = HttpStatus.CONFLICT)
public ErrorDTO handle(DataExistsException exception) {
	return new ErrorDTO(exception.getMessage());
}

@ExceptionHandler(DataNotFoundException.class)
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public ErrorDTO handle(DataNotFoundException exception) {
	return new ErrorDTO(exception.getMessage());
}
}

