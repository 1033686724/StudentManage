package com.briup.studentmanage.service.impl;

import com.briup.studentmanage.bean.Results;
import com.briup.studentmanage.bean.ResultsExample;
import com.briup.studentmanage.bean.ex.ResultsEX;
import com.briup.studentmanage.mapper.ResultsMapper;
import com.briup.studentmanage.mapper.ex.ResultEXMapper;
import com.briup.studentmanage.service.IResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements IResultService {
    @Autowired
    private ResultsMapper resultsMapper;
    @Autowired
    private ResultEXMapper resultEXMapper;
    @Override
    public List<Results> selectAll() throws RuntimeException {
        ResultsExample example = new ResultsExample();
        return resultsMapper.selectByExample(example);
    }

    @Override
    public void saveOrUpdate(Results results) throws RuntimeException {
        if (results == null){
            throw new RuntimeException("参数为空");
        }else if (results.getId()==null){
            resultsMapper.insert(results);
        }else {
            resultsMapper.updateByPrimaryKey(results);
        }
    }

    @Override
    public List<ResultsEX> searcher(String word) throws RuntimeException {
        word =word==null?"":word;
        if ((word==null)||"".equals(word)){
            List<ResultsEX> list = resultEXMapper.selectAll();
            return list;
        }

        else {
            word = "%" + word + "%";
            List<ResultsEX> list = resultEXMapper.selectByStuName(word);
            return list;
        }
    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        resultsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ResultsEX selectById(int id ) throws RuntimeException {
      return resultEXMapper.selectById(id);
    }
}
