package com.briup.studentmanage.service;

import com.briup.studentmanage.bean.Course;

import java.util.List;

public interface ICourseService {
    List<Course> findAll() throws RuntimeException;

    void deleteById(int id) throws  RuntimeException;

    void saveOrUpdate(Course course)throws RuntimeException;

    Course selectById(int id) throws RuntimeException;
}
