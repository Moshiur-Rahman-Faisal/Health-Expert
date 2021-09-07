package com.example.healthexpert;

public class ModelClassDoctor {

    private int imageview;
    private String name;
    private String qualification;
    private String times1;
    private String times2;
    private String times3;


    public ModelClassDoctor() {
    }

    public ModelClassDoctor(int imageview, String name, String qualification, String times1, String times2, String times3) {
        this.imageview = imageview;
        this.name = name;
        this.qualification = qualification;
        this.times1 = times1;
        this.times2 = times2;
        this.times3 = times3;
    }


    public int getImageview() {
        return imageview;
    }

    public void setImageview(int imageview) {
        this.imageview = imageview;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getTimes1() {
        return times1;
    }

    public void setTimes1(String times1) {
        this.times1 = times1;
    }

    public String getTimes2() {
        return times2;
    }

    public void setTimes2(String times2) {
        this.times2 = times2;
    }

    public String getTimes3() {
        return times3;
    }

    public void setTimes3(String times3) {
        this.times3 = times3;
    }
}
