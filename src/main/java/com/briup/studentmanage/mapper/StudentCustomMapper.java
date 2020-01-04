package com.briup.studentmanage.mapper;

import com.briup.studentmanage.bean.StudentCustom;
import com.briup.studentmanage.bean.StudentCustomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentCustomMapper {
    long countByExample(StudentCustomExample example);

    int deleteByExample(StudentCustomExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentCustom record);

    int insertSelective(StudentCustom record);

    List<StudentCustom> selectByExample(StudentCustomExample example);

    StudentCustom selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentCustom record, @Param("example") StudentCustomExample example);

    int updateByExample(@Param("record") StudentCustom record, @Param("example") StudentCustomExample example);

    int updateByPrimaryKeySelective(StudentCustom record);

    int updateByPrimaryKey(StudentCustom record);
}