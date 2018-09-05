package com.pet.todo.restful;

import com.pet.todo.restful.dto.ListDto;
import com.pet.todo.restful.dto.customer.CustomerDto;
import com.pet.todo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Gun on 9/4/18.
 */
@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<?> getCustomer(@RequestParam int page, @RequestParam int size) {
        ListDto<CustomerDto> dtos = customerService.getCustomer(page, size);
        return new Envelop(dtos).toResponseEntity();
    }


    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> createCustomer(@RequestBody CustomerDto customer) {
        int id = customerService.createCustomer(customer);
        return new Envelop(id).toResponseEntity();
    }

    @RequestMapping(value = "/{id}/update",method = RequestMethod.PUT)
    ResponseEntity<?> updateCustomer(@PathVariable int id , @RequestBody CustomerDto customerDto) {
        int idUpdate = customerService.updateCustomer(id,customerDto);
        return new Envelop(idUpdate).toResponseEntity();
    }

    @RequestMapping(value = "{id}/employee",method = RequestMethod.PUT)
    ResponseEntity<?> updateEmployeeOfCustomer(@PathVariable int id, @RequestParam int employeeId) {
        customerService.updateEmployee(id, employeeId);
        return new Envelop(null).toResponseEntity();
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.PUT)
    ResponseEntity<?> deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return new Envelop(id).toResponseEntity();
    }

    @RequestMapping(value = "/managed-by/{id}", method = RequestMethod.GET)
    ResponseEntity<?> getCustomerManageBy(@PathVariable int id){
        ListDto<CustomerDto> dtos = customerService.getCustomerManagedBy(id);
        return new Envelop(dtos).toResponseEntity();
    }
}
