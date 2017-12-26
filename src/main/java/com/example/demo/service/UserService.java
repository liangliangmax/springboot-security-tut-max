package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @SuppressWarnings("")
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    public User getByUsername(String username){

        User user = new User();
        user.setUsername(username);

        System.out.println(userMapper.selectByUsername(username));


        user=userMapper.selectOne(user);

        List<Role> roles = roleMapper.selectRoleByUserid(user.getId());

        List<String> list= new ArrayList<>();

        for(Role r :roles){
            list.add(r.getRole());
        }

        user.setRoles(list);
        return user;
    }
}
