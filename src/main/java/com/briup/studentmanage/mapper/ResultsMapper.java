package com.briup.studentmanage.mapper;

import com.briup.studentmanage.bean.Results;
import com.briup.studentmanage.bean.ResultsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResultsMapper {
    long countByExample(ResultsExample example);

    int deleteByExample(ResultsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Results record);

    int insertSelective(Results record);

    List<Results> selectByExample(ResultsExample example);

    Results selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Results record, @Param("example") ResultsExample example);

    int updateByExample(@Param("record") Results record, @Param("example") ResultsExample example);

    int updateByPrimaryKeySelective(Results record);

    int updateByPrimaryKey(Results record);
}