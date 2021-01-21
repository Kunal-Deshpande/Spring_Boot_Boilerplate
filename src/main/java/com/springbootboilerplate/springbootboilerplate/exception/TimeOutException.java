package com.springbootboilerplate.springbootboilerplate.exception;

public class TimeOutException extends Exception {

    private static final long serialVersionUID = 1L;

    public TimeOutException(String message) {
        super(message);
    }
}
