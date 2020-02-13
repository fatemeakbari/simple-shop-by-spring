package com.rasa.rest.simpleshopbyspring.controller;

import com.rasa.rest.simpleshopbyspring.repository.entity.Address;
import com.rasa.rest.simpleshopbyspring.repository.entity.Customer;
import com.rasa.rest.simpleshopbyspring.repository.entity.Order;
import com.rasa.rest.simpleshopbyspring.service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Order Api")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/orders")
    public void save(@RequestParam Long customerId, @RequestParam Long addressId, @RequestParam int payType)
    {
        orderService.save(customerId,addressId,payType);
    }
    @GetMapping("/orders/{id}")
    public void findById(@PathVariable Long id)
    {
        orderService.findById(id);
    }

    @GetMapping("/orders/customer/{customerId}")
    public List<Order> findByCustomerId(@PathVariable Long customerId)
    {
        return orderService.findByCustomerId(customerId);
    }

    @PutMapping("/orders/{id}")
    public void update(@RequestBody Order order)
    {
        orderService.update(order);
    }
}
