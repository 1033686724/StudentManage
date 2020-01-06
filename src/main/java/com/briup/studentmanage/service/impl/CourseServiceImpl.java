package com.briup.studentmanage.service.impl;

import com.briup.studentmanage.bean.Course;
import com.briup.studentmanage.bean.CourseExample;
import com.briup.studentmanage.bean.ex.CourseEX;
import com.briup.studentmanage.mapper.CourseMapper;
import com.briup.studentmanage.mapper.ex.CourseEXMapper;
import com.briup.studentmanage.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseEXMapper courseEXMapper;
    @Override
    public List<CourseEX> selectAll() throws RuntimeException {
        CourseExample example=new CourseExample();
        return courseEXMapper.selectAll();
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
    public List<CourseEX> search(String word) throws RuntimeException {

        word=word==null?"" :word;



        //key为空 word为空 表示下拉框和后面的输入框没有什么内容
        if ( word == null||"".equals(word)){
            return selectAll();}
        else {
            word="%"+word + "%";
            return courseEXMapper.selectClassOrCnameOrRemark(word);
        }

            //key为空 word不为空 表示下拉框没有选择，后面的输入框有内容

//        }else if ("classname".equals(word)){
//            word="%"+word + "%";
//            return courseEXMapper.selectClass(word);
//        }else if ("cname".equals(word)){
//            word="%"+word + "%";
//            return courseEXMapper.selectCname(word);
//        }else if ("remark".equals(word)){
//            word="%"+word + "%";
//            return courseEXMapper.selectRemark(word);
//        }

    }

    @Override
    public Course selectById(int id) throws RuntimeException {

       Course course= courseMapper.selectByPrimaryKey(id);
        return course;
    }
}