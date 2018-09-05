package com.pet.todo.repository;

import com.pet.todo.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Gun on 9/5/18.
 */
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
