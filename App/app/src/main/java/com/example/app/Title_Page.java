package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
                                                                               // FOLLOW THIS FORMAT FOR CREATING VALUES/BUTTONS/MOVING PAGES/STORING DATA
public class Title_Page extends AppCompatActivity {

    //declare variables
    EditText email;
    EditText password;
    Button loginButton, createAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_page);

        //set variables
        email = findViewById(R.id.emailInput);
        password = findViewById(R.id.pwordInput);
        loginButton = findViewById(R.id.loginButton);
        createAccountButton = findViewById(R.id.createAccountButton);

        //login button, store variables, check for existing accounts
        loginButton.setOnClickListener(new View.OnClickListener() {                                  //IGNORE ANDROID STUDIO'S RECOMMENDATION TO SWITCH TO LAMBDA
            @Override
            public void onClick(View view) {
                if (email.getText().toString().contains("@") && email.getText().toString().contains(".com") && email.getText().toString().length() >= 1 &&
                        password.getText().toString().length() >= 1) {


                    Toast.makeText(Title_Page.this, "Logged In", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Title_Page.this, "Invalid Entry", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //create account button, move pages
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Create_Account_Page.class);
                startActivity(intent);
            }
        });
    }

}