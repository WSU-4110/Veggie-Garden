package com.example.app;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

// FOLLOW THIS FORMAT FOR CREATING VALUES/BUTTONS/MOVING PAGES/STORING DATA
public class TitlePage extends AppCompatActivity {

    // create variables
    EditText loginEmail, loginPassword;
    Button loginButton, createAccountButton;
    DataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_page);

        // set and declare variables
        loginEmail = findViewById(R.id.emailInput);
        loginPassword = findViewById(R.id.pwordInput);
        loginButton = findViewById(R.id.loginButton);
        createAccountButton = findViewById(R.id.createAccountButton);
        db = new DataBase(this);                              // set database var

        //login button, store variables, check for existing accounts
        loginButton.setOnClickListener(view -> {
            String email = loginEmail.getText().toString().toLowerCase();
            String password = loginPassword.getText().toString();                   // simplify

            if ((email.contains("@") || email.contains(".com") || email.contains(".net") || email.contains(".gov") ||               // check for @, .com/net/gov/org in emails
                    email.contains(".org")) && password.length() >= 3) {
                boolean checkEmailPass = db.checkEmailPassword(email, password);                  // cross check password and confirm password
                if (checkEmailPass) {
                    Toast.makeText(TitlePage.this, "Login Successful", Toast.LENGTH_SHORT).show();        // if it works, toast msg, login, don't display popup, move to main page
                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    intent.putExtra("EMAIL", email);
                    intent.putExtra("NEW_USER", false);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(TitlePage.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();         // error toast
                }
            }
            else {
                Toast.makeText(TitlePage.this, "Invalid Entry", Toast.LENGTH_SHORT).show();        // error toast
            }
        });

        //create account button, move pages
        createAccountButton.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), CreateAccountPage.class);
            startActivity(intent);
        });
    }

}