package com.Team4.project.entity.response;

public class JwtResponse {

    private int id;

    private String user_name;

    private  String password;

    private String role;

    private String jwt;

    public JwtResponse() {
    }

    public JwtResponse(int id, String user_name, String password, String role, String jwt) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.role = role;
        this.jwt = jwt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
