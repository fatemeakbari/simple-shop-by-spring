package com.rasa.rest.simpleshopbyspring.repository.entity;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "pay_type")
    private int payType;

    @OneToOne
    @JoinColumn(name = "delivery_address")
    private Address deliveryAddress;

    @Column(name = "delivery_time", nullable = true)
    private Date deliveryTime;

    @Column(name = "activated")
    private boolean activated;

    @ApiModelProperty(hidden = true)
    @Column(name = "create_date", updatable = false)
    private Date createDate;

    @ApiModelProperty(hidden = true)
    @Column(name = "update_date")
    private Date updateDate;

    @ManyToMany
    @JoinTable(name = "orders_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))

    private List<Product> productList;
    public Order() {
    }
    public Order(Long id)
    {
        this.id = id;
    }
    public Order(int payType, Date createDate)
    {
       this.payType = payType;
       this.createDate =createDate;
       this.updateDate = createDate;
    }

    public Order(Customer customer, Address deliveryAddress,int payType)
    {
        this.customer = customer;
        this.deliveryAddress = deliveryAddress;
        this.payType = payType;
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

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void setCreateUpdateDate(Date date)
    {
        this.createDate = date;
        this.updateDate = date;
    }
    @Override
    public String toString() {
        return "Order{" + "oid=" + id + ", payType=" + payType + ", deliveryAddress=" + deliveryAddress + ", deliveryTime=" + deliveryTime + ", activated=" + activated + ", createDate=" + createDate + ", updateDate=" + updateDate + '}';
    }
}
