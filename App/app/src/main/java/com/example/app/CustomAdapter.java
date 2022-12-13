package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * This class is no longer used in current version of the app
 */
public class CustomAdapter extends BaseAdapter {
    Context context;
    int[] veggiePictures;
    LayoutInflater inflater;
    public CustomAdapter(Context applicationContext, int[] veggiePictures){
        this.context = applicationContext;
        this.veggiePictures = veggiePictures;
        inflater =(LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return veggiePictures.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    /**
     * This method is commented out because the class is no longer used
     * @param i
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //view = inflater.inflate(R.layout.activity_edit_vg, null); // inflate the layout
        //ImageView icon = (ImageView) view.findViewById(R.id.icon); // get the reference of ImageView
        //icon.setImageResource(veggiePictures[i]); // set images
        return view;
    }
}
