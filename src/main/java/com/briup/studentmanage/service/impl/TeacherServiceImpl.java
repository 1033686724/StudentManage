package com.briup.studentmanage.service.impl;

import com.briup.studentmanage.bean.Teacher;
import com.briup.studentmanage.bean.TeacherExample;
import com.briup.studentmanage.mapper.CourseMapper;
import com.briup.studentmanage.mapper.TeacherMapper;
import com.briup.studentmanage.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {
   @Autowired
   private TeacherMapper teacherMapper;
    @Override
    public List<Teacher> findAll() throws RuntimeException {
        TeacherExample example=new TeacherExample();
        return  teacherMapper.selectByExample(example);
    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        teacherMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Teacher teacher)throws RuntimeException {
        if(teacher== null){
            throw new RuntimeException("参数为空");
        }

        if (teacher.getId()==null){
            teacherMapper.insert(teacher);
        }else {
            teacherMapper.updateByPrimaryKey(teacher);
        }
    }

    @Override
    public Teacher selectById(int id) throws RuntimeException {

       Teacher course= teacherMapper.selectByPrimaryKey(id);
        return course;
    }
}
