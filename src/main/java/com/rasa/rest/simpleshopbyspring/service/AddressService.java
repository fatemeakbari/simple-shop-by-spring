package com.rasa.rest.simpleshopbyspring.service;

import com.rasa.rest.simpleshopbyspring.repository.AddressRepository;
import com.rasa.rest.simpleshopbyspring.repository.entity.Address;
import com.rasa.rest.simpleshopbyspring.repository.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public void save(Long customerId, String line)
    {
        Customer customer = new Customer(customerId);
        Address address = new Address(customer,line);
        addressRepository.save(address);
    }

    public Address findById(Long id)
    {
        return addressRepository.getOne(id);
    }
    public List<Address> findByCustomerId(Long customerId)
    {
        return addressRepository.findByCustomer_Id(customerId);
    }

    public void update(Long id, String line)
    {
        Address address = addressRepository.getOne(id);
        address.setLine(line);
        addressRepository.save(address);
    }

    public void deleteById(Long id)
    {
        addressRepository.deleteById(id);
    }
}
