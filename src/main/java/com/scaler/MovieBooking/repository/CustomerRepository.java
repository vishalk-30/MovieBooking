package com.scaler.MovieBooking.repository;

import com.scaler.MovieBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Optional<Customer> findCustomerByEmail(String email);
}
