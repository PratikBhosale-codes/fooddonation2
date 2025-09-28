package com.example.fooddonation;

public class UserModel {
    public String name;
    public String mobile;
    public String email;

    // Empty constructor required for Firebase
    public UserModel() {}

    public UserModel(String name, String mobile, String email){
        this.name = name;
        this.mobile = mobile;
        this.email = email;
    }
}
