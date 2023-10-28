package com.scaler.MovieBooking.exception;

public class EmailAlreadyExistException extends Exception {

    public EmailAlreadyExistException() {
    }

    public EmailAlreadyExistException(String message) {
        super(message);
    }
}
