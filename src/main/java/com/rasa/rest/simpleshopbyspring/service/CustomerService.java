package com.rasa.rest.simpleshopbyspring.service;

import com.rasa.rest.simpleshopbyspring.repository.CustomerRepository;
import com.rasa.rest.simpleshopbyspring.repository.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressService addressService;

    public Date getDate(){ return new java.sql.Timestamp(new java.util.Date().getTime());}

    public void save(Customer customer)
    {
        customer.setCreateDate(getDate());
        customer.setUpdateDate(getDate());
        customerRepository.save(customer);
    }

    public void addAddress(Long id,String line)
    {
        addressService.save(id,line);
    }

    public void addOrder(Long id,Long addressId, Integer payType)
    {
        OrderService orderService = new OrderService();
       // orderService.save(id,addressId,payType);
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
    public void deleteAddress(Long addressId)
    {
        addressService.deleteById(addressId);
    }
}
