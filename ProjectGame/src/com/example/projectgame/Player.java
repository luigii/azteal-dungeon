package com.example.projectgame;

import java.util.Random;

import org.andengine.entity.scene.Scene;

import android.util.Log;

@SuppressWarnings("unused")
public class Player extends BaseObject {
        
        public Player(Location location) {
                super(location,new Size(32,32));
        }

        private void UpdatePosition(Location newLoc, Map pMap, Scene pScene) {
                try{
                        if(pMap.floor[newLoc.getPosY()][newLoc.getPosX()].isDestroyed()){
                                pMap.floor[newLoc.getPosY()][newLoc.getPosX()].setDestroyed(true);
                        }
                }catch (Exception e) {

                }
                this.sprite.setPosition(this.location.getPosX()*32,this.location.getPosY()*32);
        }

        public boolean Move(int Direction, Map pMap, Scene pScene) {
                switch (Direction) {
                        case 1:
                                this.UpdatePosition(new Location(this.location.getPosX()-1,this.location.getPosY()), pMap, pScene);
                                return true;
                        case 2:
                                this.UpdatePosition(new Location(this.location.getPosX(),this.location.getPosY()-1), pMap, pScene);
                                return true;            
                                case 3:
                                this.UpdatePosition(new Location(this.location.getPosX(),this.location.getPosY()+1), pMap, pScene);
                                return true;
                        case 4:
                                this.UpdatePosition(new Location(this.location.getPosX()+1,this.location.getPosY()), pMap, pScene);
                                return true;
                        }
                return false;
        }
}
