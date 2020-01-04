package com.briup.studentmanage.service.impl;

import com.briup.studentmanage.bean.Manager;
import com.briup.studentmanage.bean.Notice;
import com.briup.studentmanage.bean.NoticeExample;
import com.briup.studentmanage.mapper.ManagerAdminMapper;
import com.briup.studentmanage.mapper.ManagerMapper;
import com.briup.studentmanage.mapper.NoticeMapper;
import com.briup.studentmanage.service.INoticeMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoticeMainServiceImpl implements INoticeMainService {
    @Autowired
    NoticeMapper noticeMapper;
//    @Autowired
//    ManagerMapper managerMapper;
//    @Autowired
//    ManagerAdminMapper managerAdminMapper;


    @Override
    public List<Notice> search(Date date, Date date1, String word) throws RuntimeException {
        NoticeExample example=new NoticeExample();
        if (date == null || date.equals("")) {
            if (date1 == null || date1.equals("")) {
                    if (word.equals("")||word==null){
                        return noticeMapper.selectByExample(example);
                    }else {
                        word="%"+word+"%";
                        example.createCriteria().andNoticeLike(word);
                       return noticeMapper.selectByExample(example);
                    }
            } else {
                if (word.equals("")||word==null){
                    example.createCriteria().andCreatetimeLessThanOrEqualTo(date1);
                   return noticeMapper.selectByExample(example);
                }else {
                    word="%"+word+"%";
                    example.createCriteria().andCreatetimeLessThanOrEqualTo(date1).andNoticeLike(word);
                    return noticeMapper.selectByExample(example);
                }}
        }else{
            if (date1 == null || date1.equals("")){
                if (word.equals("")||word==null){
                    example.createCriteria().andCreatetimeGreaterThanOrEqualTo(date);
                    return noticeMapper.selectByExample(example);
                }else {
                    word="%"+word+"%";
                    example.createCriteria().andCreatetimeGreaterThanOrEqualTo(date).andNoticeLike(word);
                    return noticeMapper.selectByExample(example);
                }
            }else {
                if (word.equals("")||word==null){
                    example.createCriteria().andCreatetimeBetween(date,date1);
                    return noticeMapper.selectByExample(example);
                }else {
                    word="%"+word+"%";
                    example.createCriteria().andCreatetimeBetween(date,date1).andNoticeLike(word);
                    return noticeMapper.selectByExample(example);
                }
            }

        }
    }

    @Override
    public void addNotice(String word,int id) throws RuntimeException {
        Notice notice=new Notice();
        notice.setAdminid(id);
        notice.setCreatetime(new Date());
        notice.setRose((short)0);
        notice.setState((short)0);
        noticeMapper.insert(notice);

    }

}