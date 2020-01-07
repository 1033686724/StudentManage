package com.briup.studentmanage.service;

import com.briup.studentmanage.bean.ex.User;

public interface ILoginVerifyService {
    boolean verifyUser(User user) throws RuntimeException;
    void forgetMailaddKey(String username,String mail,int key)throws RuntimeException;
    boolean verifyMessage(String mail,int key)throws RuntimeException;
    void deleteKey(String mail)throws RuntimeException;
    void changePassword(String username,String password)throws RuntimeException;
    void bindMail(String username,String mail) throws RuntimeException;
}
