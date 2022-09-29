package com.example.app;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import it.fabiosassu.stackexpandableview.StackExpandableView;

public class activity_test_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_page);

        StackExpandableView verticalStack = findViewById(R.id.verticalStack);

        ArrayList<TextView> viewList = new ArrayList<>();

//        for (int i = 0; i < 5; i++) {
//            final TextView textView = new TextView(this);
//
//            textView.setText("View ");
//            viewList.add(textView);
//        }

        verticalStack.setWidgets(viewList);

    }



}
