package com.example.androidproject;

public class UserDetails {

    private  String Name;
    private  String Phone;
    private  String Image;

    public UserDetails() {
    }

    public UserDetails(String name, String phone, String image) {
        Name = name;
        Phone = phone;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
