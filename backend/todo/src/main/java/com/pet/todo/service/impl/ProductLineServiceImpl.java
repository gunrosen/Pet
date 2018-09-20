package com.pet.todo.service.impl;

import com.pet.todo.domain.ProductLine;
import com.pet.todo.repository.ProductLineRepository;
import com.pet.todo.restful.dto.ProductLineDto;
import com.pet.todo.restful.dto.common.ListDto;
import com.pet.todo.service.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Gun on 9/20/18.
 */
@Service
public class ProductLineServiceImpl implements ProductLineService{

    @Autowired
    ProductLineRepository productLineRepository;

    @Override
    public ListDto<ProductLineDto> getAll() {
        List<ProductLine> lst = productLineRepository.findAll();
        List<ProductLineDto> lstDto =  lst.stream().map(productLine -> new ProductLineDto(productLine)).collect(Collectors.toList());
        return new ListDto<>(lstDto);
    }
}
