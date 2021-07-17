package com.project.ecommercewebsite.service;

import java.util.List;

import com.project.ecommercewebsite.dto.OrderMasterDto;

public interface IOrderMasterService {

    List<OrderMasterDto> getAllOrder();

    OrderMasterDto getOrderById(int order_id);

    OrderMasterDto postOrder(OrderMasterDto order);

    OrderMasterDto updateOrder(int order_id, OrderMasterDto order);

    String deleteOrder(int order_id);
}
