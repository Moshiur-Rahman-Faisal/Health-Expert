package com.example.healthexpert;

public class UserProfileInfo {
    String username, email, phone, Img_url, blood;

    public  UserProfileInfo(){

    }

    public UserProfileInfo(String username, String email, String phone, String img_url, String blood) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.Img_url = img_url;
        this.blood = blood;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImg_url() {
        return Img_url;
    }

    public void setImg_url(String img_url) {
        this.Img_url = img_url;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }
}
