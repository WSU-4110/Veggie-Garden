package com.example.app;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.WHITE;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class PlantId extends View {

    // Hard-coded values for debug purposes
    private Color backgroundColor = Color.valueOf(GREEN);
    private Color textColor = Color.valueOf(WHITE);
    private String plantName;
    private String plantBirthday;

    private Paint textPaint;
    private Paint backgroundPaint;

    // Constructor for PlantId
    // Will call init to create all drawable objects
    public PlantId(Context context) {
        super(context);
        init();
    }

    // Initializes drawable objects to increase performance
    private void init() {
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        // Only works in SDK v26 or above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            textPaint.setColor(textColor.pack());
        }

        backgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        // Same deal as above; will probably upgrade build to v26
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            backgroundPaint.setColor(backgroundColor.pack());
        }
        backgroundPaint.setStyle(Paint.Style.FILL);
    }

    // Called when first created and whenever screen size changes
    // Handles layout of PlantId view
    @Override
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        float xpad = (float) (getPaddingLeft() + getPaddingRight());
        float ypad = (float) (getPaddingBottom() + getPaddingTop());

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(50, 50, 50, 50);
        this.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));


    }

    // Called when displaying the PlantId
    // Handles drawing all elements from objects created in init()
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY()+200, backgroundPaint);

        
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;

        // Necessary for when these attributes are changed dynamically
        // Maybe create a new function refresh if needed ?
        invalidate();
        requestLayout();
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
        invalidate();
        requestLayout();
    }

    public String getPlantBirthday() {
        return plantBirthday;
    }

    public void setPlantBirthday(String plantBirthday) {
        this.plantBirthday = plantBirthday;
        invalidate();
        requestLayout();
    }

    public Color getTextColor() {
        return this.textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }
}
