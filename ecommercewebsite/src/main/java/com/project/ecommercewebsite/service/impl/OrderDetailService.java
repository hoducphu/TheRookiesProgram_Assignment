package com.project.ecommercewebsite.service.impl;

import java.util.List;

import com.project.ecommercewebsite.dto.OrderDetailDto;
import com.project.ecommercewebsite.entity.Order_detail;
import com.project.ecommercewebsite.repository.OrderDetailRepository;
import com.project.ecommercewebsite.service.IOrderDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService implements IOrderDetailService {

    @Autowired
    private OrderDetailRepository orderdetailRepository;

    @Override
    public List<OrderDetailDto> getAllOrderDetail() {
        List<Order_detail> orderDetail = orderdetailRepository.findAll();
        return OrderDetailDto.toDto(orderDetail);
    }

    @Override
    public OrderDetailDto getOrderDetailById(int orderdetail_id) throws ResourceNotFoundException {
        Order_detail orderDetail = orderdetailRepository.findById(orderdetail_id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + orderdetail_id));
        return OrderDetailDto.toDto(orderDetail);
    }

    @Override
    public OrderDetailDto postOrderDetail(OrderDetailDto orderDetailDto) {
        Order_detail orderDetail = OrderDetailDto.toEntity(orderDetailDto);
        orderDetailDto.setOrderdetail_id(0);
        orderDetail = orderdetailRepository.save(orderDetail);
        return OrderDetailDto.toDto(orderDetail);
    }

    @Override
    public OrderDetailDto updateOrderDetail(int orderdetail_id, OrderDetailDto orderDetail)
            throws ResourceNotFoundException {
        Order_detail newOrderDetail = orderdetailRepository.findById(orderdetail_id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + orderdetail_id));

        newOrderDetail.setQuantity(orderDetail.getQuantity());
        newOrderDetail.setPrice(orderDetail.getPrice());
        newOrderDetail.setStatus(orderDetail.getStatus());
        newOrderDetail.setDeli_date(orderDetail.getDeli_date());
        newOrderDetail.setDeli_place(orderDetail.getDeli_place());
        Order_detail updatedOrderDetail = orderdetailRepository.save(newOrderDetail);
        return OrderDetailDto.toDto(updatedOrderDetail);
    }

    @Override
    public String deleteOrderDetail(int orderdetail_id) throws ResourceNotFoundException {
        Order_detail orderdetailData = orderdetailRepository.findById(orderdetail_id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + orderdetail_id));
        orderdetailRepository.delete(orderdetailData);
        return "Order detail has been deleted";
    }
}