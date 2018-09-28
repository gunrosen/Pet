package com.pet.todo.restful;

import com.pet.todo.restful.dto.common.ListDto;
import com.pet.todo.restful.dto.CustomerDto;
import com.pet.todo.service.CustomerService;
import com.pet.todo.support.annotation.VersionApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Gun on 9/4/18.
 */
@RestController(value = "apiCustomer")
@RequestMapping(value = "/api/customer")
public class CustomerController {

    @Autowired
    @VersionApi(value = VersionApi.V.VER_1)
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET , value = "/{id}")
    ResponseEntity<?> getCustomerById(@PathVariable int id){
        CustomerDto dto = customerService.findById(id);
        return new Envelop(dto).toResponseEntity();
    }

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<?> getCustomer(@RequestParam int page, @RequestParam int size) {
        ListDto<CustomerDto> dtos = customerService.getList(PageRequest.of(page, size));
        return new Envelop(dtos).toResponseEntity();
    }


    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> createCustomer(@RequestBody CustomerDto customer) {
        int id = customerService.create(customer);
        return new Envelop(id).toResponseEntity();
    }

    @RequestMapping(method = RequestMethod.PUT)
    ResponseEntity<?> updateCustomer(@RequestBody CustomerDto customerDto) {
        int idUpdate = customerService.update(customerDto);
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

    @RequestMapping(value = "/not-managed/", method = RequestMethod.GET)
    ResponseEntity<?> getCustomerManageBy(){
        ListDto<CustomerDto> dtos = customerService.getCustomerNotManaged();
        return new Envelop(dtos).toResponseEntity();
    }
}
