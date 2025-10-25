package com.employee.restapi_crud.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DataExistsException extends RuntimeException {
private String message;
}
