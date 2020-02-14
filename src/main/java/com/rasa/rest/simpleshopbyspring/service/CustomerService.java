package com.rasa.rest.simpleshopbyspring.service;

import com.rasa.rest.simpleshopbyspring.repository.CustomerRepository;
import com.rasa.rest.simpleshopbyspring.repository.entity.Customer;
import com.rasa.rest.simpleshopbyspring.repository.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public Date getDate(){ return new java.sql.Timestamp(new java.util.Date().getTime());}

    public void save(Customer customer)
    {
        customer.setCreateUpdate(getDate());
        customerRepository.save(customer);
    }

    public Customer findById(Long id)
    {
        return customerRepository.getOne(id);
    }
    public Customer findByEmail(String email)
    {
        return customerRepository.findByEmail(email);
    }
    public List<Customer> findAll()
    {
        return customerRepository.findAll();
    }

    public void update(Customer customer)
    {
        customer.setUpdateDate(getDate());
        customerRepository.save(customer);
    }

    public void deleteById(Long id)
    {
        customerRepository.deleteById(id);
    }

}
