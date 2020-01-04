package com.briup.studentmanage.web.controller;

import com.briup.studentmanage.bean.Results;
import com.briup.studentmanage.bean.Student;
import com.briup.studentmanage.bean.Teacher;
import com.briup.studentmanage.bean.ex.StudentEX;
import com.briup.studentmanage.service.IStudentService;
import com.briup.studentmanage.util.Message;
import com.briup.studentmanage.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
@Api(description = "学生")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;
    @GetMapping("/selectAll")
    @ApiOperation(value = "查询所有学生")
    public Message selectAll(){
        return MessageUtil.success(iStudentService.selectAll());
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改学生信息")
    public Message update(Student student) {
        iStudentService.saveOrUpdate(student);

        return MessageUtil.success();
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加学生信息")
    public Message add(Student student) {
        iStudentService.saveOrUpdate(student);

        return MessageUtil.success();
    }

    @GetMapping("/deleteById")
    @ApiOperation(value = "根据ID删除学生数据")
    public Message deleteById(int id ){
        iStudentService.deleteById(id);
        return MessageUtil.success();
    }

    @GetMapping("/selectTeacher")
    @ApiOperation(value = "查询教师信息")
    public Message selectTeacher(){
       List<StudentEX> list =  iStudentService.selectTeacher();
        return MessageUtil.success(list);
    }
}
