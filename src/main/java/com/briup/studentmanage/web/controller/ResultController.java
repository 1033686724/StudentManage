package com.briup.studentmanage.web.controller;

import com.briup.studentmanage.bean.Results;
import com.briup.studentmanage.bean.ex.ResultsEX;
import com.briup.studentmanage.service.IResultService;
import com.briup.studentmanage.util.Message;
import com.briup.studentmanage.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
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
    }@PostMapping("/update")
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

    @GetMapping("/deleteById")
    @ApiOperation(value = "根据ID删除成绩")
    public Message deleteById(int id ){
        iResultService.deleteById(id);
        return MessageUtil.success();
    }

    @GetMapping("/selectById")
    @ApiOperation(value = "根据ID查询成绩")
    public Message selectById(int id ){
        iResultService.selectById(id);
        return MessageUtil.success();
    }

    @GetMapping("/download")
    public Message download(int id, HttpServletResponse response)throws IOException {
        ResultsEX resultsEX = iResultService.selectById(id);

        XSSFWorkbook xssfWorkbook=new XSSFWorkbook();
        XSSFSheet xssfSheet=xssfWorkbook.createSheet();//工作表格
        //创建行
        XSSFRow xssfRow=xssfSheet.createRow(0);
        //创建列
        XSSFCell cell=xssfRow.createCell(0);
        //单元格类型
        cell.setCellType(CellType.STRING);
       // cell.setCellValue(allSurveyEX.getQnname());

        XSSFRow row=xssfSheet.createRow(1);
        row.createCell(0).setCellValue("学生姓名");
        row.createCell(1).setCellValue(resultsEX.getsName());
        row.createCell(2).setCellValue("语文成绩");
        row.createCell(3).setCellValue(resultsEX.getChinese());
        row.createCell(4).setCellValue("数学成绩");
        row.createCell(5).setCellValue(resultsEX.getMath());
        row.createCell(6).setCellValue("英文成绩");
        row.createCell(7).setCellValue(resultsEX.getEnglish());
        row.createCell(8).setCellValue("政治成绩");
        row.createCell(9).setCellValue(resultsEX.getPolitical());
        row.createCell(10).setCellValue("历史成绩");
        row.createCell(11).setCellValue(resultsEX.getHistory());
        row.createCell(12).setCellValue("地理成绩");
        row.createCell(13).setCellValue(resultsEX.getGeographic());

        xssfSheet.addMergedRegion(new CellRangeAddress(0,0,0,20));
//        List<ResultsEX> results =resultsEX.;
//
//        for (int i=0;i<allSurveyEX.getAnswers().size();i++)
//        {  XSSFRow rowi=xssfSheet.createRow(i+2);
//            rowi.createCell(0).setCellValue(i+1);
//            rowi.createCell(1).setCellValue(allSurveyEX.getAverage());
//            xssfSheet.addMergedRegion(new CellRangeAddress(i+2,i+2,7,7));}
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(resultsEX.getsName()+".xlsx", "utf-8"));
        xssfWorkbook.write(response.getOutputStream());
        return MessageUtil.success(iResultService.selectById(id));
    }
}
