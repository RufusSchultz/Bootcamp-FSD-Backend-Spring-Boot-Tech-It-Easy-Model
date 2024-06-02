package com.techiteasy.model.exceptions;

public class ProductNameTooLongException extends RuntimeException {
    public ProductNameTooLongException() {
        super();
    }

    public ProductNameTooLongException(String message) {
        super(message);
    }
}
