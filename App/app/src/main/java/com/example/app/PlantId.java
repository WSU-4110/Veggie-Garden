package com.example.app;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.GREEN;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.O)
public class PlantId extends View implements View.OnClickListener {

    // Hard-coded values for debug purposes
    private Color backgroundColor = Color.valueOf(GREEN);
    private Color textColor = Color.valueOf(BLACK);
    private String plantName;
    private String plantBirthday;
    private String outOrIn;
    private Paint textPaint;
    private Paint backgroundPaint;
    private LinearLayout plantLayout;
    private TextView name;
    private TextView type;
    private TextView bday;

    OnClickListener listener;

    // Constructor for PlantId
    // Will call init to create all drawable objects
    public PlantId(Context context) {
        super(context);
        init();

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(20, 20, 20, 50);
        this.setLayoutParams(params);
    }

    public PlantId(Context context, Plant plant) {
        super(context);
        init();

        this.plantName = plant.getName();
        this.plantBirthday = plant.getBday();
        this.outOrIn = plant.getType();

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(20, 20, 20, 50);
        this.setLayoutParams(params);

    }

    // Initializes drawable objects to increase performance
    private void init() {
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        // Only works in SDK v26 or above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            textPaint.setColor(textColor.pack());
        }
        textPaint.setTextSize(50);
        backgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        // Same deal as above; will probably upgrade build to v26
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            backgroundPaint.setColor(backgroundColor.pack());
        }
        backgroundPaint.setStyle(Paint.Style.STROKE);
        backgroundPaint.setTextSize(50);
    }

    // Called when first created and whenever screen size changes
    // Handles layout of PlantId view
    @Override
    public void onSizeChanged(int w, int h, int oldW, int oldH) {
        float xPad = (float) (getPaddingLeft() + getPaddingRight());
        float yPad = (float) (getPaddingBottom() + getPaddingTop());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(1400, 50);
    }

    // Called when displaying the PlantId
    // Handles drawing all elements from objects created in init()
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        @SuppressLint("DrawAllocation") Rect offsetView = new Rect();
        this.getDrawingRect(offsetView);

//        canvas.drawRect(offsetView.left, offsetView.top, 1400, offsetView.top+300, backgroundPaint);
        canvas.drawText(plantName, offsetView.left  + 50, offsetView.top+ 50, textPaint);
        canvas.drawText("Birthday: ", offsetView.left + 500, offsetView.top + 50, textPaint);
        canvas.drawText(outOrIn, offsetView.left + 1000, offsetView.top + 50, textPaint);
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

    public void setOnClickListener(OnClickListener listener) {
        if(!isClickable())
            setClickable(true);
        this.listener = listener;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        this.onClick(this);
        return true;
    }

    @Override
    public void onClick(View v) {
        if (listener != null)
            listener.onClick(v);
    }
}
