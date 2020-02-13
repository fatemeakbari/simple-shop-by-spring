package com.rasa.rest.simpleshopbyspring.service;

import com.rasa.rest.simpleshopbyspring.repository.OrderRepository;
import com.rasa.rest.simpleshopbyspring.repository.entity.Address;
import com.rasa.rest.simpleshopbyspring.repository.entity.Customer;
import com.rasa.rest.simpleshopbyspring.repository.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Date getDate(){ return new java.sql.Timestamp(new java.util.Date().getTime());}

    public void save(Long customerId, Long addressId,int payType)
    {
        Customer customer = new Customer(customerId);
        Address address = new Address(addressId);
        Order order= new Order(customer,address,payType);
        order.setCreateUpdateDate(getDate());
        orderRepository.save(order);
    }

    public Order findById(Long id)
    {
        return orderRepository.getOne(id);
    }

    public List<Order> findByCustomerId(Long customerId)
    {
        return orderRepository.findByCustomer_Id(customerId);
    }

    public void update(Order order)
    {
        order.setUpdateDate(getDate());
        orderRepository.save(order);
    }

    public void deleteById(Long id)
    {
        orderRepository.deleteById(id);
    }
}
