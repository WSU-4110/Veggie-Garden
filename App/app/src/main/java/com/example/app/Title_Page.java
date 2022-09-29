package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Title_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_page);
    }
// this gets a button press to move pages, add: android:onClick="moveToTitle" to xml file under the button's area, and add: tools:ignore="UsingOnClickInXml" to clear the error attached.
    public void moveToHome(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void moveToCreationPage(View v) {
        Intent intent = new Intent(this, Create_Account_Page.class);
        startActivity(intent);
    }

    EditText email = (EditText) findViewById(R.id.emailInput);
    EditText password = (EditText) findViewById(R.id.pwordInput);

    public void login(View v) {
        if (email.getText().toString().equals(possibleEmail) && password.getText().toString().equals(possiblePassword)) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else {
            System.out.println("Incorrect Login, Please Try Again.");
        }
    }
}