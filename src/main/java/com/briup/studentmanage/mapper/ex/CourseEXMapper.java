package com.briup.studentmanage.mapper.ex;

import com.briup.studentmanage.bean.ex.CourseEX;

import java.util.List;

public interface CourseEXMapper {
    List<CourseEX> selectAll() throws RuntimeException;

    List<CourseEX> selectClassOrCnameOrRemark(String word);

//    List<CourseEX> selectCname(String word);
//
//    List<CourseEX> selectRemark(String word);
}
