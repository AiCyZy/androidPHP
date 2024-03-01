package com.example.phptest.dto;

//data transfer objest
//model gửi đi khi dk

public class RegisterRequestDTO {
    private String email, password, name;


    public RegisterRequestDTO(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public RegisterRequestDTO() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
