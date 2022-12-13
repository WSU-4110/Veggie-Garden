package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

/**
 * This class controls the Edit screen for the Virtual Garden and is accessed through the Virtual
 * Garden screen only, then sends the user back to the Virtual Garden screen when they are
 * done making changes and click the button labeled Done.
 */
public class EditVirtualGarden extends AppCompatActivity {
    Button doneButton;
    String[] vgEditorSelectionResults = new String[8]; //String array to pass results to the Virtual Garden class


    @SuppressLint("MissingInflatedId")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_vg);

        //Dropdown menus
        final Spinner selector1 = findViewById(R.id.selector1_vg);
        final Spinner selector2 = findViewById(R.id.selector2_vg);
        final Spinner selector3 = findViewById(R.id.selector3_vg);
        final Spinner selector4 = findViewById(R.id.selector4_vg);
        final Spinner selector5 = findViewById(R.id.selector5_vg);
        final Spinner selector6 = findViewById(R.id.selector6_vg);
        final Spinner selector7 = findViewById(R.id.selector7_vg);
        final Spinner selector8 = findViewById(R.id.selector8_vg);

        // set array adapters
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.virtualGardenPlantList, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        selector1.setAdapter(adapter);
        selector2.setAdapter(adapter);
        selector3.setAdapter(adapter);
        selector4.setAdapter(adapter);
        selector5.setAdapter(adapter);
        selector6.setAdapter(adapter);
        selector7.setAdapter(adapter);
        selector8.setAdapter(adapter);

        //Convert selected veggies to string

        TextView textView1 = (TextView)selector1.getSelectedView();
        String result1 = textView1.getText().toString();
        TextView textView2 = (TextView)selector1.getSelectedView();
        String result2 = textView2.getText().toString();
        TextView textView3 = (TextView)selector1.getSelectedView();
        String result3 = textView3.getText().toString();
        TextView textView4 = (TextView)selector1.getSelectedView();
        String result4 = textView4.getText().toString();
        TextView textView5 = (TextView)selector1.getSelectedView();
        String result5 = textView5.getText().toString();
        TextView textView6 = (TextView)selector1.getSelectedView();
        String result6 = textView6.getText().toString();
        TextView textView7 = (TextView)selector1.getSelectedView();
        String result7 = textView7.getText().toString();
        TextView textView8 = (TextView)selector1.getSelectedView();
        String result8 = textView8.getText().toString();

        //Save dropdown box results into the array
        vgEditorSelectionResults[0] = result1;
        vgEditorSelectionResults[1] = result2;
        vgEditorSelectionResults[2] = result3;
        vgEditorSelectionResults[3] = result4;
        vgEditorSelectionResults[4] = result5;
        vgEditorSelectionResults[5] = result6;
        vgEditorSelectionResults[6] = result7;
        vgEditorSelectionResults[7] = result8;

        //done button goes back to the Virtual Garden and saves your changes made to it
        doneButton = findViewById(R.id.done_editing_vg_button);
        doneButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, VirtualGarden.class);
            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));   // stays logged in
            intent.putExtra("NEW_USER", false);                              // makes sure popup doesn't re-appear
            startActivity(intent);
        });
    }
}
