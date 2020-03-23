package com.taxibooking.ui.register.resister_model;

public class RegisterModel {
    private String name;
    private String email;
    private String password;
    private String repeatr_password;

    public RegisterModel() {
    }

    public RegisterModel(String name, String email, String password, String repeatr_password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.repeatr_password = repeatr_password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeatr_password() {
        return repeatr_password;
    }
}
