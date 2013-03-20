package com.example.azteal;

import org.andengine.entity.scene.Scene;
import org.andengine.opengl.texture.region.TextureRegion;

import android.content.res.Resources;
import android.util.Log;

public class Map {

        final static int MAP_WITDH = MainActivity.CAMERA_WIDTH/32;
        final static int MAP_HEIGHT = (MainActivity.CAMERA_HEIGHT-96)/32;

        FloorObject[][] floor;
        
        public Map(Resources resource) {
                this.floor = new FloorObject[MAP_HEIGHT][MAP_WITDH];
      
                for(int i=0;i<MAP_HEIGHT;i++) {
                        for(int j=0;j<MAP_WITDH;j++) {
                                this.floor[i][j] = new FloorObject(new Location(j, i));
                        }
                }                       
        }
            

        public void Draw(TextureRegion pTextureRegion,Scene pScene) {
                for(int i=0;i<MAP_HEIGHT;i++) {
                        for(int j=0;j<MAP_WITDH;j++) {
                        	this.floor[i][j].CreateSprite(pTextureRegion);
                            this.floor[i][j].Draw(pScene);
                        }
                }
        }
        
        public void UpdateMap(Scene pScene, Player pPlayer){
                for(int i=0;i<MAP_HEIGHT;i++) {
                        for(int j=0;j<MAP_WITDH;j++) {
                                if(this.floor[i][j].isDestroyed()) {
                                        this.floor[i][j].Remove(pScene);
                                }
                        }               
                }
        }
}
