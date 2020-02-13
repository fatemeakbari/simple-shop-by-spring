package com.rasa.rest.simpleshopbyspring.repository;

import com.rasa.rest.simpleshopbyspring.repository.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    public List<Order> findByCustomer_Id(Long customerId);
}
