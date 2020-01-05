package com.briup.studentmanage.web.controller;

import com.briup.studentmanage.bean.Course;
import com.briup.studentmanage.service.ICourseService;
import com.briup.studentmanage.util.Message;
import com.briup.studentmanage.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "班级管理")
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @GetMapping("/selectAll") // /link/selctAll
    @ApiOperation(value = "查询所有班级")
    public Message selectAll(){
        List<Course> courses=courseService.findAll();
        return MessageUtil.success(courses);

    }
    @DeleteMapping("/deleteById")
    @ApiOperation(value = "删除班级")
    @ApiImplicitParam(name="id",value = "班级id",paramType = "query",dataType ="int" ,required = true)
    public Message deleteById(int id){
        courseService.deleteById(id);
        return MessageUtil.success();

    }
    @PostMapping("/addCourse")
    @ApiOperation(value = "添加班级信息")
    public Message addLink(Course course){
        courseService.saveOrUpdate(course);
        return MessageUtil.success();
    }
    @GetMapping("/findById")
    @ApiImplicitParam(name="id",value = "班级id",paramType = "query",dataType ="int" ,required = true)
    @ApiOperation(value = "根据id查询数据")
    public Message findById(int id){
        Course course = courseService.selectById(id);
        return  MessageUtil.success(course);

    }
    @PostMapping("/update")
    @ApiOperation(value = "根据id更新数据")
    public Message update(Course course){
        courseService.saveOrUpdate(course);
        return MessageUtil.success();

    }
}
