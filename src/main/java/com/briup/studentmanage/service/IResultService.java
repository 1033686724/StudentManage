package com.briup.studentmanage.service;

import com.briup.studentmanage.bean.Results;
import com.briup.studentmanage.bean.ex.ResultsEX;

import java.util.List;

public interface IResultService {
    List<Results> selectAll() throws RuntimeException;

    void  saveOrUpdate(Results results)throws RuntimeException;

    List<ResultsEX> searcher(String word)throws RuntimeException;

    void deleteById(int id) throws  RuntimeException;

    ResultsEX selectById(int id) throws RuntimeException;
}
