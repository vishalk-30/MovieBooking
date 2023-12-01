package com.scaler.MovieBooking.controller;

import com.scaler.MovieBooking.dto.CreateCustomerDTO;
import com.scaler.MovieBooking.exception.CustomerNotFoundException;

import com.scaler.MovieBooking.exception.EmailAlreadyExistException;
import com.scaler.MovieBooking.exception.InvalidCustomerException;
import com.scaler.MovieBooking.models.Customer;
import com.scaler.MovieBooking.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor

public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable int id) throws CustomerNotFoundException {
        return  customerService.getCustomer(id);

    }

    @PostMapping
    public Customer createCustomer(@RequestBody CreateCustomerDTO request) throws InvalidCustomerException, EmailAlreadyExistException {
        validate(request);

        return customerService.createCustomer(request);

    }
    private void validate(CreateCustomerDTO request) throws InvalidCustomerException {

        if (request.getEmail() == null){
            throw new InvalidCustomerException("Email is mandatory");
        }
    }

}
