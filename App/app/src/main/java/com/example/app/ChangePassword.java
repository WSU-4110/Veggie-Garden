package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassword extends Credentials {

    // set variables
    Button backToSettings, saveBtn;
    EditText oldPword, newPword, confirmNewPword;
    DataBase db;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        // declare variables
        backToSettings = findViewById(R.id.backToSettings);
        saveBtn = findViewById(R.id.confirmNewPword);
        oldPword = findViewById(R.id.oldPwordText);
        newPword = findViewById(R.id.newPwordText);
        confirmNewPword = findViewById(R.id.confirmNewPwordText);
        db = new DataBase(this);

        backToSettings.setOnClickListener(view -> {
            Intent intent = new Intent(this, Settings.class);               // back to settings page
            startActivity(intent);
        });

        saveBtn.setOnClickListener(view -> {
            String old = oldPword.getText().toString();
            String newP = newPword.getText().toString();
            String confirmP = confirmNewPword.getText().toString();
            boolean sameOldPw = db.checkPassword(old);

            if (sameOldPw) {
                if (!old.equals(newP)) {
                    if (newP.equals(confirmP) && newP.length() >= 3) {
                        db.updatePassword(getIntent().getStringExtra("EMAIL"), newP);
                        Toast.makeText(this, "New Password Saved!", Toast.LENGTH_SHORT).show();       // success!
                        Intent intent = new Intent(this, Settings.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(this, "Passwords must match", Toast.LENGTH_SHORT).show();       // error
                    }
                } else {
                    Toast.makeText(this, "New password cannot be the same as current", Toast.LENGTH_SHORT).show();       // error
                }
            } else {
                Toast.makeText(this, "Incorrect entry for current password", Toast.LENGTH_SHORT).show();       // error
            }
        });
    }


}