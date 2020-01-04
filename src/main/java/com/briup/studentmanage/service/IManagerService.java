package com.briup.studentmanage.service;

import com.briup.studentmanage.bean.Manager;

import java.util.List;

public interface IManagerService {
    String[] findNum();
    List<Manager> selectBymanagerid();
}
