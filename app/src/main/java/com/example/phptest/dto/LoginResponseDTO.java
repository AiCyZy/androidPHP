package com.example.phptest.dto;

public class LoginResponseDTO {
    private  boolean status;
    private  String message;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
