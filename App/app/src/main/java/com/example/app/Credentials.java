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

    // toString
    @NonNull
    @Override
    public String toString() {
        return "Name: " + name
                + "\nEmail: " + email
                + "\nPassword: " + password;
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

}
