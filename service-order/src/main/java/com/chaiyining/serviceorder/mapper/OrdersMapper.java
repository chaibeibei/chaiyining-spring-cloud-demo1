package com.chaiyining.serviceorder.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.chaiyining.serviceorder.entity.Orders;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chaiyining
 * @since 2020-04-22
 */
public interface OrdersMapper extends BaseMapper<Orders> {

    Orders getOrderById(Integer id);
}
