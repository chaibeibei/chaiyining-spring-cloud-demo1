package com.chaiyining.serviceorder.feign;

import com.chaiyining.user.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name="service-user",fallback = UserFeignFallback.class)
public interface UserFeignClient {
    @RequestMapping("/user/getUserById")
    public User getUserByid(@RequestParam("id") Integer id);

    @RequestMapping("/user/getUserByUser")
    public User getUserByUser(@RequestBody User user);

    @RequestMapping("/user/getUsernameById")
    public String getUsernameById(@RequestParam("id") Integer id);
}
