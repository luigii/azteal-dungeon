package com.example.azteal;

public class Location {

    private int posX;
    private int posY;

    /**
     * @param posX
     * @param posY
     */
    public Location(int posX, int posY) {
            super();
            this.posX = posX;
            this.posY = posY;
    }

    /**
     * @return the posX
     */
    public int getPosX() {
            return posX;
    }
    /**
     * @param posX the posX to set
     */
    public void setPosX(int posX) {
            this.posX = posX;
    }
    /**
     * @return the posY
     */
    public int getPosY() {
            return posY;
    }
    /**
     * @param posY the posY to set
     */
    public void setPosY(int posY) {
            this.posY = posY;
    }
    
}
