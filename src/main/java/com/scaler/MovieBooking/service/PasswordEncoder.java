package com.scaler.MovieBooking.service;

public interface PasswordEncoder {

    String encode(String password);
    boolean match(String plaintextPassword, String hashedPassword);
}
