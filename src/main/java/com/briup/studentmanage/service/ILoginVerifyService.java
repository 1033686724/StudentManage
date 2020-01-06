package com.briup.studentmanage.service;

import com.briup.studentmanage.bean.ex.User;

public interface ILoginVerifyService {
    boolean verifyUser(User user) throws RuntimeException;
}
