package com.pet.todo.service;

import com.pet.todo.restful.dto.common.ListDto;
import com.pet.todo.restful.dto.CustomerDto;

/**
 * Created by Gun on 9/4/18.
 */
public interface CustomerService extends BaseService<CustomerDto,Integer>{

    ListDto<CustomerDto> getCustomerManagedBy(int employeeId);

    ListDto<CustomerDto> getCustomerNotManaged();

    void updateEmployee(int customerId, int employeeId);

    void deleteCustomer(int customerId);


}
