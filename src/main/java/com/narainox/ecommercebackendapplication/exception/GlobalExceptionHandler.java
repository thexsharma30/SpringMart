package com.narainox.ecommercebackendapplication.exception;

import com.narainox.ecommercebackendapplication.payloads.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<APIResponse> recordNotFoundHandler(RecordNotFoundException recordNotFoundException)
    {
        APIResponse apiResponse=new APIResponse();
        apiResponse.setMessage(recordNotFoundException.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse> methodArgumentNotValidHandler(MethodArgumentNotValidException methodArgumentNotValidException)
    {
        APIResponse apiResponse=new APIResponse();
        apiResponse.setMessage(methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<APIResponse> internalServerHandler(HttpServerErrorException.InternalServerError methodArgumentNotValidException)
    {
        APIResponse apiResponse=new APIResponse();
        apiResponse.setMessage(methodArgumentNotValidException.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
