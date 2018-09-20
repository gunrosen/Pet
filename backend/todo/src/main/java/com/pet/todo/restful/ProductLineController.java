package com.pet.todo.restful;

import com.pet.todo.restful.dto.ProductLineDto;
import com.pet.todo.restful.dto.common.ListDto;
import com.pet.todo.service.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Gun on 9/20/18.
 */
@RestController(value = "apiProductLine")
@RequestMapping(value = "/api/productline")
public class ProductLineController {

    @Autowired
    ProductLineService productLineService;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<?>  getAllProductLine(){
        ListDto<ProductLineDto> result = productLineService.getAll();
        return new Envelop(result).toResponseEntity();
    }

}
