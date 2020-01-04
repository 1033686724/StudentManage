package com.briup.studentmanage.bean.ex;

import java.io.Serializable;

public class StudentEX implements Serializable {
    private String cName;

    private String tName;

    private String claName;

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getClaName() {
        return claName;
    }

    public void setClaName(String claName) {
        this.claName = claName;
    }
}
