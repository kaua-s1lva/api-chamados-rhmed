package com.example.infra;

import com.example.domain.exception.*;
import com.example.domain.exception.enums.ErrorCodeEnum;
import com.example.dto.response.BaseResponse;
import com.example.dto.response.ErrorResponse;
import com.example.dto.response.ValidationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.NonNull;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid (
        @NonNull MethodArgumentNotValidException ex, 
        @NonNull HttpHeaders headers, 
        @NonNull HttpStatusCode status, 
        @NonNull WebRequest request
    ) {
        List<ValidationError> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> new ValidationError(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());
        ErrorResponse errorResponse = new ErrorResponse(ErrorCodeEnum.GEN002.getCode(), ErrorCodeEnum.GEN002.getMessage(), errors);
        BaseResponse<Object> baseResponse = BaseResponse.builder().success(false).error(errorResponse).build();
        logger.warn("Validation error: {}", errors);
        return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            @NonNull HttpMessageNotReadableException ex,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatusCode status,
            @NonNull WebRequest request) {

        String errorMessage = "Valor inválido para o campo. Os valores aceitos são: ";
        Throwable cause = ex.getCause();

        if (cause instanceof com.fasterxml.jackson.databind.exc.InvalidFormatException) {
            com.fasterxml.jackson.databind.exc.InvalidFormatException ife = (com.fasterxml.jackson.databind.exc.InvalidFormatException) cause;
            if (ife.getTargetType() != null && ife.getTargetType().isEnum()) {
                errorMessage += java.util.Arrays.stream(ife.getTargetType().getEnumConstants())
                        .map(Object::toString)
                        .collect(Collectors.joining(", "));
            }
        } else {
            errorMessage = ex.getLocalizedMessage();
        }

        ErrorResponse errorResponse = new ErrorResponse(ErrorCodeEnum.GEN002.getCode(), errorMessage, null);
        BaseResponse<Object> baseResponse = BaseResponse.builder().success(false).error(errorResponse).build();
        logger.warn("Invalid request format: {}", errorMessage);
        return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<BaseResponse<Object>> handleAccessDeniedException(AccessDeniedException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ErrorCodeEnum.GEN005.getCode(), ex.getMessage(), null);
        BaseResponse<Object> baseResponse = BaseResponse.builder().success(false).error(errorResponse).build();
        logger.warn("Access denied: {}", ex.getMessage());
        return new ResponseEntity<>(baseResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<BaseResponse<Object>> handleNotFoundException(NotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getCode(), ex.getMessage(), null);
        BaseResponse<Object> baseResponse = BaseResponse.builder().success(false).error(errorResponse).build();
        logger.info("Resource not found: {}", ex.getMessage());
        return new ResponseEntity<>(baseResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthenticateException.class)
    public ResponseEntity<BaseResponse<Object>> handleAuthenticateException(AuthenticateException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getCode(), ex.getMessage(), null);
        BaseResponse<Object> baseResponse = BaseResponse.builder().success(false).error(errorResponse).build();
        logger.warn("Authentication failed: {}", ex.getMessage());
        return new ResponseEntity<>(baseResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<BaseResponse<Object>> handleEmailException(EmailException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getCode(), ex.getMessage(), null);
        BaseResponse<Object> baseResponse = BaseResponse.builder().success(false).error(errorResponse).build();
        logger.warn("Email conflict: {}", ex.getMessage());
        return new ResponseEntity<>(baseResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ChangeStateException.class)
    public ResponseEntity<BaseResponse<Object>> handleChangeStateException(ChangeStateException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getCode(), ex.getMessage(), null);
        BaseResponse<Object> baseResponse = BaseResponse.builder().success(false).error(errorResponse).build();
        logger.warn("Invalid state transition: {}", ex.getMessage());
        return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse<Object>> handleAllExceptions(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(ErrorCodeEnum.GEN004.getCode(), ErrorCodeEnum.GEN004.getMessage(), null);
        BaseResponse<Object> baseResponse = BaseResponse.builder().success(false).error(errorResponse).build();
        logger.error("An unexpected error occurred: ", ex);
        return new ResponseEntity<>(baseResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CreateUserException.class)
    public ResponseEntity<BaseResponse<Object>> handleCreateUserException(CreateUserException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getCode(), ex.getMessage(), null);
        BaseResponse<Object> baseResponse = BaseResponse.builder().success(false).error(errorResponse).build();
        logger.warn("User creation failed: {}", ex.getMessage());
        return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CreateTicketException.class)
    public ResponseEntity<BaseResponse<Object>> handleCreateTicketException(CreateTicketException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getCode(), ex.getMessage(), null);
        BaseResponse<Object> baseResponse = BaseResponse.builder().success(false).error(errorResponse).build();
        logger.warn("Ticket creation failed: {}", ex.getMessage());
        return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
    }
    
}