package com.scaler.MovieBooking.service;

import com.scaler.MovieBooking.models.User;
import com.scaler.MovieBooking.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private BcryptEncoder bcryptEncoder;
    public User createUser(String userName, String password){
        String hashedPassword = bcryptEncoder.encode(password);
        User user = new User(userName,hashedPassword);
        return userRepository.save(user);
    }
}
