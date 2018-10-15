package com.pet.todo.restful.dto.order;

import com.pet.todo.restful.dto.CustomerDto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Gun on 10/11/18.
 */
public class OrderDto implements Serializable {
    private int orderNumber;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private String status;
    private String comments;
    private int customerNumber;

    private CustomerDto customer;
    private OrderDetailDto[] items;

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public void setItems(OrderDetailDto[] items) {
        this.items = items;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public String getStatus() {
        return status;
    }

    public String getComments() {
        return comments;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public OrderDetailDto[] getItems() {
        return items;
    }
}
