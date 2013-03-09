package com.AzTeal;

import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.util.color.Color;

import com.AzTeal.SManager.SceneType;

public class LoadScreen extends BaseScene {
	
	private Sprite load;

	@Override
	public void createScene() {
		
		setBackground(new Background(Color.BLACK));	
		load = new Sprite(0,0,resources.load_region,vbom);		        
		load.setScale(1.5f);									
		load.setPosition(cam.getCenterX()-RManager.BADGE_OFFSET,cam.getCenterY());
		attachChild(load);
		
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SceneType getSceneType() {
		
		return SceneType.SCENE_LOAD;
		
	}
	
	

}
