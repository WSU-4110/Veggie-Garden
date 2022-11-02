package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Credentials extends AppCompatActivity {

    // set vars
    private String name;
    private String email;
    private String password;

    // constructor
    private Credentials(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    private static class CredentialsHolder {
        public static final Credentials instance = new Credentials();
    }

    public static Credentials getInstance() {
        return CredentialsHolder.instance;
    }

    // toString
    @NonNull
    @Override
    public String toString() {
        return "Name: " + name
                + "\nEmail: " + email
                + "\nPassword: " + password;
    }

    // getters
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
