package com.briup.studentmanage.mapper.ex;

import com.briup.studentmanage.bean.ex.ResultsEX;

import java.util.List;

public interface ResultEXMapper {
    List<ResultsEX> selectAll() throws RuntimeException;

    List<ResultsEX> selectByStuName(String word) throws RuntimeException;

    ResultsEX selectById(int id) throws RuntimeException;
}
