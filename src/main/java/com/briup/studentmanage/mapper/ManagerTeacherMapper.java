package com.briup.studentmanage.mapper;

import com.briup.studentmanage.bean.ManagerTeacherExample;
import com.briup.studentmanage.bean.ManagerTeacherKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManagerTeacherMapper {
    long countByExample(ManagerTeacherExample example);

    int deleteByExample(ManagerTeacherExample example);

    int deleteByPrimaryKey(ManagerTeacherKey key);

    int insert(ManagerTeacherKey record);

    int insertSelective(ManagerTeacherKey record);

    List<ManagerTeacherKey> selectByExample(ManagerTeacherExample example);

    int updateByExampleSelective(@Param("record") ManagerTeacherKey record, @Param("example") ManagerTeacherExample example);

    int updateByExample(@Param("record") ManagerTeacherKey record, @Param("example") ManagerTeacherExample example);
}