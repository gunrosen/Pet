package com.pet.todo.service;

import com.pet.todo.restful.dto.ProductLineDto;
import com.pet.todo.restful.dto.common.ListDto;

/**
 * Created by Gun on 9/20/18.
 */
public interface ProductLineService {
    ListDto<ProductLineDto> getAll();
}
