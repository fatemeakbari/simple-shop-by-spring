package com.rasa.rest.simpleshopbyspring.repository.entity;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "category")
    private int category;

    @Column(name = "available_number")
    private int availableNumber;

    @ApiModelProperty(hidden = true)
    @Column(name = "create_date", updatable = false)
    private Date createDate;

    @ApiModelProperty(hidden = true)
    @Column(name = "update_date")
    private Date updateDate;


    @ManyToMany(mappedBy = "productList")
    private List<Order> orderList = new ArrayList<>();


    public Product() {
    }
    public Product(Long id) {
        this.id = id;
    }
    public Product(String name,int price, int category, int availableNumber) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.availableNumber = availableNumber;
    }

    public Product(String name,int price, int category, int availableNumber,Date createDate) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.availableNumber = availableNumber;
        this.createDate = createDate;
        this.updateDate = createDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCategory(int category) {
        this.category = category;
    }
    public void setAvailableNumber(int availableNumber) {
        this.availableNumber = availableNumber;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAvailableNumber() {
        return availableNumber;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public int getPrice() {
        return price;
    }

    public int getCategory() {
        return category;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }


    @Override
    public String toString() {
        return "Product{" +
                "pid=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", availableNumber=" + availableNumber +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
