package com.pet.todo.restful.dto;

import com.pet.todo.domain.ProductLine;

import java.io.Serializable;

/**
 * Created by Gun on 9/20/18.
 */
public class ProductLineDto implements Serializable {

    private String productLine;

    private String textDescription;

    public ProductLineDto(){}

    public ProductLineDto(ProductLine domain){
        this.productLine = domain.getProductLine();
        this.textDescription = domain.getTextDescription();
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }
}
