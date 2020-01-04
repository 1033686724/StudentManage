package com.briup.studentmanage.mapper.ex;

import com.briup.studentmanage.bean.ex.StudentEX;

import java.util.List;

public interface StudentEXMapper {
    List<StudentEX> selectTeacher() throws RuntimeException;
}
