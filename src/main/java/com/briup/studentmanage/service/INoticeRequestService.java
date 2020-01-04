package com.briup.studentmanage.service;

import com.briup.studentmanage.bean.Notice;
import com.briup.studentmanage.bean.ex.NoticeMainEX;

import java.util.List;

public interface INoticeRequestService {
    List<NoticeMainEX> searchAll()throws RuntimeException;
    void noticeOk(int id)throws RuntimeException;
    void noticeNo(int id)throws RuntimeException;
}
