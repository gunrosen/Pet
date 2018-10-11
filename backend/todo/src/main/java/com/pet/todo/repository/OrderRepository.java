package com.pet.todo.repository;

import com.pet.todo.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Gun on 10/11/18.
 */
public interface OrderRepository extends JpaRepository<Order,Integer>{
    @Query(value = "select * from orders  where customerNumber = ?1",nativeQuery = true)
    List<Order> getListOrderByCustomer(int customerId);
}
