package com.pet.todo.service.impl;

import com.pet.todo.restful.dto.ProductDto;
import com.pet.todo.restful.dto.common.ListDto;
import com.pet.todo.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * Created by Gun on 9/20/18.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public ListDto<ProductDto> getPagableProduct(int size, int page) {
        return null;
    }

    @Override
    public ProductDto getProduct(String code) {
        return null;
    }

    @Override
    public boolean createProduct(ProductDto product) {
        return false;
    }

    @Override
    public boolean editProduct(ProductDto product) {
        return false;
    }
}
