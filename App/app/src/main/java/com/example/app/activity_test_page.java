package com.example.app;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import it.fabiosassu.stackexpandableview.StackExpandableView;

public class activity_test_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_page);

        @IdRes int scrollViewID = View.generateViewId();

        StackExpandableView verticalStack = findViewById(R.id.verticalStack);
        ScrollView scrollView = findViewById(R.id.verticalScrollView);
        scrollView.setId(scrollViewID);

        ArrayList<TextView> viewList = new ArrayList<>();

//        for (int i = 0; i < 5; i++) {
//            final TextView textView = new TextView(this);
//
//            textView.setText("View ");
//            viewList.add(textView);
//        }

//        verticalStack.setWidgets(viewList);

        @IdRes int id = View.generateViewId();
        @IdRes int id2 = View.generateViewId();
        @IdRes int id3 = View.generateViewId();
        final TextView textView = new TextView(this);
        final TextView textView2 = new TextView(this);
        final TextView textView3 = new TextView(this);
        textView.setText("View");
        textView.setId(id);
        textView.setTextSize(30);
        textView2.setText("View");
        textView2.setId(id);
        textView.setTextSize(30);
        textView3.setText("View");
        textView3.setId(id);
        textView.setTextSize(30);
        verticalStack.addWidget(textView);
        verticalStack.addWidget(textView2);
        verticalStack.addWidget(textView3);

    }



}
