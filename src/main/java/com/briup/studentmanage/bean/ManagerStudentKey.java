package com.briup.studentmanage.bean;

import java.io.Serializable;

public class ManagerStudentKey implements Serializable {
    private Integer managerid;

    private Integer studentid;

    private static final long serialVersionUID = 1L;

    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", managerid=").append(managerid);
        sb.append(", studentid=").append(studentid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}