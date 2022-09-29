package com.example.app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_test_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_page);

        final TextView[] viewList = new TextView[5];

        for (int i = 0; i < 5; i++) {
            final TextView textView = new TextView(this);
            textView.setText("View " + i);
            viewList[i] = textView;
        }
    }



}
