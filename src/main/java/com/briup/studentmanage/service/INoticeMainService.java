package com.briup.studentmanage.service;

import com.briup.studentmanage.bean.Notice;
import com.briup.studentmanage.bean.ex.NoticeMainEX;

import java.util.Date;
import java.util.List;

public interface INoticeMainService {
        List<NoticeMainEX> search(Date date, Date date1, String word) throws  RuntimeException;
        void addNotice(String word,int id)throws RuntimeException;
        }
