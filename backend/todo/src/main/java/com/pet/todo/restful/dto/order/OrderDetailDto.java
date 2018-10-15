package com.pet.todo.restful.dto.order;

import com.pet.todo.domain.OrderDetail;
import com.pet.todo.domain.Product;
import com.pet.todo.restful.dto.ProductDto;
import com.pet.todo.restful.dto.common.AbstractDto;

import java.math.BigDecimal;

/**
 * Created by Gun on 10/11/18.
 */
public class OrderDetailDto implements AbstractDto<OrderDetail> {
    private int orderNumber;

    private ProductDto product;

    private int quantityOrdered;

    private BigDecimal priceEach;

    private int orderLineNumber;

    public OrderDetailDto(OrderDetail domain){
        this.orderNumber = domain.getOrderNumber();
        this.orderLineNumber = domain.getOrderLineNumber();
        this.product = new ProductDto(domain.getProduct());
        this.quantityOrdered = domain.getQuantityOrdered();
        this.priceEach = domain.getPriceEach();
    }

    @Override
    public OrderDetail toDomain() {
        return null;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
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
