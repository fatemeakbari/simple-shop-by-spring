package com.rasa.rest.simpleshopbyspring.repository;

import com.rasa.rest.simpleshopbyspring.repository.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {


    public Customer findByEmail(String email);

}
