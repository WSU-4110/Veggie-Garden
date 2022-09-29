package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Create_Account_Page extends AppCompatActivity {

    //declare variables
    EditText nameInput, createEmail, createPassword, confirmPassword;
    Button createButton;

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

        //create button, store values
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nameInput.getText().toString().length() >= 1 && createEmail.getText().toString().contains("@") && createEmail.getText().toString().contains(".com") &&
                        createEmail.getText().toString().length() >= 1 && createPassword.getText().toString().length() >= 1) {
                    if (createPassword.getText().toString().equals(confirmPassword.getText().toString()) ) {
                        Credentials userLogin = new Credentials(nameInput.getText().toString(), createEmail.getText().toString(), createPassword.getText().toString(),
                                confirmPassword.getText().toString());
                        Toast.makeText(Create_Account_Page.this, "Account Created", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(view.getContext(), MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(Create_Account_Page.this, "Passwords are not the same", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(Create_Account_Page.this, "Invalid Entries", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}