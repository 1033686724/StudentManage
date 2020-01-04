package com.briup.studentmanage.web.controller;

import com.briup.studentmanage.bean.Results;
import com.briup.studentmanage.bean.ex.ResultsEX;
import com.briup.studentmanage.service.IResultService;
import com.briup.studentmanage.util.Message;
import com.briup.studentmanage.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
@Api(description = "成绩")
public class ResultController {
    @Autowired
    private IResultService iResultService;
    @GetMapping("/selectAll")
    @ApiOperation(value = "查询所有成绩")
    public Message selectAll(){
        return MessageUtil.success(iResultService.selectAll());
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改成绩")
    public Message update(Results results) {
        iResultService.saveOrUpdate(results);

        return MessageUtil.success();
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加成绩")
    public Message add(Results results) {
        iResultService.saveOrUpdate(results);

        return MessageUtil.success();
    }

    @GetMapping("/searcher")
    @ApiOperation(value = "搜索成绩")
    public Message searcher(String word){
        List<ResultsEX> list =  iResultService.searcher(word);
        return MessageUtil.success(list);
    }
}
