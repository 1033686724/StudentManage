package com.briup.studentmanage.mapper;

import com.briup.studentmanage.bean.ManagerStudentExample;
import com.briup.studentmanage.bean.ManagerStudentKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManagerStudentMapper {
    long countByExample(ManagerStudentExample example);

    int deleteByExample(ManagerStudentExample example);

    int deleteByPrimaryKey(ManagerStudentKey key);

    int insert(ManagerStudentKey record);

    int insertSelective(ManagerStudentKey record);

    List<ManagerStudentKey> selectByExample(ManagerStudentExample example);

    int updateByExampleSelective(@Param("record") ManagerStudentKey record, @Param("example") ManagerStudentExample example);

    int updateByExample(@Param("record") ManagerStudentKey record, @Param("example") ManagerStudentExample example);
}