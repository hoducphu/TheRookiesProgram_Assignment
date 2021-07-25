package com.project.ecommercewebsite.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.project.ecommercewebsite.entity.Order_detail;

import lombok.Data;

@Data
public class OrderDetailDto {
    private int orderdetail_id;

    private int quantity;

    private int price;

    private String status;

    private Date deli_date;

    private String deli_place;

    public static OrderDetailDto toDto(Order_detail orderDetail) {
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        orderDetailDto.setOrderdetail_id(orderDetail.getOrderdetail_id());
        orderDetailDto.setQuantity(orderDetail.getQuantity());
        orderDetailDto.setPrice(orderDetail.getPrice());
        orderDetailDto.setStatus(orderDetail.getStatus());
        orderDetailDto.setDeli_date(orderDetail.getDeli_date());
        orderDetailDto.setDeli_place(orderDetail.getDeli_place());
        return orderDetailDto;
    }

    public static List<OrderDetailDto> toDto(List<Order_detail> orderDetail) {
        return orderDetail.stream().map(x -> toDto(x)).collect(Collectors.toList());
    }

    public static Order_detail toEntity(OrderDetailDto orderDetailDto) {
        Order_detail orderDetail = new Order_detail();
        orderDetail.setOrderdetail_id(orderDetailDto.getOrderdetail_id());
        orderDetail.setQuantity(orderDetailDto.getQuantity());
        orderDetail.setPrice(orderDetailDto.getPrice());
        orderDetail.setStatus(orderDetailDto.getStatus());
        orderDetail.setDeli_date(orderDetailDto.getDeli_date());
        orderDetail.setDeli_place(orderDetailDto.getDeli_place());
        return orderDetail;
    }

    public static List<Order_detail> toEntity(List<OrderDetailDto> orderDetailDto) {
        return orderDetailDto.stream().map(x -> toEntity(x)).collect(Collectors.toList());
    }
}
