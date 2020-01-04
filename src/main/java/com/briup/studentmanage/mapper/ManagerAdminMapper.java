package com.briup.studentmanage.mapper;

import com.briup.studentmanage.bean.ManagerAdminExample;
import com.briup.studentmanage.bean.ManagerAdminKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManagerAdminMapper {
    long countByExample(ManagerAdminExample example);

    int deleteByExample(ManagerAdminExample example);

    int deleteByPrimaryKey(ManagerAdminKey key);

    int insert(ManagerAdminKey record);

    int insertSelective(ManagerAdminKey record);

    List<ManagerAdminKey> selectByExample(ManagerAdminExample example);

    int updateByExampleSelective(@Param("record") ManagerAdminKey record, @Param("example") ManagerAdminExample example);

    int updateByExample(@Param("record") ManagerAdminKey record, @Param("example") ManagerAdminExample example);
}