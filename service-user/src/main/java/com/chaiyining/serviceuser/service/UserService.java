package com.chaiyining.serviceuser.service;


import com.chaiyining.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chaiyining.serviceuser.mapper.UserMapper;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    //根据id查询user
    public User getUserById(Integer id){

        User user=userMapper.getUserById(id);

        return  user;
    }
    //根据id查询用户名称
    public String getUsernameById(Integer id){
        User user=getUserById(id);
        return user.getUsername();
    }
}
