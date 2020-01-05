package com.briup.studentmanage.mapper;

import com.briup.studentmanage.bean.Notice;

import java.util.List;

public interface MainMapper {

    int selectAdminNum();

    int selectTeacherNum();

    int selectStuNum();

    int selectClaNum();

    List<Notice> showNotice();

}
