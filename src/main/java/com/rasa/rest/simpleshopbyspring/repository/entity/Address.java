package com.rasa.rest.simpleshopbyspring.repository.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "line")
    private String line;

    public Address() {
    }
    public Address(Long id) { this.id = id; }
    public Address( Customer customer,String line)
    {
        this.customer = customer;
        this.line = line;

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", customer=" + customer.getId() + ", line='" + line + '\'' + '}';
    }
}
