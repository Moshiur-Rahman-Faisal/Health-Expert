package com.example.healthexpert;

public class ModelClass {

    String img, blood, email, username;

    public ModelClass() {
    }

    public ModelClass(String img, String blood, String email, String username) {
        this.img = img;
        this.blood = blood;
        this.email = email;
        this.username = username;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
