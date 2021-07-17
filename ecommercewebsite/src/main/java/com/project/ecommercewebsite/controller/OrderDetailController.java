package com.project.ecommercewebsite.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.ecommercewebsite.dto.OrderDetailDto;
import com.project.ecommercewebsite.entity.Order_detail;
import com.project.ecommercewebsite.service.IOrderDetailService;

@RestController
@RequestMapping("/api/orderdetail")
public class OrderDetailController {

    @Autowired
    private IOrderDetailService orderdetailService;

    // get all order detail : read
    @GetMapping("")
    public List<OrderDetailDto> getAllAOrderDetails() {
        List<OrderDetailDto> orderDetail = orderdetailService.getAllOrderDetail();
        return orderDetail;
    }

    // get order detail by its id : read
    @GetMapping("/{orderdetail_id}")
    public ResponseEntity<OrderDetailDto> getOrderDetail(@PathVariable int orderdetail_id) {
        OrderDetailDto orderDetail = orderdetailService.getOrderDetailById(orderdetail_id);
        return ResponseEntity.ok().body(orderDetail);
    }

    // create new order detail : create
    @PostMapping("")
    public OrderDetailDto createOrder_detail(@Valid @RequestBody OrderDetailDto order_detail) {
        orderdetailService.postOrderDetail(order_detail);
        return order_detail;
    }

    // update order detail
    @PutMapping(value = "/{orderdetail_id}")
    public ResponseEntity<OrderDetailDto> updateOrder_detail(@PathVariable("orderdetail_id") int orderdetail_id,
            @RequestBody OrderDetailDto orderDetail) {
        OrderDetailDto updatedOrderDetail = orderdetailService.updateOrderDetail(orderdetail_id, orderDetail);
        return ResponseEntity.ok().body(updatedOrderDetail);
    }

    // delete order detail
    @DeleteMapping(value = "/{orderdetail_id}")
    public ResponseEntity<Order_detail> deleteOrderDetail(@PathVariable int orderdetail_id) {
        orderdetailService.deleteOrderDetail(orderdetail_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
