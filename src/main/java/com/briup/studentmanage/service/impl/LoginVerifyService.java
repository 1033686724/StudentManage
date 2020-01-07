package com.briup.studentmanage.service.impl;

import com.briup.studentmanage.bean.Manager;
import com.briup.studentmanage.bean.ex.User;
import com.briup.studentmanage.mapper.ex.UserLoginMapper;
import com.briup.studentmanage.service.ILoginVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginVerifyService implements ILoginVerifyService {
    @Autowired
    UserLoginMapper userLoginMapper;

    @Override
    public boolean verifyUser(User user) throws RuntimeException {
        String username=user.getUsername();
        String password=user.getPassword();
        if (username==null||"".equals(username))
            throw new RuntimeException("用户名为空");
        else {
         if (userLoginMapper.verifyUserName(username).getUsername()==null)
             throw new RuntimeException("用户名不存在");
         else if (password==null||"".equals(password))
            throw new RuntimeException("密码为空");
        else {
            String ps =  userLoginMapper.verifyUser(username).getPassword();
            if (password.equals(ps))
                return true;
            else
                return false;
        }
        }

    }

    @Override
    public void forgetMailaddKey(String username,String mail, int key) throws RuntimeException {
        if (userLoginMapper.verifyUser(username)==null||userLoginMapper.verifyUser(username).equals(""))
            throw new RuntimeException("用户不存在");
        else {
            String s = userLoginMapper.verifyMail(username).getMail();
            if (s == null || s.equals(""))
                throw new RuntimeException("密保邮箱未绑定");
            else if (!s.equals(mail))
                throw new RuntimeException("密保邮箱错误");
            else {
                userLoginMapper.addKey(key,mail);
            }

        }
    }

    @Override
    public boolean verifyMessage(String mail, int key) throws RuntimeException {
        int key1=userLoginMapper.findkey(mail).getKey();
        return key==key1;
    }

    @Override
    public void deleteKey(String mail) throws RuntimeException {
        userLoginMapper.deletekey(mail);
    }

    @Override
    public void changePassword(String username, String password) throws RuntimeException {
        if (userLoginMapper.verifyUser(username)==null||userLoginMapper.verifyUser(username).equals(""))
            throw new RuntimeException("用户不存在");
        else
            userLoginMapper.updatePassword(password,username);
    }

    @Override
    public void bindMail(String username, String mail) throws RuntimeException {

            userLoginMapper.updateMail(mail,username);
    }
}
