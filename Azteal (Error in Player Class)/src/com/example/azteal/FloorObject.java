package com.example.azteal;

import com.example.azteal.BaseObject;
import com.example.azteal.Location;
import com.example.azteal.Size;

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
