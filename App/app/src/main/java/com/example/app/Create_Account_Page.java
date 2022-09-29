package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Create_Account_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_page);
    }

    public void moveToHome(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    EditText name = (EditText) findViewById(R.id.nameInput);
    EditText email = (EditText) findViewById(R.id.createEmail);
    EditText password = (EditText) findViewById(R.id.createPword);
    EditText confirmPassword = (EditText) findViewById(R.id.confirmPword);

    public EditText createAccount(View v) {
        if (name.length() >= 1 && email.length() <= 1 && password.length() <= 3 && confirmPassword == password) {

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else {
            System.out.println("Invalid");
        }
        return name;
    }
}