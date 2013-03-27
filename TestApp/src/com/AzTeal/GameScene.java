package com.AzTeal;

import javax.microedition.khronos.opengles.GL10;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.engine.camera.hud.controls.AnalogOnScreenControl;
import org.andengine.engine.camera.hud.controls.AnalogOnScreenControl.IAnalogOnScreenControlListener;
import org.andengine.engine.camera.hud.controls.BaseOnScreenControl;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.util.HorizontalAlign;

import android.util.Log;

import com.AzTeal.SManager.SceneType;
import com.AzTeal.BaseScene;

public class GameScene extends BaseScene {

	private HUD gameHUD;
	private Text health;
	private int hp = 100;

	private Sprite player;
	private Player hero;
	
	public final int BOUNDRY_X_LEFT = 75;
	public final int BOUNDRY_X_RIGHT = 1140;
	public final int BOUNDRY_Y_TOP = 65;
	public final int BOUNDRY_Y_BOTTOM = 610;

	@Override
	public void createScene() {
		// TODO Auto-generated method stub

		player = new Sprite(0,0,resources.player_region,vbom);
		hero = new Player(player,cam.getCenterX(),cam.getCenterY(),BOUNDRY_X_LEFT,BOUNDRY_X_RIGHT,BOUNDRY_Y_TOP,BOUNDRY_Y_BOTTOM);
		createBackground();
		attachChild(hero.player);
		createHUD();

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
		attachChild(new Sprite(0, this.cam.getHeight() - resources.bg_region.getHeight() +32, resources.bg_region, vbom));
	}

	private void createHUD()
	{
		gameHUD = new HUD();

		AnalogOnScreenControl OnScreenControl = new AnalogOnScreenControl(resources.control_region.getWidth()/2, this.cam.getHeight() - resources.control_region.getHeight()
												- 32, this.cam, resources.control_region, resources.knob_region, 0.1f, 200, resources.vbom, new IAnalogOnScreenControlListener() {
			@Override
			public void onControlChange(final BaseOnScreenControl pBaseOnScreenControl, final float pValueX, final float pValueY) {
				
				hero.move(pValueX * 500, pValueY * 500);
					
			}

			@Override
			public void onControlClick(AnalogOnScreenControl pAnalogOnScreenControl) {
				
			}
		});
		
		OnScreenControl.getControlBase().setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		OnScreenControl.getControlBase().setAlpha(0.5f);
	    OnScreenControl.getControlBase().setScaleCenter(0, 128);
		OnScreenControl.getControlBase().setScale(1.25f);
		OnScreenControl.getControlKnob().setScale(1.25f);
		OnScreenControl.refreshControlKnobPosition();

		setChildScene(OnScreenControl);

		health = new Text(0, 0, resources.font, "HP: 0123456789", new TextOptions(HorizontalAlign.LEFT), vbom);
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
