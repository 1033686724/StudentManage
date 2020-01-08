package com.briup.studentmanage.service;

import com.briup.studentmanage.bean.ex.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface ILoginVerifyService {
    boolean verifyUser(User user) throws RuntimeException;
    void forgetMailaddKey(String username,String mail,int key)throws RuntimeException;
    boolean verifyMessage(String mail,int key)throws RuntimeException;
    void deleteKey(String mail)throws RuntimeException;
    void changePassword(String username,String password)throws RuntimeException;
    void bindMail(String username,String mail) throws RuntimeException;
    String getIp(HttpServletRequest request) throws RuntimeException;
    void addFailNum(HttpSession session,String username) throws RuntimeException;
    boolean checkLock(HttpSession session,String username) throws RuntimeException;
    void clearFailNum(HttpSession session,String username) throws RuntimeException;
}
