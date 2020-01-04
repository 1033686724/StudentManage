package com.briup.studentmanage.bean.ex;

import java.io.Serializable;
import java.util.Date;

public class ResultsEX implements Serializable {
    private Integer id;

    private Double chinese;

    private Double math;

    private Double english;

    private Double political;

    private Double history;

    private Double geographic;

    private String sName;

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    private Integer student_id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getChinese() {
        return chinese;
    }

    public void setChinese(Double chinese) {
        this.chinese = chinese;
    }

    public Double getMath() {
        return math;
    }

    public void setMath(Double math) {
        this.math = math;
    }

    public Double getEnglish() {
        return english;
    }

    public void setEnglish(Double english) {
        this.english = english;
    }

    public Double getPolitical() {
        return political;
    }

    public void setPolitical(Double political) {
        this.political = political;
    }

    public Double getHistory() {
        return history;
    }

    public void setHistory(Double history) {
        this.history = history;
    }

    public Double getGeographic() {
        return geographic;
    }

    public void setGeographic(Double geographic) {
        this.geographic = geographic;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }
}
