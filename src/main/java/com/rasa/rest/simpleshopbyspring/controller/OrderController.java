package com.rasa.rest.simpleshopbyspring.controller;

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
    public void save(@RequestBody Order order)
    {
        orderService.save(order);
    }
    @GetMapping("/orders/{id}")
    public Order findById(@PathVariable Long id)
    {
        return orderService.findById(id);
    }

    @GetMapping("/orders/customer/{customerId}")
    public List<Order> findByCustomerId(@PathVariable Long customerId)
    {
        return orderService.findByCustomerId(customerId);
    }

    @GetMapping("/orders")
    public List<Order> findAll()
    {
        return orderService.findAll();
    }

    @PutMapping("/orders/{id}")
    public void update(@PathVariable Long id,@RequestBody Order order)
    {
        order.setId(id);
        orderService.update(order);
    }
}
