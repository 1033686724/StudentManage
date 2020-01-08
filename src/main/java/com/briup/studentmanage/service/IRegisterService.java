package com.briup.studentmanage.service;

import com.briup.studentmanage.bean.ex.User;

public interface IRegisterService {
    void register(User user);
    User findByUserName(String username);
}
