package com.Team4.project.entity.request;

public class SignUpRequest {

    private String user_name;

    private String email;

    private String password;

    private String role;

    private String mobile;

    private String address;

    public SignUpRequest() {
    }

    public SignUpRequest(String user_name, String email, String password, String role, String mobile, String address) {
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.mobile = mobile;
        this.address = address;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
