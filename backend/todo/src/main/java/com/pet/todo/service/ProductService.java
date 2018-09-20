package com.pet.todo.service;

import com.pet.todo.domain.Product;
import com.pet.todo.restful.dto.ProductDto;
import com.pet.todo.restful.dto.common.ListDto;

/**
 * Created by Gun on 9/20/18.
 */
public interface ProductService {

    ListDto<ProductDto> getPagableProduct(int size, int page);

    ProductDto getProduct(String code);

    boolean createProduct(ProductDto product);

    boolean editProduct(ProductDto product);
}
