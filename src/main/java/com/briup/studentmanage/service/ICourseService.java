package com.briup.studentmanage.service;

import com.briup.studentmanage.bean.Course;
import com.briup.studentmanage.bean.ex.CourseEX;

import java.util.List;

public interface ICourseService {
    List<CourseEX> selectAll()throws RuntimeException;

    void deleteById(int id) throws  RuntimeException;

    void saveOrUpdate(Course course)throws RuntimeException;

    List<CourseEX> search(String word) throws  RuntimeException;

    Course selectById(int id) throws RuntimeException;
}
