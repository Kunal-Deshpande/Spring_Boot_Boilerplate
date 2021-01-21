package com.springbootboilerplate.springbootboilerplate.exception;

public class ValidationErrorException extends Exception {

    private static final long serialVersionUID = 1L;

    public ValidationErrorException(String message) {
        super(message);
    }
}
