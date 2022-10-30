package com.example.app;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

// FOLLOW THIS FORMAT FOR CREATING VALUES/BUTTONS/MOVING PAGES/STORING DATA
public class Title_Page extends AppCompatActivity {

    //declare variables
    EditText loginEmail, loginPassword;
    Button loginButton, createAccountButton;
    DataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_page);

        //set variables
        loginEmail = findViewById(R.id.emailInput);
        loginPassword = findViewById(R.id.pwordInput);
        loginButton = findViewById(R.id.loginButton);
        createAccountButton = findViewById(R.id.createAccountButton);
        db = new DataBase(this);

        //login button, store variables, check for existing accounts
        loginButton.setOnClickListener(view -> {
            String email = loginEmail.getText().toString().toLowerCase();
            String password = loginPassword.getText().toString();

            if ((email.contains("@") || email.contains(".com") || email.contains(".net") || email.contains(".gov") ||
                    email.contains(".org")) && password.length() >= 3) {
                boolean checkEmailPass = db.checkEmailPassword(email, password);
                if (checkEmailPass) {
                    Toast.makeText(Title_Page.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    intent.putExtra("EMAIL", email);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Title_Page.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(Title_Page.this, "Invalid Entry", Toast.LENGTH_SHORT).show();
            }
        });

        //create account button, move pages
        createAccountButton.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), Create_Account_Page.class);
            startActivity(intent);
        });
    }

}