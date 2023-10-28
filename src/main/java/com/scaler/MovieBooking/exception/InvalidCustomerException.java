package com.scaler.MovieBooking.exception;

public class InvalidCustomerException extends Exception {
    public InvalidCustomerException() {
    }

    public InvalidCustomerException(String message) {
        super(message);
    }
}
