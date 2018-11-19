package com.pet.todo.service;

import com.pet.todo.domain.Order;
import com.pet.todo.restful.dto.order.OrderDto;
import com.pet.todo.restful.dto.order.OrderListDto;
import com.pet.todo.restful.dto.common.ListDto;

/**
 * Created by Gun on 10/9/18.
 */
public interface OrderService extends BaseService<OrderListDto,Integer> {

    ListDto<OrderListDto> getListOrderByCustomer(int customerNumber);

    OrderDto getOrderInfo(int orderNumber);

}
