package com.briup.studentmanage.service.impl;

import com.briup.studentmanage.bean.Manager;
import com.briup.studentmanage.mapper.ManagerAdminEXMapper;
import com.briup.studentmanage.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerAdminImpl implements IManagerService {

    @Autowired
    private ManagerAdminEXMapper managerAdminEXMapper;
    @Override
    public String[] findNum() {

        String s[] ={"管理员数量="+managerAdminEXMapper.selectAdminNum(),
                "老师数量="+managerAdminEXMapper.selectTeacherNum(),
                "学生数量="+managerAdminEXMapper.selectStuNum(),
                "班级数量="+managerAdminEXMapper.selectClaNum()};
//        System.out.println("管理员数量="+managerAdminEXMapper.selectAdminNum());
//        System.out.println("老师数量="+managerAdminEXMapper.selectTeacherNum());
//        System.out.println("学生数量="+managerAdminEXMapper.selectStuNum());
//        System.out.println("班级数量="+managerAdminEXMapper.selectClaNum());
        return s;
    }

    @Override
    public List<Manager> selectBymanagerid() {
        List<Manager> list = managerAdminEXMapper.selectBymanagerid();
        return list;
    }
}
