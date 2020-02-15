package com.rasa.rest.simpleshopbyspring.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.xml.internal.ws.developer.Serialization;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
//https://stackoverflow.com/questions/35155916/handling-ambiguous-handler-methods-mapped-in-rest-application-with-spring
@Entity
@Table(name = "customer")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "phone_number",unique = true, nullable = false)
    private Long phoneNumber;

    @ApiModelProperty(hidden = true)
    @Column(name = "create_date", updatable = false)
    private Date createDate;

    @ApiModelProperty(hidden = true)
    @Column(name = "update_date", nullable = false)
    private Date updateDate;


    @Transient
    @ApiModelProperty(hidden = true)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    List<Address> addressList;

    @Transient
    @ApiModelProperty(hidden = true)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    List<Order> orderList;


    public Customer() {
    }

    public Customer(Long id) {
        this.id = id;
    }
    public Customer(String username, String password, String email, Long phoneNumber) {
        this.name = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String username, String password, String email, Long phoneNumber, Date createDate) {
        this.name = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createDate = createDate;
        this.updateDate = createDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @ApiModelProperty(hidden = true)
    public void setCreateUpdate(Date date)
    {
        this.createDate = date;
        this.updateDate = date;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password +
                '\'' + ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate + '}';
    }
}
