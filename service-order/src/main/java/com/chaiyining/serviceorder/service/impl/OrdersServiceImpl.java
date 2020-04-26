package com.chaiyining.serviceorder.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.chaiyining.serviceorder.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chaiyining.serviceorder.entity.Orders;
import com.chaiyining.serviceorder.mapper.OrdersMapper;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chaiyining
 * @since 2020-04-22
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    //根据id查询order
    public Orders getOrderById(Integer id){
        Orders orders = ordersMapper.getOrderById(id);
       /* orders.setId(id);
        //order.setUsername("username+"+id);
        orders.setOrderno(System.currentTimeMillis()+"");
        orders.setUserId(1);*/
        return  orders;
    }
}
