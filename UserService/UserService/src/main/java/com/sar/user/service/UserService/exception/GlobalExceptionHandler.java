package com.sar.user.service.UserService.exception;

import com.sar.user.service.UserService.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
        String message = ex.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

}
