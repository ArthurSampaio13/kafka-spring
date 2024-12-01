package br.com.boleto.apiboleto.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<Object> applicationException(ApplicationException ex, WebRequest request) {
        var response = ErrorResponse.builder()
                .erro(ex.getMessage())
                .path(request.getDescription(false))
                .codigo(HttpStatus.BAD_REQUEST.value())
                .timestamp(new Date())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        var erros = ex.getFieldErrors()
                .stream()
                .map(item -> item.getField() + " " + item.getDefaultMessage() + " ")
                .collect(Collectors.joining());

        var response = ErrorResponse.builder()
                .erro(erros)
                .path(request.getDescription(false))
                .codigo(HttpStatus.BAD_REQUEST.value())
                .timestamp(new Date())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
