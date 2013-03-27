package com.AzTeal;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;
import org.andengine.engine.camera.Camera;

import com.AzTeal.SManager.SceneType;

public class Splash extends BaseScene {
	
	private Sprite splash;
	
	
	@Override
	public void createScene() {
		
		splash = new Sprite(0,0,resources.splash_region,vbom);		        
		splash.setScale(1.5f);
		splash.setPosition(cam.getCenterX()-RManager.BADGE_OFFSET,cam.getCenterY()-RManager.BADGE_OFFSET);
		attachChild(splash);
		
	}

	@Override
	public void disposeScene() {
		
		splash.detachSelf();
	    splash.dispose();
	    this.detachSelf();
	    this.dispose();
		
	}

	@Override
	public SceneType getSceneType() {
		
		return SceneType.SCENE_SPLASH;
		
	}
	
	
	
}
