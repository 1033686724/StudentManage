package com.briup.studentmanage.service.impl;

import com.briup.studentmanage.bean.Notice;
import com.briup.studentmanage.bean.NoticeExample;
import com.briup.studentmanage.bean.ex.NoticeMainEX;
import com.briup.studentmanage.mapper.NoticeMapper;
import com.briup.studentmanage.mapper.ex.NoticeMainEXMapper;
import com.briup.studentmanage.service.INoticeRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeRequestServiceImpl implements INoticeRequestService {
    @Autowired
    NoticeMainEXMapper noticeMainEXMapper;
    @Autowired
    NoticeMapper noticeMapper;
    //所有未通过的请求
    @Override
    public List<NoticeMainEX> searchAll() throws RuntimeException {

        return noticeMainEXMapper.selectAll();
    }

    @Override
    public void noticeOk(int id) throws RuntimeException {
        Notice notice=noticeMapper.selectByPrimaryKey(id);
        if (notice.getState()!=2){
            throw  new RuntimeException("错误");
        }else{
            notice.setState((short)1);
            noticeMapper.updateByPrimaryKey(notice);
        }


    }

    @Override
    public void noticeNo(int id) throws RuntimeException {
        Notice notice=noticeMapper.selectByPrimaryKey(id);
        if (notice.getState()!=0){
            throw  new RuntimeException("错误");
        }else{
            notice.setState((short)2);
            noticeMapper.updateByPrimaryKey(notice);
        }

    }
}
