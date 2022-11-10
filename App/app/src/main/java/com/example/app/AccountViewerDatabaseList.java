package com.example.app;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class AccountViewerDatabaseList extends AppCompatActivity {

    //declare variables
    Button backToSettings;
    ListView lv_credentials;
    DataBase db;
    ArrayAdapter<Credentials> arrayAdapter;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_viewer_database_list);

        db = new DataBase(this);
        ShowListView(db);

        //set variables
        backToSettings = findViewById(R.id.backToSettings);
        lv_credentials = findViewById(R.id.lv_credentials);

        backToSettings.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), Settings.class);
            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));
            startActivity(intent);
        });
    }

   private void ShowListView(DataBase db) {
        arrayAdapter = new ArrayAdapter<>(AccountViewerDatabaseList.this, android.R.layout.simple_list_item_1, db.getAll());
        lv_credentials.setAdapter(arrayAdapter);
    }
}