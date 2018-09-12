package com.pet.todo.service;

import com.pet.todo.domain.Employee;
import com.pet.todo.restful.dto.EmployeeDto;
import com.pet.todo.restful.dto.common.ListDto;

/**
 * Created by Gun on 9/5/18.
 */
public interface EmployeeService {

    Employee findEmployeeById(int id);

    ListDto<EmployeeDto> getEmployee(int page, int size);

    int createEmployee(EmployeeDto em);

    int updateEmployee(EmployeeDto em);
}
