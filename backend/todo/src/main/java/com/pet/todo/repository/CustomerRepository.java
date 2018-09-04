package com.pet.todo.repository;

import com.pet.todo.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Gun on 9/4/18.
 */
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
