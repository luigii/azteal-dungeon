package com.example.projectgame;

public class Size {

    private int Width;
    private int Height;

    /**
     * @param width
     * @param height
     */
    public Size(int width, int height) {
            Width = width;
            Height = height;
    }

    /**
     * @return the width
     */
    public int getWidth() {
            return Width;
    }
    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
            Width = width;
    }
    /**
     * @return the height
     */
    public int getHeight() {
            return Height;
    }
    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
            Height = height;
    }
}

