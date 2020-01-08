package com.briup.studentmanage.mapper.ex;

import com.briup.studentmanage.bean.ex.User;

public interface RegisterMapper {
    void addUser(User user);
    User findByUserName(String username);
}
