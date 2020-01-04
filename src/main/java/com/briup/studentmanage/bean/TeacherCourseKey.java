package com.briup.studentmanage.bean;

import java.io.Serializable;

public class TeacherCourseKey implements Serializable {
    private Integer teacherid;

    private Integer courseid;

    private static final long serialVersionUID = 1L;

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", teacherid=").append(teacherid);
        sb.append(", courseid=").append(courseid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}