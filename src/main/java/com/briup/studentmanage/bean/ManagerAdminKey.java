package com.briup.studentmanage.bean;

import java.io.Serializable;

public class ManagerAdminKey implements Serializable {
    private Integer managerid;

    private Integer adminid;

    private static final long serialVersionUID = 1L;

    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", managerid=").append(managerid);
        sb.append(", adminid=").append(adminid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}