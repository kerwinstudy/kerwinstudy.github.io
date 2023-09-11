package com.winmar.pojo;

public class Data {
    private String Site;
    private String Dimension;
    private String longitude;
    private int altitude;
    private int year;
    private int month;
    private int day;
    private int pre1;
    private int pre2;
    private int pre3;
    private int pre4;

    @Override
    public String toString() {
        return "Data{" +
                "Site='" + Site + '\'' +
                ", Dimension='" + Dimension + '\'' +
                ", longitude='" + longitude + '\'' +
                ", altitude=" + altitude +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", pre1=" + pre1 +
                ", pre2=" + pre2 +
                ", pre3=" + pre3 +
                ", pre4=" + pre4 +
                '}';
    }

    public String getSite() {
        return Site;
    }

    public void setSite(String site) {
        Site = site;
    }

    public String getDimension() {
        return Dimension;
    }

    public void setDimension(String dimension) {
        Dimension = dimension;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getPre1() {
        return pre1;
    }

    public void setPre1(int pre1) {
        this.pre1 = pre1;
    }

    public int getPre2() {
        return pre2;
    }

    public void setPre2(int pre2) {
        this.pre2 = pre2;
    }

    public int getPre3() {
        return pre3;
    }

    public void setPre3(int pre3) {
        this.pre3 = pre3;
    }

    public int getPre4() {
        return pre4;
    }

    public void setPre4(int pre4) {
        this.pre4 = pre4;
    }
}
