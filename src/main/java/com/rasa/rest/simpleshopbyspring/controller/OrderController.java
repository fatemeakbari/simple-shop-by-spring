package com.rasa.rest.simpleshopbyspring.controller;

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
    public void save(@RequestParam Long customerId,@RequestBody Order order)
    {
        order.setCustomer(new Customer(customerId));
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

//    @GetMapping("orders/{id}/products")
//    public Order findByIdAndFindProduct(@PathVariable Long id)
//    {
//        return orderService.findByIdAndFindProduct(id);
//    }
    @GetMapping("/orders")
    public List<Order> findAll()
    {
        return orderService.findAll();
    }

    @PutMapping("/orders/{id}")
    public void update(@PathVariable Long id, @RequestParam Long customerId,@RequestBody Order order)
    {
        order.setId(id);
        order.setCustomer(new Customer(customerId));
        orderService.update(order);
    }
    @PutMapping("/orders/{id}/products/{productId}")
    public void addProduct(@PathVariable Long id, @PathVariable Long productId)
    {
        orderService.addProduct(id,productId);
    }

    @DeleteMapping("/orders/{id}")
    public void deleteById(@PathVariable Long id)
    {
        orderService.deleteById(id);
    }
    @PostMapping("/orders/{id}/products")
    public void deleteProductFromOrder(@PathVariable Long id, @RequestParam Long productId)
    {
        orderService.deleteProductFromOrder(id,productId);
    }
}
