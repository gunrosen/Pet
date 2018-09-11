package com.pet.todo.service.impl;

import com.pet.todo.domain.Employee;
import com.pet.todo.repository.EmployeeRepository;
import com.pet.todo.restful.dto.EmployeeDto;
import com.pet.todo.restful.dto.common.ListDto;
import com.pet.todo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Gun on 9/10/18.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee findEmployeeById(int id) {
        return null;
    }

    @Override
    public ListDto<EmployeeDto> getEmployee(int page, int size) {
        Page<Employee> pageEmployee = employeeRepository.findAll(new PageRequest(page,size));
        List<Employee> lst = pageEmployee.getContent();
        long totalElements = pageEmployee.getTotalElements();
        return null;
    }

    @Override
    public int createEmployee(EmployeeDto em) {
        return 0;
    }
}
