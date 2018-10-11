package com.pet.todo.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Gun on 8/31/18.
 */
@Entity
@Table(name = "orderdetails")
public class OrderDetail extends Domain{

    @Column(name = "orderNumber")
    private int orderNumber;

    @Column(name = "productCode")
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productCode", referencedColumnName = "productCode")
    private Product product;

    @Column(name = "quantityOrdered")
    private int quantityOrdered;

    @Column(name = "priceEach")
    private BigDecimal priceEach;

    @Column(name = "orderLineNumber")
    private int orderLineNumber;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(BigDecimal priceEach) {
        this.priceEach = priceEach;
    }

    public int getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(int orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }
}
