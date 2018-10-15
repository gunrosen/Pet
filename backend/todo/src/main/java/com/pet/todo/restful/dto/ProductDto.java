package com.pet.todo.restful.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pet.todo.domain.Product;
import com.pet.todo.domain.ProductLine;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Gun on 9/20/18.
 */
public class ProductDto implements Serializable {
    public ProductDto(){}

    public ProductDto(Product domain){
        this.productCode = domain.getProductCode();
        this.productName = domain.getProductName();
        this.productDescription = domain.getProductDescription();
        this.productLine = new ProductLineDto(domain.getProductLine());
        this.buyPrice = domain.getBuyPrice();
        this.productScale = domain.getProductScale();
        this.productVendor = domain.getProductVendor();
        this.quantityInStock = domain.getQuantityInStock();
        this.MSRP = domain.getMSRP();
    }
    private String productCode;

    private String productName;

    private ProductLineDto productLine;

    private String productScale;

    private String productVendor;

    private String productDescription;

    private int quantityInStock;

    private BigDecimal buyPrice;

    private BigDecimal MSRP;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductLineDto getProductLine() {
        return productLine;
    }

    public void setProductLine(ProductLineDto productLine) {
        this.productLine = productLine;
    }

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getMSRP() {
        return MSRP;
    }

    public void setMSRP(BigDecimal MSRP) {
        this.MSRP = MSRP;
    }
}
