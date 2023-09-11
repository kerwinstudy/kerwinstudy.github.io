package com.winmar.pojo;

import jdk.internal.cmm.SystemResourcePressureImpl;

public class Adm {
    private int id;
    private String adName;
    private String pwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Adm{" +
                "id=" + id +
                ", adName='" + adName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
