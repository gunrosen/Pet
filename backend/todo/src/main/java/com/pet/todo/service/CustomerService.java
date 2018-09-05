package com.pet.todo.service;

import com.pet.todo.restful.dto.ListDto;
import com.pet.todo.restful.dto.customer.CustomerDto;

/**
 * Created by Gun on 9/4/18.
 */
public interface CustomerService {

    ListDto<CustomerDto> getCustomer(int page, int size);

    ListDto<CustomerDto> getCustomerManagedBy(int employeeId);

    int createCustomer(CustomerDto customer);

    int updateCustomer(int customerId, CustomerDto customer);

    void updateEmployee(int customerId, int employeeId);

    void deleteCustomer(int customerId);


}
