package com.scaler.MovieBooking.service;

import com.scaler.MovieBooking.models.User;
import com.scaler.MovieBooking.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    public User createUser(String userName, String password){
        User user = new User(userName,password);
        return userRepository.save(user);
    }
}
