package com.briup.studentmanage.service.impl;

import com.briup.studentmanage.bean.Notice;
import com.briup.studentmanage.mapper.MainMapper;
import com.briup.studentmanage.service.IMainStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MainStageImpl implements IMainStageService {
    @Autowired
    private MainMapper mainMapper;
    @Override
    public String[] searchNum() {
        String s[] ={"管理员数量="+mainMapper.selectAdminNum(),
                "老师数量="+mainMapper.selectTeacherNum(),
                "学生数量="+mainMapper.selectStuNum(),
                "班级数量="+mainMapper.selectClaNum()};
        return s;
    }

    @Override
    public List<Notice> show() throws RuntimeException {
        List<Notice> list = mainMapper.showNotice();
        return list;
    }
}
