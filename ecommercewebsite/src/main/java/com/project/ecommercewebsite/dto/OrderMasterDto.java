package com.project.ecommercewebsite.dto;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.project.ecommercewebsite.entity.Order_master;

import lombok.Data;

@Data
public class OrderMasterDto {
    private int order_id;

    private Date order_date;

    private Date close_order_date;

    public static OrderMasterDto toDto(Order_master order) {
        OrderMasterDto orderDto = new OrderMasterDto();
        orderDto.setOrder_id(order.getOrder_id());
        orderDto.setOrder_date(order.getOrder_date());
        orderDto.setClose_order_date(order.getClose_order_date());
        return orderDto;
    }

    public static List<OrderMasterDto> toDto(List<Order_master> orders) {
        return orders.stream().map(x -> toDto(x)).collect(Collectors.toList());
    }

    public static Order_master toEntity(OrderMasterDto orderDto) {
        Order_master order = new Order_master();
        order.setOrder_id(orderDto.getOrder_id());
        order.setOrder_date(orderDto.getOrder_date());
        order.setClose_order_date(orderDto.getClose_order_date());
        return order;
    }

    public static List<Order_master> toEntity(List<OrderMasterDto> orderDto) {
        return orderDto.stream().map(x -> toEntity(x)).collect(Collectors.toList());
    }
}
