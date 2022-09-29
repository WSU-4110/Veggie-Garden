package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Title_Page extends AppCompatActivity {

    EditText email;
    EditText password;
    Button loginButton, createAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_page);

        email = findViewById(R.id.emailInput);
        password = findViewById(R.id.pwordInput);
        loginButton = findViewById(R.id.loginButton);
        createAccountButton = findViewById(R.id.createAccountButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().contains("@") && email.getText().toString().contains(".com") && email.getText().toString().length() >= 1 &&
                        password.getText().toString().length() >= 1) {
                    LoginCredentials userLogin = new LoginCredentials(email.getText().toString(), password.getText().toString());
                    Toast.makeText(Title_Page.this, "Logged In", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Title_Page.this, "Invalid Entry", Toast.LENGTH_SHORT).show();
                }
            }
        });

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Create_Account_Page.class);
                startActivity(intent);
            }
        });
    }

}