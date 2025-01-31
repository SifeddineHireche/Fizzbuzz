package com.entreprise.app.rest.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class ErrorsExceptionHandler {

    @ExceptionHandler(FizzBuzzException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleFizzBuzzException(FizzBuzzException e) {
        return Map.of(
                "error", "Parameters invalides",
                "message", e.getMessage(),
                "status", HttpStatus.BAD_REQUEST.value(),
                "timestamp", LocalDateTime.now()
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleGeneralException(Exception e) {
        return Map.of(
                "error", "Internal Server Error",
                "message", e.getMessage(),
                "status", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "timestamp", LocalDateTime.now()
        );
    }
}