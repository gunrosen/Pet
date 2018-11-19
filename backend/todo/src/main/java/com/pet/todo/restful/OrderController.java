package com.pet.todo.restful;

import com.pet.todo.restful.dto.common.ListDto;
import com.pet.todo.restful.dto.order.OrderDto;
import com.pet.todo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Gun on 10/9/18.
 */
@RestController(value = "orderController")
@RequestMapping(value = "/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/by-customer/{id}",method = RequestMethod.GET)
    ResponseEntity<?> getListOrderByCustomer(@PathVariable int id){
        ListDto<?> result = orderService.getListOrderByCustomer(id);
        return new Envelop(result).toResponseEntity();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    ResponseEntity<?> getOrderDetail(@PathVariable int id){
        OrderDto dto = orderService.getOrderInfo(id);
        return new Envelop(dto).toResponseEntity();
    }

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<?> getAllPagable(@RequestParam int page,@RequestParam int size){
        ListDto<?> result = orderService.getList(PageRequest.of(page, size));
        return  new Envelop(result).toResponseEntity();
    }
}
