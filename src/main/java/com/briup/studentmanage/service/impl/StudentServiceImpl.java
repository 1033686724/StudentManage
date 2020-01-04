package com.briup.studentmanage.service.impl;

import com.briup.studentmanage.bean.Student;
import com.briup.studentmanage.bean.StudentExample;
import com.briup.studentmanage.bean.Teacher;
import com.briup.studentmanage.bean.ex.StudentEX;
import com.briup.studentmanage.mapper.StudentMapper;
import com.briup.studentmanage.mapper.ex.StudentEXMapper;
import com.briup.studentmanage.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentEXMapper studentEXMapper;
    @Override
    public List<Student> selectAll() throws RuntimeException {
        StudentExample example = new StudentExample();
        List<Student> list = studentMapper.selectByExample(example);
        return list;
    }

    @Override
    public void saveOrUpdate(Student student) throws RuntimeException {
        if (student == null){
            throw new RuntimeException("参数为空");
        }else if (student.getId()==null){
            studentMapper.insert(student);
        }else {
            studentMapper.updateByPrimaryKey(student);
        }
    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<StudentEX> selectTeacher() throws RuntimeException {
        List<StudentEX> list = studentEXMapper.selectTeacher();
        return list;
    }
}
