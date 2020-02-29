package com.rasa.rest.simpleshopbyspring.repository;

import com.rasa.rest.simpleshopbyspring.repository.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {

    public Customer findByEmail(String email);
    public Page<Customer> findByName(Pageable pageable, String name);


}
