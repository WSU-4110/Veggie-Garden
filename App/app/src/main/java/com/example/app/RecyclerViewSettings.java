package com.example.app;

public class RecyclerViewSettings {
    String cardText;
    int cardArrow;             // declarations

    // constructor
    public RecyclerViewSettings(String cardText, int cardArrow) {
        this.cardText = cardText;
        this.cardArrow = cardArrow;
    }

    // getters
    public String getCardText() {
        return cardText;
    }

    public int getCardArrow() {
        return cardArrow;
    }
}
