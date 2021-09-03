package com.example.healthexpert;

public class ModelClassBlood {

    int imageviewofblood;
    String textName, bloodgroup, bloodemail;

    public ModelClassBlood() {
    }

    public ModelClassBlood(int imageviewofblood, String textName, String bloodgroup, String bloodemail) {
        this.imageviewofblood = imageviewofblood;
        this.textName = textName;
        this.bloodgroup = bloodgroup;
        this.bloodemail = bloodemail;
    }

    public int getImageviewofblood() {
        return imageviewofblood;
    }

    public String getTextName() {
        return textName;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public String getBloodemail() {
        return bloodemail;
    }
}
