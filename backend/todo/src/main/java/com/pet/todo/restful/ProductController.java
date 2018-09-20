package com.pet.todo.restful;

import com.pet.todo.restful.dto.ProductDto;
import com.pet.todo.restful.dto.common.ListDto;
import com.pet.todo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Gun on 9/20/18.
 */
@RestController(value = "apiProduct")
@RequestMapping(value = "/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<?> getProduct(@RequestParam int page, @RequestParam int size){
        ListDto<ProductDto> lst = productService.getPagableProduct(size,page);
        return new Envelop(lst).toResponseEntity();
    }
}
