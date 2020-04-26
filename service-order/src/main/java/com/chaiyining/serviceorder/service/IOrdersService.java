package com.chaiyining.serviceorder.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.chaiyining.serviceorder.entity.Orders;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chaiyining
 * @since 2020-04-22
 */
public interface IOrdersService extends IService<Orders> {

    //根据id查询order
    public Orders getOrderById(Integer id);
}
