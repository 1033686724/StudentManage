package com.briup.studentmanage.bean;

import java.io.Serializable;
import java.util.Date;

public class Results implements Serializable {
    private Integer id;

    private Double chinese;

    private Double math;

    private Double english;

    private Double political;

    private Double history;

    private Double geographic;

    private Date examtime;

    private Integer examstatus;

    private Integer studentid;

    private Integer state;

    private static final long serialVersionUID = 1L;

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

    public Date getExamtime() {
        return examtime;
    }

    public void setExamtime(Date examtime) {
        this.examtime = examtime;
    }

    public Integer getExamstatus() {
        return examstatus;
    }

    public void setExamstatus(Integer examstatus) {
        this.examstatus = examstatus;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", chinese=").append(chinese);
        sb.append(", math=").append(math);
        sb.append(", english=").append(english);
        sb.append(", political=").append(political);
        sb.append(", history=").append(history);
        sb.append(", geographic=").append(geographic);
        sb.append(", examtime=").append(examtime);
        sb.append(", examstatus=").append(examstatus);
        sb.append(", studentid=").append(studentid);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}