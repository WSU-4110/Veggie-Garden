package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

public class VirtualGardenItem extends AppCompatActivity {
    String veggieListName;
    int veggieListImage;

    public VirtualGardenItem(String veggieListName, int veggieListImage) {
        this.veggieListName = veggieListName;
        this.veggieListImage = veggieListImage;
    }

    public String getVeggieName() {
        return veggieListName;
    }

    public int getVeggieImage() {
        return veggieListImage;
    }

    public void setVeggieListName(String updatedVeggieType) {
        veggieListName = updatedVeggieType;
    }

    public void setVeggieListImage(int arrayPositionOfNewImage) {
        veggieListImage = arrayPositionOfNewImage;
    }

}
