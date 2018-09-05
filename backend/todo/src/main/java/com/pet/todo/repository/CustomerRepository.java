package com.pet.todo.repository;

import com.pet.todo.domain.Customer;
import com.pet.todo.repository.custom.CustomerCustomizedRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Gun on 9/4/18.
 */
public interface CustomerRepository extends JpaRepository<Customer,Integer>, CustomerCustomizedRepository {


}
