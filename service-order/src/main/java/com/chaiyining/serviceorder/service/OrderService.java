package com.chaiyining.serviceorder.service;


import org.springframework.stereotype.Service;
import com.chaiyining.serviceorder.model.Order;

@Service
public class OrderService {
    //根据id查询order
    public Order getOrderById(Integer id){
        Order order = new Order();
        order.setId(id);
        //order.setUsername("username+"+id);
        order.setOrderno(System.currentTimeMillis()+"");
        order.setUserId(1);
        return  order;
    }
}
