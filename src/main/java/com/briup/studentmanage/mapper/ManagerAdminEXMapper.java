package com.briup.studentmanage.mapper;

import com.briup.studentmanage.bean.Manager;

import java.util.List;

public interface ManagerAdminEXMapper {

    List<Manager> selectBymanagerid();

    int selectAdminNum();

    int selectTeacherNum();

    int selectStuNum();

    int selectClaNum();

}
