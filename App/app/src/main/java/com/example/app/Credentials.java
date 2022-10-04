package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Credentials extends AppCompatActivity {

    private String name;
    private String email;
    private String password;

    //constructors

    public Credentials(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Credentials() {
    }

    // toString
    @NonNull
    @Override
    public String toString() {
        return "com.example.app.Credentials{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // getters/setters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
