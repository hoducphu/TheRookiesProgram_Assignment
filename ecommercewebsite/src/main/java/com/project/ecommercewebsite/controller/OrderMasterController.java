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

import com.project.ecommercewebsite.dto.OrderMasterDto;
import com.project.ecommercewebsite.entity.Order_master;
import com.project.ecommercewebsite.service.IOrderMasterService;

@RestController
@RequestMapping("/api/orders")
public class OrderMasterController {

    @Autowired
    private IOrderMasterService orderService;

    // get all order : read
    @GetMapping("")
    public List<OrderMasterDto> getAllOrder() {
        List<OrderMasterDto> orders = orderService.getAllOrder();
        return orders;
    }

    // get order by its id : read
    @GetMapping("/{order_id}")
    public ResponseEntity<OrderMasterDto> getOrder(@PathVariable int order_id) {
        OrderMasterDto orderDto = orderService.getOrderById(order_id);
        return ResponseEntity.ok().body(orderDto);
    }

    // create new order : create
    @PostMapping("")
    public OrderMasterDto createOrder(@Valid @RequestBody OrderMasterDto orderDto) {
        orderService.postOrder(orderDto);
        return orderDto;
    }

    // update order
    @PutMapping(value = "/{order_id}")
    public ResponseEntity<OrderMasterDto> updateOrder(@PathVariable("order_id") int order_id,
            @RequestBody OrderMasterDto order) {
        OrderMasterDto updatedOrder = orderService.updateOrder(order_id, order);
        return ResponseEntity.ok().body(updatedOrder);
    }

    // delete order
    @DeleteMapping(value = "/{order_id}")
    public ResponseEntity<Order_master> deleteOrder(@PathVariable int order_id) {
        orderService.deleteOrder(order_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
