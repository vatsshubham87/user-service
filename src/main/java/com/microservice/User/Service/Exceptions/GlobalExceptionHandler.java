package com.microservice.User.Service.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microservice.User.Service.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public  ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException exception){

       ApiResponse apiResponse = ApiResponse.builder()
            .message(exception.getMessage())
            .success(true)
            .status(HttpStatus.NOT_FOUND)
            .build();

            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND); 
    }
    
}
