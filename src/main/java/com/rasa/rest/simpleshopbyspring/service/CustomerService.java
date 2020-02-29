package com.rasa.rest.simpleshopbyspring.service;

import com.rasa.rest.simpleshopbyspring.EntityNotFoundException;
import com.rasa.rest.simpleshopbyspring.exceptionHandler.DuplicateException;
import com.rasa.rest.simpleshopbyspring.repository.CustomerRepository;
import com.rasa.rest.simpleshopbyspring.repository.entity.Customer;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



import java.util.Date;
import java.util.List;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public Date getDate(){ return new java.sql.Timestamp(new java.util.Date().getTime());}

    public void save(Customer customer) throws Exception
    {
        customer.setCreateUpdate(getDate());
       try{
            customerRepository.save(customer);
        }
        catch( DataIntegrityViolationException e ) {
            if(e.getMessage().contains("unique_email_address"))
            {
                throw new DuplicateException("this email address alredy exists: "+customer.getEmail()) ;
            }
            if(e.getMessage().contains("unique_phone_number"))
            {
                throw new DuplicateException("this phone number alredy exists: "+customer.getPhoneNumber().toString());
            }
        }

    }

    public Customer findById(Long id)
    {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null)
        {
            throw new EntityNotFoundException(Customer.class, "id", id.toString());
        }
        return customer;

    }
    public Customer findByEmail(String email)
    {
        return customerRepository.findByEmail(email);
    }

    public Page<Customer> findByName(Pageable pageable, String name)
    {
        return customerRepository.findByName(pageable,name);
    }
    public List<Customer> findAll()
    {
        return (List<Customer>) customerRepository.findAll();
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
