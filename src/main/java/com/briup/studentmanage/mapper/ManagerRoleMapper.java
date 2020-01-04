package com.briup.studentmanage.mapper;

import com.briup.studentmanage.bean.ManagerRoleExample;
import com.briup.studentmanage.bean.ManagerRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManagerRoleMapper {
    long countByExample(ManagerRoleExample example);

    int deleteByExample(ManagerRoleExample example);

    int deleteByPrimaryKey(ManagerRoleKey key);

    int insert(ManagerRoleKey record);

    int insertSelective(ManagerRoleKey record);

    List<ManagerRoleKey> selectByExample(ManagerRoleExample example);

    int updateByExampleSelective(@Param("record") ManagerRoleKey record, @Param("example") ManagerRoleExample example);

    int updateByExample(@Param("record") ManagerRoleKey record, @Param("example") ManagerRoleExample example);
}