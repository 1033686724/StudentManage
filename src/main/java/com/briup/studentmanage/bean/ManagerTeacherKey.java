package com.briup.studentmanage.bean;

import java.io.Serializable;

public class ManagerTeacherKey implements Serializable {
    private Integer managerid;

    private Integer teacherid;

    private static final long serialVersionUID = 1L;

    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
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
        sb.append(", managerid=").append(managerid);
        sb.append(", teacherid=").append(teacherid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}