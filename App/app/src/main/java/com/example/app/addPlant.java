package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addPlant extends AppCompatActivity {

    EditText nameInput;
    EditText bdayInput;
    EditText typeInput;
    Button createButton;
    DataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);

        // set and declare variables
        nameInput = findViewById(R.id.nameInput);
        bdayInput = findViewById(R.id.bdayInput);
        typeInput = findViewById(R.id.typeInput);

        createButton = findViewById(R.id.createPlant);

        db = new DataBase(this);

        //login button, store variables, check for existing accounts
        createButton.setOnClickListener(view -> {
            String name = nameInput.getText().toString().toLowerCase();
            String bday = bdayInput.getText().toString();
            String type = typeInput.getText().toString();

            Plant plant = new Plant(name, type, bday);

            db.addPlant(plant);

            Intent intent = new Intent(view.getContext(), MainActivity.class);
            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));
            intent.putExtra("NEW_USER", false);
            startActivity(intent);

        });
    }


}