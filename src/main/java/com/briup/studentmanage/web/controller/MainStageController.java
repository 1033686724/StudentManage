package com.briup.studentmanage.web.controller;

import com.briup.studentmanage.bean.Notice;
import com.briup.studentmanage.service.IMainStageService;
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
@RequestMapping("/MainStage")
@Api(description = "主页")
public class MainStageController {
    @Autowired
    private IMainStageService iMainStageService;

    @GetMapping("/show")
    @ApiModelProperty("展示")
    public Message show(){
        String s[] = iMainStageService.searchNum();
        return MessageUtil.success(s);
    }
    @GetMapping("/notice")
    @ApiModelProperty("公告栏")
    public Message notice(){
        List<Notice> list= iMainStageService.show();
        return MessageUtil.success(list);
    }

}
