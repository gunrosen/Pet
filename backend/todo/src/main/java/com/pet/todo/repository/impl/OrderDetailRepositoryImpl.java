package com.pet.todo.repository.impl;

import com.pet.todo.domain.OrderDetail;
import com.pet.todo.repository.AbstractRepository;
import com.pet.todo.repository.OrderDetailRepository;
import com.pet.todo.support.db.SpecificationUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Gun on 10/11/18.
 */
@Repository
public class OrderDetailRepositoryImpl extends AbstractRepository<OrderDetail, Integer> implements OrderDetailRepository {

    public OrderDetailRepositoryImpl() {
        super(OrderDetail.class);
    }

    @Override
    public List<OrderDetail> getOrderDetail(int orderNumber) {
        return getAll(SpecificationUtils.equal("orderNumber", orderNumber),
                null,
                new Sort(Sort.Direction.ASC, "orderLineNumber"));
    }
}
