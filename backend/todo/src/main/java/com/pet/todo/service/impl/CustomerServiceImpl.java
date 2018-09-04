package com.pet.todo.service.impl;

import com.pet.todo.domain.Customer;
import com.pet.todo.exception.ResourceNotFoundException;
import com.pet.todo.repository.CustomerRepository;
import com.pet.todo.restful.dto.ListDto;
import com.pet.todo.restful.dto.customer.CustomerDto;
import com.pet.todo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Gun on 9/4/18.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public ListDto<CustomerDto> getCustomer(int page, int size) {
        Page<Customer> customerPage = customerRepository.findAll(new PageRequest(page,size) );
        List<CustomerDto> lstCustomer = customerPage.stream()
                .sorted(Comparator.comparing(Customer::getCustomerName))
                .map(customer -> {
                    CustomerDto item = new CustomerDto();
                    item.setCustomerNumber(customer.getCustomerNumber());
                    item.setAddress(customer.getAddressLine1());
                    item.setContactFirstName(customer.getContactFirstName());
                    item.setContactLastName(customer.getContactLastName());
                    item.setCustomerName(customer.getCustomerName());
                    item.setPhone(customer.getPhone());
                    item.setCity(customer.getCity());
                    item.setCountry(customer.getCountry());
                    return item;
                })
                .collect(Collectors.toList());

        return new ListDto<>(customerPage.getTotalElements(),lstCustomer);
    }

    @Override
    public int createCustomer(CustomerDto customer) {
        Customer _customer = new Customer(customer);
        Customer result = customerRepository.save(_customer);
        return result.getCustomerNumber();
    }

    @Override
    public int updateCustomer(CustomerDto customer) {
        int id = customer.getCustomerNumber();
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        optionalCustomer.orElseThrow(()-> new ResourceNotFoundException("Customer","","null"));
        Customer _customer = new Customer(customer);
        customerRepository.save(_customer);
        return id;
    }

    @Override
    public void updateEmployee(int customerId, int employeeId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        optionalCustomer.orElseThrow(()-> new ResourceNotFoundException("Customer","","null"));
        Customer _customer = optionalCustomer.get();
        _customer.setSalesRepEmployeeNumber(employeeId);
        customerRepository.save(_customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        optionalCustomer.orElseThrow(()-> new ResourceNotFoundException("Customer","","null"));
        customerRepository.deleteById(customerId);
    }


}
