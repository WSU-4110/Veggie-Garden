package com.example.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class VirtualGardenItemAdapter extends ArrayAdapter {
    ArrayList<VirtualGardenItem> veggieList = new ArrayList<VirtualGardenItem>();

    public VirtualGardenItemAdapter(Context context, int textViewResourceID, ArrayList objects) {
        super(context, textViewResourceID, objects);
        veggieList = objects;
    }
    @Override
    public int getCount(){
        return super.getCount();
    }
    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.virtual_garden_item, null);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
        textView.setText(veggieList.get(position).getVeggieName());
        imageView.setImageResource(veggieList.get(position).getVeggieImage());
        return v;
    }

}
