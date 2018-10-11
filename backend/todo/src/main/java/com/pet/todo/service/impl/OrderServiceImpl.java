package com.pet.todo.service.impl;

import com.pet.todo.domain.Order;
import com.pet.todo.domain.OrderDetail;
import com.pet.todo.repository.OrderDetailRepository;
import com.pet.todo.repository.OrderRepository;
import com.pet.todo.restful.dto.order.OrderDetailDto;
import com.pet.todo.restful.dto.order.OrderDto;
import com.pet.todo.restful.dto.order.OrderListDto;
import com.pet.todo.restful.dto.common.ListDto;
import com.pet.todo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Gun on 10/9/18.
 */
@Service
public class OrderServiceImpl extends AbstractService<OrderListDto,Order,Integer> implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    public ListDto<OrderListDto> getListOrderByCustomer(int customerNumber) {
        List<Order> lst = orderRepository.getListOrderByCustomer(customerNumber);
        List<OrderListDto> lstDto = lst.stream().map(this::convertToDto).collect(Collectors.toList());
        return new ListDto<>(lstDto);
    }

    @Override
    public OrderDto getOrderInfo(int orderNumber) {
        List<OrderDetail> orderDetails = orderDetailRepository.getOrderDetail(orderNumber);
        List<OrderDetailDto> orderDetailDtos = orderDetails.stream().map(orderDetail -> {return convertToDto(orderDetail)}).collect(Collectors.toList());
        Order order = orderRepository.findById(orderNumber).get();
        OrderDto dto = new OrderDto();
        dto.setComments(order.getComments());
        dto.setCustomerNumber(order.getCustomerNumber());
        dto.setItems();
        return orderD;
    }

    @Override
    protected JpaRepository<Order, Integer> getRepository() {
        return orderRepository;
    }

    @Override
    protected OrderListDto convertToDto(Order domain) {
        return new OrderListDto(domain);
    }

    @Override
    protected Order convertToDomain(OrderListDto orderDto) {
        return orderDto.toDomain();
    }

    @Override
    protected Integer getObjectId(OrderListDto orderDto) {
        return orderDto.getOrderNumber();
    }

    @Override
    protected Integer getDomainId(Order domain) {
        return domain.getOrderNumber();
    }

    @Override
    protected OrderListDto emptyDTO() {
        return new OrderListDto();
    }
}
