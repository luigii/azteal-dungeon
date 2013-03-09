package com.AzTeal;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.HorizontalAlign;
import org.andengine.util.color.Color;

import android.util.Log;
import android.view.MotionEvent;

import com.AzTeal.SManager.SceneType;
import com.AzTeal.BaseScene;

public class GameScene extends BaseScene {
	
	private HUD gameHUD;
	private Text health;
	private int hp = 100;
	
	private Sprite controller;
	private Sprite player;
	private Player hero;
	
	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		
		player = new Sprite(0,0,resources.player_region,vbom);
		hero = new Player(player,cam.getCenterX(),cam.getCenterY());
		attachChild(hero.player);
		createBackground();
	    createHUD();
		
	}
	
	@Override
    public boolean onSceneTouchEvent(TouchEvent touchEvent) {
        MotionEvent event = touchEvent.getMotionEvent();
        float x = event.getX();
        float y = event.getY();
        
        //Log.d("upd","x: " + x + " y: " + y);
        
        if((x > 130 && x < 270) && (y > 480 && y < 540) && touchEvent.isActionDown()){
 
        	hero.move(1);
        	
        }
        
        if((x > 230 && x < 320) && (y > 570 && y < 650) && touchEvent.isActionDown()){
        	
        	hero.move(3);
        	
        }
        
        if((x > 70 && x < 170) && (y > 570 && y < 650) && touchEvent.isActionDown()){
        	
        	hero.move(4);
        	
        }
        
        if((x > 130 && x < 270) && (y > 680 && y < 735) && touchEvent.isActionDown()){
        	
        	hero.move(2);
        	
        }
        
        return true;
    }

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void createBackground()
	{
	    setBackground(new Background(Color.BLACK));
	}

	private void createHUD()
	{
	    gameHUD = new HUD();
	    
	    controller = new Sprite(0,0,resources.control_region,vbom);
		controller.setScale(2f);
		controller.setPosition(resources.CONTROLLER_OFFSET,(float) (cam.getHeight()-(resources.CONTROLLER_OFFSET * 1.5)));
		gameHUD.attachChild(controller);
	    
	    health = new Text(0, 0, resources.font, "Health: 0123456789", new TextOptions(HorizontalAlign.LEFT), vbom);
	    health.setSkewCenter(0, 0);    
	    health.setText("HP: 100");
	    gameHUD.attachChild(health);
	    
	    cam.setHUD(gameHUD);
	}

	private void hpUp(int i){
		
	    hp += i;
	    health.setText("HP: " + hp);
	}
	
	private void damage(int i){
		
		hp -= i;
		health.setText("HP: " + hp);
	}
	
	

}
