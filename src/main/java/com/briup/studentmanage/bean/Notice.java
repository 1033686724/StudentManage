package com.briup.studentmanage.bean;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable {
    private Integer id;

    private String notice;

    private Date createtime;

    private Short state;

    private Short rose;

    private Integer adminid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice == null ? null : notice.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public Short getRose() {
        return rose;
    }

    public void setRose(Short rose) {
        this.rose = rose;
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
        sb.append(", id=").append(id);
        sb.append(", notice=").append(notice);
        sb.append(", createtime=").append(createtime);
        sb.append(", state=").append(state);
        sb.append(", rose=").append(rose);
        sb.append(", adminid=").append(adminid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}