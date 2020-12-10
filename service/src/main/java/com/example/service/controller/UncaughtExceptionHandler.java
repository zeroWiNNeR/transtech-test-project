package com.example.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
 * Created by Aleksei Vekovshinin on 10.12.2020
 */
@RestControllerAdvice
public class UncaughtExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleAll(Exception e) {
        log.error("Unhandled exception occurred", e);
        return new ResponseEntity<>(new Error(e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private static class Error {

        private String message;

        public Error(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
