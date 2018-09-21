package com.pet.todo.restful.dto;

import com.pet.todo.domain.Customer;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Gun on 9/4/18.
 */
public class CustomerDto implements Serializable{

    private Integer customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String address;
    private String city;
    private String country;
    private BigDecimal creditLimit;

    public CustomerDto(){}

    public CustomerDto(Customer c ){
        this.customerNumber = c.getCustomerNumber();
        this.customerName = c.getCustomerName();
        this.contactFirstName = c.getContactFirstName();
        this.contactLastName = c.getContactLastName();
        this.phone = c.getPhone();
        this.address = c.getAddressLine1();
        this.city = c.getCity();
        this.country = c.getCountry();
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }


}
