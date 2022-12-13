package com.example.app;

import junit.framework.TestCase;

public class VirtualGardenItemTest extends TestCase {

    public void testGetVeggieName() {
        String expected = "name";
        VirtualGardenItem i = new VirtualGardenItem("name", 0);
        expected = i.getVeggieName();
        assertEquals(expected, "name");
    }

    public void testGetVeggieImage() {
        int expected = 0;
        VirtualGardenItem i = new VirtualGardenItem("name", 0);
        int z = i.getVeggieImage();
        assertEquals(z, 0);
    }

    public void testSetVeggieListName() {
        String expected = "differentName";
        VirtualGardenItem i = new VirtualGardenItem("name", 0);
        i.setVeggieListName("differentName");
        String actual = i.getVeggieName();
        assertEquals(actual, expected);
    }

    public void testSetVeggieListImage() {
        int expected = 2;
        VirtualGardenItem i = new VirtualGardenItem("name", 0);
        i.setVeggieListImage(2);
        int actual = i.getVeggieImage();
        assertEquals(expected, actual);
    }
}