package com.briup.studentmanage.bean;

import java.io.Serializable;

public class StudentCustom implements Serializable {
    private Integer id;

    private Double customnum;

    private String customtext;

    private Integer studentid;

    private Integer teacherid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCustomnum() {
        return customnum;
    }

    public void setCustomnum(Double customnum) {
        this.customnum = customnum;
    }

    public String getCustomtext() {
        return customtext;
    }

    public void setCustomtext(String customtext) {
        this.customtext = customtext == null ? null : customtext.trim();
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", customnum=").append(customnum);
        sb.append(", customtext=").append(customtext);
        sb.append(", studentid=").append(studentid);
        sb.append(", teacherid=").append(teacherid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}