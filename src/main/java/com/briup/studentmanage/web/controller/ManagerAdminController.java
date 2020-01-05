package com.briup.studentmanage.web.controller;


import com.briup.studentmanage.bean.Manager;
import com.briup.studentmanage.bean.ManagerAdminKey;
import com.briup.studentmanage.mapper.ManagerAdminEXMapper;
import com.briup.studentmanage.service.IManagerService;
import com.briup.studentmanage.util.Message;
import com.briup.studentmanage.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Manager")
@Api(description = "管理员管理")
public class ManagerAdminController {

    @Autowired
    private IManagerService iManagerService;

    @GetMapping("/show")
    @ApiModelProperty("展示")
    public Message show(){
        String s[] = iManagerService.findNum();
        return MessageUtil.success(s);
    }
    @GetMapping("/search")
    @ApiModelProperty("查询")
    public Message search(){
        List<Manager> list = iManagerService.selectBymanagerid();
        return MessageUtil.success(list);
    }

}
