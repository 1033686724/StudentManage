package com.briup.studentmanage.service.impl;

import com.briup.studentmanage.bean.ex.User;
import com.briup.studentmanage.mapper.ex.RegisterMapper;
import com.briup.studentmanage.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements IRegisterService {
    @Autowired
    private RegisterMapper registerMapper;
    @Override
    public void register(User user) {
        registerMapper.addUser(user);
    }

    @Override
    public User findByUserName(String username) {
        return registerMapper.findByUserName(username);
    }
}
