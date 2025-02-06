package me.dio.devweek.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class DevWeekExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(DevWeekExceptionHandler.class);

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<String> handle(IllegalArgumentException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<String> handle(NoSuchElementException exception) {
        return new ResponseEntity<>("ID não encontrado", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {Throwable.class})
    public ResponseEntity<String> handle(Throwable exception) {
        var message = "Erro insperado";
        logger.error("{}: {} {}", message, exception.getClass().getName(), exception.getMessage(), exception);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
