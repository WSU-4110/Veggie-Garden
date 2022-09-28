package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Title_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_page);
    }
// this gets a button press to move pages, add: android:onClick="moveToTitle" to xml file under the button's area, and add: tools:ignore="UsingOnClickInXml" to clear the error attached.
    public void moveToHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void moveToCreationPage(View view) {
        Intent intent = new Intent(this, Create_Account_Page.class);
        startActivity(intent);
    }
}