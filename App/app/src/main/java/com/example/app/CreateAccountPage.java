package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateAccountPage extends AppCompatActivity {

    // create variables
    EditText nameInput, createEmail, createPassword, confirmPassword;
    Button createButton, backButton;
    DataBase db;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    //recommended fix for error on line 30, use if needed, absolutely works
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_page);

        // declare variables
        nameInput = findViewById(R.id.nameInput);
        createEmail = findViewById(R.id.createEmail);
        createPassword = findViewById(R.id.createPword);
        confirmPassword = findViewById(R.id.confirmPword);
        createButton = findViewById(R.id.createButton);
        backButton = findViewById(R.id.backButton);
        db = new DataBase(this);

        //create button, store values
        createButton.setOnClickListener(view -> {
            String email = createEmail.getText().toString();
            String password = createPassword.getText().toString();
            String name = nameInput.getText().toString();
            String confirm = confirmPassword.getText().toString();

            if (name.length() >= 1 && (email.contains("@") || email.contains(".com") || email.contains(".net") || email.contains(".gov") ||       // check @, .com/gov/net/org and pword length
                    email.contains(".org")) && password.length() >= 3) {
                if (password.equals(confirm)) {                              // if pword same, advance
                    boolean checkAccount = db.checkEmail(email);              // check if email in use
                    if (!checkAccount) {
                        Credentials credentials = new Credentials(name, email, password);        // cross ref w credentials.java
                        boolean insert = db.addOne(credentials);                                 // add to cred.java
                        if (insert) {
                            Toast.makeText(CreateAccountPage.this, "Account Created", Toast.LENGTH_SHORT).show();   // toast msg, login, make new_user true, move to main
                            Intent intent = new Intent(view.getContext(), MainActivity.class);
                            intent.putExtra("EMAIL", email);
                            intent.putExtra("NEW_USER", true);
                            startActivity(intent);
                        } else {
                            Toast.makeText(CreateAccountPage.this, "Account Creation Failed", Toast.LENGTH_SHORT).show();       // error
                        }
                    } else {
                        Toast.makeText(CreateAccountPage.this, "User Already Exists", Toast.LENGTH_SHORT).show();           // error
                    }
                } else {
                    Toast.makeText(CreateAccountPage.this, "Passwords are not the same", Toast.LENGTH_SHORT).show();          // error
                }
            } else {
                Toast.makeText(CreateAccountPage.this, "Invalid Entries", Toast.LENGTH_SHORT).show();                      // error
            }
        });

        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), TitlePage.class);                           // go back
            intent.putExtra("NEW_USER", false);
            startActivity(intent);
        });
    }
}