package com.example.app;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;

import junit.framework.TestCase;

import java.util.ArrayList;

public class VirtualGardenItemAdapterTest extends TestCase {

    ArrayList<VirtualGardenItem> veggieList = new ArrayList<>();
    Context testContext;
    View viewTest = new View(testContext);

    public void testGetCount() {
        VirtualGardenItemAdapter adapter = new VirtualGardenItemAdapter(testContext, 0, veggieList);
        int count = adapter.getCount();
    }

    public void testGetView() {

    }
}