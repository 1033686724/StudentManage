package com.briup.studentmanage.bean;

import java.util.Date;

public class MainStage {
    private String notice;
    private Date createTime;



    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
