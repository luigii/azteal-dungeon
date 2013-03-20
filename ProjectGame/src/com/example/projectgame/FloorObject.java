package com.example.projectgame;

import com.example.projectgame.BaseObject;
import com.example.projectgame.Location;
import com.example.projectgame.Size;

public class FloorObject extends BaseObject {

    private boolean isDestroyed;

    /**
     * @param location
     * @param size
     */
    public FloorObject(Location location) {
            super(location, new Size(32,32));
            this.isDestroyed = false;
    }

    public boolean isDestroyed() {
            return isDestroyed;
    }
    
    public void setDestroyed(boolean isDestroyed) {
            this.isDestroyed = isDestroyed;
    }
}
