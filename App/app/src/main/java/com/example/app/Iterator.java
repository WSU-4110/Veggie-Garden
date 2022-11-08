package com.example.app;

public interface Iterator {
    boolean hasNext();
    boolean hasPrev();

    Object next();
    Object previous();
}
