package com.example.app;
import android.widget.ImageView;

public class RecyclerViewSettings {
    String cardText;
    ImageView cardArrow;             // declarations

    // constructor
    public RecyclerViewSettings(String cardText, ImageView cardArrow) {
        this.cardText = cardText;
        this.cardArrow = cardArrow;
    }

    // getters
    public String getCardText() {
        return cardText;
    }

    public ImageView getCardArrow() {
        return cardArrow;
    }
}
