package com.techiteasy.controller.controllers;

import com.techiteasy.controller.exceptions.ProductNameTooLongException;
import com.techiteasy.controller.exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler (value = RecordNotFoundException.class)
    public ResponseEntity<String> exception (RecordNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler (value = IndexOutOfBoundsException.class)
    public ResponseEntity<String> exception (IndexOutOfBoundsException exception) {
        return new ResponseEntity<>("No television with that id.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (value = ProductNameTooLongException.class)
    public ResponseEntity<String> exception (ProductNameTooLongException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
