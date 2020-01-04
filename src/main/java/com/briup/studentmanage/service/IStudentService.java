package com.briup.studentmanage.service;

import com.briup.studentmanage.bean.Results;
import com.briup.studentmanage.bean.Student;
import com.briup.studentmanage.bean.Teacher;
import com.briup.studentmanage.bean.ex.StudentEX;

import java.util.List;

public interface IStudentService {
    List<Student> selectAll() throws RuntimeException;

    void  saveOrUpdate(Student student)throws RuntimeException;

    void deleteById(int id) throws  RuntimeException;

    List<StudentEX> selectTeacher() throws RuntimeException;




}
