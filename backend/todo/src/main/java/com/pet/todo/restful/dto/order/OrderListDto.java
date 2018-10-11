package com.pet.todo.restful.dto.order;

import com.pet.todo.domain.Order;
import com.pet.todo.restful.dto.common.AbstractDto;

import java.util.Date;


/**
 * Created by Gun on 10/9/18.
 */
public class OrderListDto implements AbstractDto<Order>  {

    private int orderNumber;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private String status;
    private String comments;
    private int customerNumber;

    public OrderListDto(){}

    public OrderListDto(Order _domain){
        this.orderNumber = _domain.getOrderNumber();
        this.orderDate = _domain.getOrderDate();
        this.requiredDate = _domain.getRequiredDate();
        this.shippedDate = _domain.getShippedDate();
        this.status = _domain.getStatus();
        this.comments = _domain.getComments();
        this.customerNumber = _domain.getCustomerNumber();
    }

    @Override
    public Order toDomain() {
        Order _domain = new Order();
        _domain.setComments(this.comments);
        _domain.setOrderDate(this.orderDate);
        _domain.setRequiredDate(this.requiredDate);
        _domain.setShippedDate(this.shippedDate);
        _domain.setStatus(this.status);
        _domain.setCustomerNumber(this.customerNumber);
        return _domain;
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
}
