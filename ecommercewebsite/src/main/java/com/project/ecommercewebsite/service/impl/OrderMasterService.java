package com.project.ecommercewebsite.service.impl;

import java.util.List;

import com.project.ecommercewebsite.dto.OrderMasterDto;
import com.project.ecommercewebsite.entity.Order_master;
import com.project.ecommercewebsite.repository.OrderMasterRepository;
import com.project.ecommercewebsite.service.IOrderMasterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OrderMasterService implements IOrderMasterService {

    @Autowired
    private OrderMasterRepository orderRepository;

    @Override
    public List<OrderMasterDto> getAllOrder() {
        List<Order_master> orders;
        orders = orderRepository.findAll();
        return OrderMasterDto.toDto(orders);
    }

    @Override
    public OrderMasterDto getOrderById(int order_id) throws ResourceNotFoundException {
        Order_master order = orderRepository.findById(order_id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + order_id));
        return OrderMasterDto.toDto(order);
    }

    @Override
    public OrderMasterDto postOrder(OrderMasterDto orderDto) {
        Order_master order = OrderMasterDto.toEntity(orderDto);
        orderDto.setOrder_id(0);
        order = orderRepository.save(order);
        return OrderMasterDto.toDto(order);
    }

    @Override
    public OrderMasterDto updateOrder(int order_id, OrderMasterDto orderDetails) throws ResourceNotFoundException {
        Order_master order = orderRepository.findById(order_id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + order_id));

        order.setOrder_date(orderDetails.getOrder_date());
        order.setClose_order_date(orderDetails.getClose_order_date());
        Order_master updatedOrder = orderRepository.save(order);
        return OrderMasterDto.toDto(updatedOrder);
    }

    @Override
    public String deleteOrder(int order_id) throws ResourceNotFoundException {
        Order_master order = orderRepository.findById(order_id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + order_id));
        orderRepository.delete(order);
        return "Order has been deleted";
    }
}