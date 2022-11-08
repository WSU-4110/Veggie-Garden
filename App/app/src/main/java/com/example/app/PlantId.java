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

import com.example.app.Iterator;
import com.example.app.Collection;

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

        // Same deal as above; will probably u pgrade build to v26
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            backgroundPaint.setColor(backgroundColor.pack());
        }
        backgroundPaint.setStyle(Paint.Style.STROKE);
        backgroundPaint.setTextSize(50);
    }

    // Called when first created and whenever screen size changes
    // Handles internal layout of PlantId view
    @Override
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        float xpad = (float) (getPaddingLeft() + getPaddingRight());
        float ypad = (float) (getPaddingBottom() + getPaddingTop());
    }

    // Called whenver drawn
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(1600, 50);
    }

    // Called when displaying the PlantId
    // Handles drawing all elements from objects created in init()
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(this.getX(), this.getY(), 1400, this.getY()+200, backgroundPaint);
        canvas.drawText(plantName, this.getX()+ 50, this.getY()+50, textPaint);
        canvas.drawText("Birthday: ", this.getX() + 50, this.getY() + 100, textPaint);
        
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

// Container class for plants
class PlantList implements Collection {
    int maxPlants;
    int count;
    PlantId[] plants;

    public PlantList() {
        plants = new PlantId[50];

    }

    public void addPlant(PlantId newPlant) {
        if(count >= maxPlants) {
            // Notify user they have too many plants
            return;
        }

        plants[count] = newPlant;
        count = count + 1;

    }

    public void removePlant(int pos) {
        if(pos >= count) {
            // Notify user index out of bounds
            return;
        }

        for (int i = pos; i < count - 1; i++) {
            plants[pos] = plants[pos + 1];
        }

        count = count - 1;
    }

    public PlantId getPlant(int pos) {
        if (pos >= count) {
            return null;
        }

        return plants[pos];
    }

    @Override
    public Iterator createIterator(int pos) {
        return new PlantIterator(this, pos);
    }
}

// Handles iterations over the plantList class
class PlantIterator implements Iterator{
    PlantList plants;
    int pos;

    public PlantIterator(PlantList plantList, int position) {
        plants = plantList;
        pos = position;
    }

    @Override
    public boolean hasNext() {
        if(pos >= plants.count)
            return false;

        return true;
    }

    @Override
    public boolean hasPrev() {
        if (pos < 0)
            return false;

        return true;
    }

    @Override
    public PlantId next() {
        if (!hasNext()) {
            return null;
        }

        PlantId plant = plants.getPlant(pos);
        pos++;
        return plant;
    }

    @Override
    public PlantId previous() {
        if (!hasPrev()) {
            return null;
        }

        PlantId plant = plants.getPlant(pos);
        pos--;
        return plant;
    }

}
