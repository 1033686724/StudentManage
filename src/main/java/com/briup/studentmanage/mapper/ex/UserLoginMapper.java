package com.briup.studentmanage.mapper.ex;

import com.briup.studentmanage.bean.ex.User;

public interface UserLoginMapper {
    User  verifyUserName(String username);
    User verifyUser(String username);
}
