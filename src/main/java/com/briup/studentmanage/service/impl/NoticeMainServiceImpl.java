package com.briup.studentmanage.service.impl;

import com.briup.studentmanage.bean.Manager;
import com.briup.studentmanage.bean.Notice;
import com.briup.studentmanage.bean.NoticeExample;
import com.briup.studentmanage.bean.ex.NoticeMainEX;
import com.briup.studentmanage.mapper.ManagerAdminMapper;
import com.briup.studentmanage.mapper.ManagerMapper;
import com.briup.studentmanage.mapper.NoticeMapper;
import com.briup.studentmanage.mapper.ex.NoticeMainEXMapper;
import com.briup.studentmanage.service.INoticeMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoticeMainServiceImpl implements INoticeMainService {
    @Autowired
    NoticeMapper noticeMapper;
    @Autowired
    NoticeMainEXMapper noticeMainEXMapper;
//    @Autowired
//    ManagerMapper managerMapper;
//    @Autowired
//    ManagerAdminMapper managerAdminMapper;


    @Override
    public List<NoticeMainEX> search(Date date, Date date1, String word) throws RuntimeException {
        NoticeExample example=new NoticeExample();
        if (date == null || date.equals("")) {
            if (date1 == null || date1.equals("")) {
                    if ("".equals(word)||word==null){
                    //  noticeMapper.selectByExample(example);
                     return noticeMainEXMapper.selectAll2();//全为空
                    }else {
                        word="%"+word+"%";
                      //  example.createCriteria().andNoticeLike(word);
                     //  noticeMapper.selectByExample(example);
                    return   noticeMainEXMapper.selectByWord(word);//两个date为空，word不为空
                    }
            } else {
                if (word.equals("")||word==null){
                  //  example.createCriteria().andCreatetimeLessThanOrEqualTo(date1);
                  // noticeMapper.selectByExample(example);
                   return noticeMainEXMapper.selectByDate2(date1);//第二个date不为空，其他全为空
                }else {
                    word="%"+word+"%";
                    //example.createCriteria().andCreatetimeLessThanOrEqualTo(date1).andNoticeLike(word);
                   // noticeMapper.selectByExample(example);
                    return noticeMainEXMapper.selectByWordAndD2(date1,word);//第一个date为空，其他不为空
                }}
        }else{
            if (date1 == null || date1.equals("")){
                if (word.equals("")||word==null){
//                    example.createCriteria().andCreatetimeGreaterThanOrEqualTo(date);
//                   noticeMapper.selectByExample(example);
                   return noticeMainEXMapper.selectByDate1(date);//第一个date不为空，其余为空
                }else {
                    word="%"+word+"%";
//                    example.createCriteria().andCreatetimeGreaterThanOrEqualTo(date).andNoticeLike(word);
//                     noticeMapper.selectByExample(example);
                     return  noticeMainEXMapper.selectByWordAndD1(date,word);//第二个date为空，其余不为空
                }
            }else {
                if (word.equals("")||word==null){
                  //  example.createCriteria().andCreatetimeBetween(date,date1);
                 //   noticeMapper.selectByExample(example);
                    return  noticeMainEXMapper.selectByD1AndD2(date,date1);//word为空，其余不为空
                }else {
                    word="%"+word+"%";
                  //  example.createCriteria().andCreatetimeBetween(date,date1).andNoticeLike(word);
                   // noticeMapper.selectByExample(example);
                    return noticeMainEXMapper.selectByD1AndD2AndWord(date,date1,word);//三个值全不为空
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