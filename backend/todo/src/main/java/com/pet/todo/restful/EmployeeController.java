package com.pet.todo.restful;

import com.pet.todo.restful.dto.CustomerDto;
import com.pet.todo.restful.dto.EmployeeDto;
import com.pet.todo.restful.dto.common.ListDto;
import com.pet.todo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Gun on 9/10/18.
 */
@RestController(value = "apiEmployee")
@RequestMapping(value = "/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<?> getEmployee(@RequestParam int page, @RequestParam int size) {
        ListDto<EmployeeDto> dtos = employeeService.getList(PageRequest.of(page, size));
        return new Envelop(dtos).toResponseEntity();
    }


    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> createEmployee(@RequestBody EmployeeDto em) {
        int id = employeeService.create(em);
        return new Envelop(id).toResponseEntity();
    }

    @RequestMapping(method = RequestMethod.PUT)
    ResponseEntity<?> updateEmployee(@RequestBody EmployeeDto em) {
        int id = employeeService.update(em);
        return new Envelop(id).toResponseEntity();
    }


}
