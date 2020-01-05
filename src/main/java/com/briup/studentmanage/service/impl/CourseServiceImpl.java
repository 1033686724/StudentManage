package com.briup.studentmanage.service.impl;

import com.briup.studentmanage.bean.Course;
import com.briup.studentmanage.bean.CourseExample;
import com.briup.studentmanage.mapper.CourseMapper;
import com.briup.studentmanage.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public List<Course> findAll() throws RuntimeException {
        CourseExample example=new CourseExample();
        return courseMapper.selectByExample(example);
    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        courseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Course course)throws RuntimeException {
        if(course== null){
            throw new RuntimeException("参数为空");
        }

        if (course.getId()==null){
            courseMapper.insert(course);
        }else {
            courseMapper.updateByPrimaryKey(course);
        }
    }

    @Override
    public Course selectById(int id) throws RuntimeException {

       Course course= courseMapper.selectByPrimaryKey(id);
        return course;
    }
}