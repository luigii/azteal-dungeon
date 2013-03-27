package com.AzTeal;

import java.io.IOException;

import org.andengine.engine.Engine;
import org.andengine.engine.LimitedFPSEngine;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.WakeLockOptions;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.view.Display;

@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2) public class GameActivity extends BaseGameActivity {
	
	private Camera cam;
	private RManager resources;
	public int WIDTH;
	public int HEIGHT;
	//private Engine engine;
	
	
	public Engine onCreateEngine(EngineOptions pEngineOptions){
		
		return new LimitedFPSEngine(pEngineOptions, 60); //test initialisation
		
	}
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		WIDTH = size.x;
		HEIGHT = size.y;
		Log.d("Dimensions", "dimensions : " + WIDTH + " , " + HEIGHT);
		
		cam = new Camera(0, 0, WIDTH, HEIGHT);
	    EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new RatioResolutionPolicy(WIDTH/2, HEIGHT/2), this.cam);
	    //engineOptions.getAudioOptions().setNeedsMusic(true).setNeedsSound(true);
	    engineOptions.setWakeLockOptions(WakeLockOptions.SCREEN_ON);
	    return engineOptions;
		
	}
	

	@Override
	public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws IOException {
		
		RManager.prepManager(mEngine, this, cam, getVertexBufferObjectManager());
		resources = RManager.get();
		pOnCreateResourcesCallback.onCreateResourcesFinished();
		
	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws IOException {
		
		SManager.get().createSplashScene(pOnCreateSceneCallback);
		
	}

	@Override
	public void onPopulateScene(Scene pScene,OnPopulateSceneCallback pOnPopulateSceneCallback) throws IOException {
		
		mEngine.registerUpdateHandler(new TimerHandler(2f, new ITimerCallback(){
			
	            public void onTimePassed(final TimerHandler pTimerHandler){
	            	
	            	mEngine.unregisterUpdateHandler(pTimerHandler);
	                SManager.get().createMenuScene();
	                
	            }
	    }));
		
	    pOnPopulateSceneCallback.onPopulateSceneFinished();
		
	}

}
