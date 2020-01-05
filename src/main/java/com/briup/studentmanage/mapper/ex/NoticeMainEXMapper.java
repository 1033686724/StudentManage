package com.briup.studentmanage.mapper.ex;

import com.briup.studentmanage.bean.ex.NoticeMainEX;

import java.util.Date;
import java.util.List;

public interface NoticeMainEXMapper {
    List<NoticeMainEX> selectAll();
    List<NoticeMainEX> selectAll2();
    List<NoticeMainEX> selectByWord(String word);
    List<NoticeMainEX> selectByDate1(Date date);
    List<NoticeMainEX> selectByDate2(Date date);
    List<NoticeMainEX> selectByWordAndD1(Date date,String word);
    List<NoticeMainEX> selectByWordAndD2(Date date,String word);
    List<NoticeMainEX> selectByD1AndD2(Date date,Date date1);
    List<NoticeMainEX> selectByD1AndD2AndWord(Date date,Date date1,String word);
}
