package com.briup.studentmanage.web.controller;

import com.briup.studentmanage.bean.Teacher;
import com.briup.studentmanage.service.ITeacherService;
import com.briup.studentmanage.util.Message;
import com.briup.studentmanage.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@Api(description = "教师管理")

public class   TeacherController {
    @Autowired
    private ITeacherService teacherService;

    @GetMapping("/findAll") // /link/selctAll
    @ApiOperation(value = "查询所有教师")
    public Message selectAll(){
        List<Teacher> teachers=teacherService.findAll();
        return MessageUtil.success(teachers);

    }
    @DeleteMapping("/deleteById")
    @ApiOperation(value = "删除教师")
    @ApiImplicitParam(name="id",value = "教师id",paramType = "query",dataType ="int" ,required = true)
    public Message deleteById(int id){
        teacherService.deleteById(id);
        return MessageUtil.success();

    }
    @PostMapping("/addTeacher")
    @ApiOperation(value = "添加教师信息")
    public Message addTeacher(Teacher teacher){
        teacherService.saveOrUpdate(teacher);
        return MessageUtil.success();
    }
    @GetMapping("/findById")
    @ApiImplicitParam(name="id",value = "教师id",paramType = "query",dataType ="int" ,required = true)
    @ApiOperation(value = "根据id查询数据")
    public Message findById(int id){
        Teacher teacher = teacherService.selectById(id);
        return  MessageUtil.success(teacher);

    }
    @PostMapping("/update")
    @ApiOperation(value = "根据id更新数据")
    public Message update(Teacher teacher){
        teacherService.saveOrUpdate(teacher);
        return MessageUtil.success();

    }
    @GetMapping("/selectByCondi")
    @ApiOperation(value = "关键词查询")
    public Message selectByCondi(String word){
        List<Teacher> list = teacherService.search(word);
        return MessageUtil.success(list);

    }
}