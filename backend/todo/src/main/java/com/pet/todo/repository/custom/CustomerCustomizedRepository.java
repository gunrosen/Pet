package com.pet.todo.repository.custom;

import com.pet.todo.domain.Customer;

import java.util.List;

/**
 * Created by Gun on 9/5/18.
 */
public interface CustomerCustomizedRepository {
    List<Customer> getCustomerManagedBy(int employeeId);
}
