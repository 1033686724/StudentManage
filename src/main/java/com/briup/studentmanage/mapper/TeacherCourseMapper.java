package com.briup.studentmanage.mapper;

import com.briup.studentmanage.bean.TeacherCourseExample;
import com.briup.studentmanage.bean.TeacherCourseKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherCourseMapper {
    long countByExample(TeacherCourseExample example);

    int deleteByExample(TeacherCourseExample example);

    int deleteByPrimaryKey(TeacherCourseKey key);

    int insert(TeacherCourseKey record);

    int insertSelective(TeacherCourseKey record);

    List<TeacherCourseKey> selectByExample(TeacherCourseExample example);

    int updateByExampleSelective(@Param("record") TeacherCourseKey record, @Param("example") TeacherCourseExample example);

    int updateByExample(@Param("record") TeacherCourseKey record, @Param("example") TeacherCourseExample example);
}