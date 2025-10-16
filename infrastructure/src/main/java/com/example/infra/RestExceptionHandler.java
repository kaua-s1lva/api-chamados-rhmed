package com.example.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.domain.exception.AuthenticateException;
import com.example.domain.exception.ChangeStateException;
import com.example.domain.exception.EmailException;
import com.example.domain.exception.InternalServerErrorException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AuthenticateException.class)
    private ResponseEntity<String> userNotFoundHandler(AuthenticateException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(EmailException.class)
    private ResponseEntity<String> emailHandler(EmailException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

    @ExceptionHandler(ChangeStateException.class)
    private ResponseEntity<String> changeStateHandler(ChangeStateException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(InternalServerErrorException.class)
    private ResponseEntity<String> internalServerErrorHandler(InternalServerErrorException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }


}
