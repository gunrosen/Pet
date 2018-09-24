package com.pet.todo.service.impl;

import com.pet.todo.domain.Employee;
import com.pet.todo.exception.ResourceNotFoundException;
import com.pet.todo.repository.EmployeeRepository;
import com.pet.todo.restful.dto.EmployeeDto;
import com.pet.todo.restful.dto.common.ListDto;

import com.pet.todo.service.EmployeeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Gun on 9/10/18.
 */
@Service
public class EmployeeServiceImpl extends AbstractService<EmployeeDto,Employee,Integer> implements EmployeeService {

    private static final Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    protected JpaRepository<Employee, Integer> getRepository() {
        return employeeRepository;
    }

    @Override
    protected EmployeeDto convertToDto(Employee domain) {
        return new EmployeeDto(domain);
    }

    @Override
    protected Employee convertToDomain(EmployeeDto employeeDto) {
        return employeeDto.toDomain();
    }

    @Override
    protected Integer getObjectId(EmployeeDto employeeDto) {
        return employeeDto.getEmployeeNumber();
    }

    @Override
    protected Integer getDomainId(Employee domain) {
        return domain.getEmployeeNumber();
    }

    @Override
    protected EmployeeDto emptyDTO() {
        return new EmployeeDto();
    }

}
