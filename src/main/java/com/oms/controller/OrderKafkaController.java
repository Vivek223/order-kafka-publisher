package com.oms.controller;

import com.oms.models.Order;
import com.oms.repos.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderKafkaController {

    private OrderRepository orderRepository;

    public OrderKafkaController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @GetMapping("/publish")
    public ResponseEntity<List<Order>> publish(){
        List<Order> orderList = fetchOrders(); //new ArrayList<>();
        //orderList.add(new Order("sample comment", "ipid as you like"));
       // orderList.add(fetchOrders());
        return new ResponseEntity<>(orderList, HttpStatus.CREATED);
    }

    private List<Order> fetchOrders(){
        List<Order> fetchedOrders = orderRepository.findAll();
        return fetchedOrders;
    }
}
