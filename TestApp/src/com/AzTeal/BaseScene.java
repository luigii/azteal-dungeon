package com.AzTeal;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.AzTeal.SManager.SceneType;

import android.app.Activity;
import android.view.MotionEvent;

public abstract class BaseScene extends Scene {
	
	protected Engine engine;
	protected Activity activity;
	protected RManager resources;
	protected Camera cam;
	protected VertexBufferObjectManager vbom;
	
	public BaseScene(){
		
		this.resources = RManager.get();
		this.engine = resources.engine;
		this.activity = resources.activity;
		this.vbom = resources.vbom;
		this.cam = resources.cam;
		createScene();
		
	}
	
	public abstract void createScene();
    
    public abstract void disposeScene();
    
    public abstract SceneType getSceneType();

	public boolean onAreaTouched(TouchEvent touchEvent, float X, float Y) {
		// TODO Auto-generated method stub
		return false;
	}


}
