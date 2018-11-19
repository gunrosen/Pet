package com.pet.todo.service.impl;

import com.pet.todo.domain.Customer;
import com.pet.todo.domain.Employee;
import com.pet.todo.exception.ResourceNotFoundException;
import com.pet.todo.repository.CustomerRepository;
import com.pet.todo.repository.EmployeeRepository;
import com.pet.todo.restful.dto.common.ListDto;
import com.pet.todo.restful.dto.CustomerDto;
import com.pet.todo.service.CustomerService;
import com.pet.todo.support.annotation.VersionApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Gun on 9/4/18.
 */
@Service(value = "customerService1" )
@VersionApi(value = VersionApi.V.VER_1)
public class CustomerServiceImpl extends AbstractService<CustomerDto, Customer, Integer> implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public ListDto<CustomerDto> getCustomerManagedBy(int employeeId) {
        List<Customer> lst = customerRepository.getCustomerManagedBy(employeeId);
        List<CustomerDto> lstDto = new ArrayList<>(lst.size());
        for (Customer c : lst) {
            lstDto.add(new CustomerDto(c));
        }
        // Java 8
        List<CustomerDto> lstDto8 = lst.stream().map(customer -> {
            return new CustomerDto(customer);
        }).collect(Collectors.toList());
        int odd = 1;
        return new ListDto<>(lstDto);
    }

    @Override
    public ListDto<CustomerDto> getCustomerNotManaged() {
        List<Customer> lst = customerRepository.getCustomerNotManaged();
//         Java 8
        List<CustomerDto> lstDto8 = lst.stream().map(customer -> {
            return new CustomerDto(customer);
        }).collect(Collectors.toList());
        return new ListDto<>(lstDto8);
    }


    @Override
    public void updateEmployee(int customerId, int employeeId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        optionalCustomer.orElseThrow(() -> new ResourceNotFoundException("Customer", "", "null"));
        Customer _customer = optionalCustomer.get();

        Optional<Employee> opEmployee = employeeRepository.findById(Integer.valueOf(employeeId));
        opEmployee.ifPresent((em) -> {
            _customer.setEmployee(em);
            customerRepository.save(_customer);
        });

    }

    @Override
    public void deleteCustomer(int customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        optionalCustomer.orElseThrow(() -> new ResourceNotFoundException("Customer", "", "null"));
        customerRepository.deleteById(customerId);
    }


    @Override
    protected JpaRepository<Customer, Integer> getRepository() {
        return customerRepository;
    }

    @Override
    protected CustomerDto convertToDto(Customer domain) {
        CustomerDto item = new CustomerDto();
        item.setCustomerNumber(domain.getCustomerNumber());
        item.setAddress(domain.getAddressLine1());
        item.setContactFirstName(domain.getContactFirstName());
        item.setContactLastName(domain.getContactLastName());
        item.setCustomerName(domain.getCustomerName());
        item.setPhone(domain.getPhone());
        item.setCity(domain.getCity());
        item.setCountry(domain.getCountry());
        return item;
    }

    @Override
    protected Customer convertToDomain(CustomerDto dto) {
        Customer domain = new Customer();
        domain.setCustomerNumber(dto.getCustomerNumber());
        domain.setAddressLine1(dto.getAddress());
        domain.setContactFirstName(dto.getContactFirstName());
        domain.setContactLastName(dto.getContactLastName());
        domain.setCustomerName(dto.getCustomerName());
        domain.setPhone(dto.getPhone());
        domain.setCity(dto.getCity());
        domain.setCountry(dto.getCountry());
        return domain;
    }

    @Override
    protected Integer getObjectId(CustomerDto customerDto) {
        return customerDto.getCustomerNumber();
    }

    @Override
    protected Integer getDomainId(Customer domain) {
        return domain.getCustomerNumber();
    }

    @Override
    protected CustomerDto emptyDTO() {
        return new CustomerDto();
    }
}
