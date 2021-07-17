package com.project.ecommercewebsite.service;

import java.util.List;

import com.project.ecommercewebsite.dto.OrderDetailDto;

public interface IOrderDetailService {

    List<OrderDetailDto> getAllOrderDetail();

    OrderDetailDto getOrderDetailById(int orderdetail);

    OrderDetailDto postOrderDetail(OrderDetailDto orderDetailDto);

    OrderDetailDto updateOrderDetail(int orderdetail_id, OrderDetailDto order_detail);

    String deleteOrderDetail(int orderdetail_id);
}
