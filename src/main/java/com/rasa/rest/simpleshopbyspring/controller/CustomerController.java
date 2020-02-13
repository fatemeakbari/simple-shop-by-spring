package com.rasa.rest.simpleshopbyspring.controller;

import com.rasa.rest.simpleshopbyspring.repository.entity.Customer;
import com.rasa.rest.simpleshopbyspring.service.AddressService;
import com.rasa.rest.simpleshopbyspring.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.models.Response;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Customer Api")
@RestController
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @PostMapping("/customers")
    public void save(@RequestBody Customer customer)
    {
        customerService.save(customer);
    }

    @PostMapping("/customers/{id}/addresses")
    public void addAddress(@PathVariable Long id,@RequestParam String line)
    {
        customerService.addAddress(id,line);
    }

    @GetMapping("/customers/{id}")
    public Customer findById(@PathVariable Long id)
    {
        return customerService.findById(id);
    }

    @GetMapping("/customers/email/{email}")
    public Customer findByEmail(@PathVariable String email)
    {
        return customerService.findByEmail(email);
    }

    @GetMapping("/customers")
    public List<Customer> findAll()
    {
        return customerService.findAll();
    }


    @GetMapping("/customer/{id}/addresses")
    public Customer getAddressesByCustomerId(@PathVariable Long id)
    {
        Customer customer = customerService.findById(id);
        customer.setAddressList(addressService.findByCustomerId(customer.getId()));
        return customer;
    }

    @PutMapping("/customers/{id}")
    public void update(@PathVariable Long id, @RequestBody Customer customer)
    {
        customer.setId(id);
        customerService.update(customer);
    }


    @DeleteMapping("/customers/{id}")
    public void delete(@PathVariable Long id)
    {
        customerService.deleteById(id);
    }

    @DeleteMapping("/customers/{id}/addresses/{addressId}")
     public void deleteAddress(@PathVariable Long id,@PathVariable Long addressId)
    {
        customerService.deleteAddress(addressId);
    }


}
