package com.briup.studentmanage.web.controller;

import com.briup.studentmanage.service.INoticeMainService;
import com.briup.studentmanage.service.impl.NoticeMainServiceImpl;
import com.briup.studentmanage.util.Message;
import com.briup.studentmanage.util.MessageUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/NoticeMain")
@Api(description = "主要消息")
public class NoticeMainController {
    @Autowired
    INoticeMainService iNoticeMainService;

    @GetMapping("/search")
    public Message search(Date date,Date date1,String word){
       return MessageUtil.success(iNoticeMainService.search(date,date1,word));
    }
    @PostMapping("/addNotice")
    public Message add(String word,int id){
        iNoticeMainService.addNotice(word,id);
        return MessageUtil.success();
    }
}
