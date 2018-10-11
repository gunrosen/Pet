package com.pet.todo.repository;

import com.pet.todo.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Gun on 10/11/18.
 */
public interface OrderDetailRepository  {
    List<OrderDetail> getOrderDetail(int orderNumber);
}
