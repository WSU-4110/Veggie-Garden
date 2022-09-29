package com.example.app;

public class LoginCredentials {
    private String email, password;

    //constructors

    public LoginCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginCredentials() {
    }

    //toString
    @Override
    public String toString() {
        return "LoginCredentials{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    //getters/setters

    public String getLoginEmail() {
        return email;
    }


    public void setLoginEmail(String email) {
        this.email = email;
    }


    public String getLoginPassword() {
        return password;
    }


    public void setLoginPassword(String password) {
        this.password = password;
    }
}
