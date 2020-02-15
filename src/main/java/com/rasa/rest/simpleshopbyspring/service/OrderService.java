package com.rasa.rest.simpleshopbyspring.service;

import com.rasa.rest.simpleshopbyspring.repository.OrderRepository;
import com.rasa.rest.simpleshopbyspring.repository.entity.Address;
import com.rasa.rest.simpleshopbyspring.repository.entity.Customer;
import com.rasa.rest.simpleshopbyspring.repository.entity.Order;
import com.rasa.rest.simpleshopbyspring.repository.entity.Product;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;
    public Date getDate(){ return new java.sql.Timestamp(new java.util.Date().getTime());}

    public void save(Order order)
    {
        order.setCreateUpdateDate(getDate());
        orderRepository.save(order);
    }

    public void addProduct(Long id, Long productId)
    {
        Order order = this.findById(id);
        Product product = productService.findById(productId);
        order.getProductList().add(product);
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

    public Order findByIdAndFindProduct(Long id)
    {
        Order order = this.findById(id);
        order.getProductList();
        return order;
    }
    public List<Order> findAll()
    {
        return orderRepository.findAll();
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

    public void deleteProductFromOrder(Long id,Long productId)
    {
        Order order = this.findById(id);
        List<Product> productList = order.getProductList();
        int index = -1;
        for(int i=0;i<productList.size();i++)
        {
            if(productList.get(i).getId() == productId)
            {
                index = i;
                break;
            }
        }
        if(index > -1)
        {
            productList.remove(index);
            orderRepository.save(order);
        }
    }


}
