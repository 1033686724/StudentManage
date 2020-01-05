package com.briup.studentmanage.service;

import com.briup.studentmanage.bean.Teacher;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public interface ITeacherService {
    List<Teacher> findAll() throws  RuntimeException;


    void deleteById(int id) throws  RuntimeException;

    void saveOrUpdate(Teacher teacher)throws RuntimeException;

    Teacher selectById(int id) throws RuntimeException;
}
