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
}
