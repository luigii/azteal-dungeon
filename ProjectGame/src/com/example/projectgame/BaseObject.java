package com.example.projectgame;

public abstract class BaseObject {

    Location location;
    Size size;
    Sprite sprite;

    /**
     * @param location
     */
    public BaseObject(Location location,Size size) {
            this.location = location;
            this.size = size;
    }

    /**
     * @param pTextureRegion - Pointer to the texture region to draw the sprite from.
     */

    public void CreateSprite(TextureRegion pTextureRegion) {
            sprite = new Sprite(this.location.getPosX()*32, this.location.getPosY()*32, pTextureRegion);               
    }

	/**
     * @param pScene - Pointer to the scene where to draw the sprite
     */

    public void Draw(Scene pScene) {
            pScene.attachChild(this.sprite);
    }
    /**
     * @param pScene - Pointer to the scene where to remove the sprite
     */
    public void Remove(Scene pScene) {
            pScene.detachChild(this.sprite);
    }
}
