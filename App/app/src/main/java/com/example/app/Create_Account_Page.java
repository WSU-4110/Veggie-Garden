package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Create_Account_Page extends AppCompatActivity {

    //declare variables
    EditText nameInput, createEmail, createPassword, confirmPassword;
    Button createButton;
    DataBase db;

    @SuppressLint("MissingInflatedId")        //recommended fix for error on line 30, use if needed, absolutely works
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_page);

        //set variables
        nameInput = findViewById(R.id.nameInput);
        createEmail = findViewById(R.id.createEmail);
        createPassword = findViewById(R.id.createPword);
        confirmPassword = findViewById(R.id.confirmPword);
        createButton = findViewById(R.id.createButton);
        db = new DataBase(this);

        //create button, store values
        createButton.setOnClickListener(view -> {
            String email = createEmail.getText().toString();
            String password = createPassword.getText().toString();
            String name = nameInput.getText().toString();
            String confirm = confirmPassword.getText().toString();

            if (name.length() >= 1 && (email.contains("@") || email.contains(".com") || email.contains(".net") || email.contains(".gov") ||
                    email.contains(".org")) && password.length() >= 3) {
                if (password.equals(confirm) ) {
                    boolean checkAccount = db.checkEmail(email);
                    if (checkAccount == false) {
                        Credentials credentials = new Credentials(name, email, password, confirm);
                        boolean insert = db.addOne(credentials);
                        if (insert == true) {
                            Toast.makeText(Create_Account_Page.this, "Account Created", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(view.getContext(), MainActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(Create_Account_Page.this, "Account Creation Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(Create_Account_Page.this, "User Already Exists", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(Create_Account_Page.this, "Passwords are not the same", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(Create_Account_Page.this, "Invalid Entries", Toast.LENGTH_SHORT).show();
            }
        });
    }

}