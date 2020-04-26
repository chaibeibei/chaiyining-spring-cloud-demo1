package com.chaiyining.serviceorder.controller;


import com.chaiyining.user.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.chaiyining.serviceorder.entity.Orders;
import com.chaiyining.serviceorder.feign.UserFeignClient;
import com.chaiyining.serviceorder.feign.UserFeignFallback;
import com.chaiyining.serviceorder.service.IOrdersService;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrdersConterller {

    @Autowired
    private IOrdersService iOrdersServiceService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private UserFeignFallback userFeignFallback;



    @RequestMapping("getOrdersById")
    @HystrixCommand(fallbackMethod = "getUserByUserfallback")
    public Orders getOrderById(@RequestParam("id") Integer id){
        Orders orders = iOrdersServiceService.getOrderById(id);

       /* User userParam = new User();
        userParam.setId(1);*/
        User user = userFeignClient.getUserByid(1);
        log.info("user:{}",user);
        orders.setUsername(user.getUsername());
        return orders;
    }

    public  Orders getUserByUserfallback(Integer id){
       Orders order=iOrdersServiceService.getOrderById(id);
        order.setUsername("固定值");
        return  order;
    }

}

