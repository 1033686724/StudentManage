package com.briup.studentmanage.mapper.ex;

import com.briup.studentmanage.bean.ex.User;

public interface UserLoginMapper {
    User  verifyUserName(String username);
    User verifyUser(String username);
    User  verifyMail(String username);
    void addKey(int key,String mail);
    User findkey(String mail);
    void deletekey(String mail);
    void updatePassword(String password,String username);
    void updateMail(String mail,String username);
}
