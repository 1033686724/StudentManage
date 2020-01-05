package com.briup.studentmanage.web.controller;

import com.briup.studentmanage.service.INoticeRequestService;
import com.briup.studentmanage.util.Message;
import com.briup.studentmanage.util.MessageUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/noticeRequest")
@Api(description = "消息处理")
public class NoticeRequestController {
    @Autowired
    INoticeRequestService iNoticeRequestService;
    @GetMapping("/search")
    public Message searchAll(){
        return MessageUtil.success(iNoticeRequestService.searchAll());
    }
    @PutMapping("/ok")
    public Message ok(int id){
        iNoticeRequestService.noticeOk(id);
        return MessageUtil.success();
    }
    @PutMapping("/refuse")
    public Message refuse(int id){
        iNoticeRequestService.noticeNo(id);
        return MessageUtil.success();
    }
}
