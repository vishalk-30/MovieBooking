package com.scaler.MovieBooking.service;

import com.scaler.MovieBooking.dto.CreateCustomerDTO;
import com.scaler.MovieBooking.dto.GetCustomerDTO;
import com.scaler.MovieBooking.exception.CustomerNotFoundException;

import com.scaler.MovieBooking.exception.EmailAlreadyExistException;
import com.scaler.MovieBooking.models.Customer;
import com.scaler.MovieBooking.models.User;
import com.scaler.MovieBooking.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;
    private UserService userService;
    public Customer getCustomer(int id) throws CustomerNotFoundException {

        return customerRepository
                .findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found for id:" + id));
    }


    public Customer createCustomer(CreateCustomerDTO request) throws EmailAlreadyExistException {

        // check email for duplication
        String email = request.getEmail();

        Optional<Customer> existingCustomer = customerRepository.findCustomerByEmail(email);

        if(existingCustomer.isPresent()){
            throw new EmailAlreadyExistException("Customer Email is already exist " + email);
        }
        // create user and save the user

        User user = userService.createUser(request.getUserName(), request.getPassword());

        // create customer and save
        Customer customer = Customer.builder()
                .city(request.getCity())
                .phoneNumber(request.getPhoneNumber())
                .fullName(request.getFullName())
                .email(request.getEmail())
                .user(user)
                .build();

        return customerRepository.save(customer);

    }
}
