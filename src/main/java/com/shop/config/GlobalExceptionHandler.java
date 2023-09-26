package com.shop.config;

import com.shop.dto.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * A global exception handler for handling various exceptions in the application.
 * It provides custom error responses and logs exception details.
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * Handle global exceptions and return an Internal Server Error response.
     *
     * @param ex The exception to handle.
     * @return An Internal Server Error response with an error message.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse("500", "Internal Server Error", ex.getMessage());
        log.error("Exception occurred: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handle ResourceNotFoundException and return a Not Found response.
     *
     * @param ex The ResourceNotFoundException to handle.
     * @return A Not Found response with an error message.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse("404", "Resource Not Found", ex.getMessage());
        log.error("ResourceNotFoundException occurred: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handle IllegalArgumentException and return a Bad Request response.
     *
     * @param ex The IllegalArgumentException to handle.
     * @return A Bad Request response with an error message.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException ex) {
        ErrorResponse errorResponse = new ErrorResponse("400", "Bad Request", ex.getMessage());
        log.error("IllegalArgumentException occurred: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
