package com.pet.todo.repository;

import com.pet.todo.domain.Customer;
import com.pet.todo.repository.custom.CustomerCustomizedRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Using @Query
 * Created by Gun on 9/4/18.
 */

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "select * from customers where salesRepEmployeeNumber = ?1",nativeQuery = true)
    List<Customer> getCustomerManagedBy(int employeeId);

    @Query(value = "select * from customers where salesRepEmployeeNumber is null",nativeQuery = true)
    List<Customer> getCustomerNotManaged();


}

