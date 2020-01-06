package com.briup.studentmanage.mapper.ex;

import com.briup.studentmanage.bean.Teacher;

import java.util.List;

public interface TeacherEXMapper {
    List<Teacher> selectName(String word);
}
