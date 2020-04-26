package com.chaiyining.serviceorder.feign;


import com.chaiyining.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserFeignFallback implements UserFeignClient{
    @Override
    public User getUserByid(Integer id) {
        User u=new User();
        u.setUsername("固定值");
        return u;
    }

    @Override
    public User getUserByUser(User user) {

        User u=new User();
        u.setUsername("固定值");
        return u;
    }

    @Override
    public String getUsernameById(Integer id) {
        return null;
    }
}
