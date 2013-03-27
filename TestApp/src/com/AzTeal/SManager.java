package com.AzTeal;

import org.andengine.engine.*;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.ui.IGameInterface.OnCreateSceneCallback;

public class SManager {
	
	private BaseScene splashScene;
	private BaseScene menuScene;
	private BaseScene gameScene;
	private BaseScene loadingScene;
	
	public enum SceneType
    {
        SCENE_SPLASH,
        SCENE_MENU,
        SCENE_GAME,
        SCENE_LOAD,
    }
	
	private static final SManager SMAN = new SManager();
	private SceneType currentSceneType = SceneType.SCENE_SPLASH;
	private BaseScene currentScene;
	private Engine engine = RManager.get().engine;
	
	public void setScene(BaseScene scene){
		
		engine.setScene(scene);
		currentScene = scene;
		currentSceneType = scene.getSceneType();
		
	}
	
	public void setScene(SceneType sceneType){
		
		switch (sceneType){
		
		case SCENE_MENU:
			setScene(menuScene);
			break;
		case SCENE_GAME:
			setScene(gameScene);
			break;
		case SCENE_SPLASH:
			setScene(splashScene);
			break;
		case SCENE_LOAD:
			setScene(loadingScene);
			break;
		default:
			break;
			
		}
		
	}
	
	public static SManager get(){
        return SMAN;
    }
    
    public SceneType getCurrentSceneType(){
        return currentSceneType;
    }
    
    public BaseScene getCurrentScene(){
        return currentScene;
    }
    
    public void createSplashScene(OnCreateSceneCallback pOnCreateSceneCallback){
    	
        RManager.get().loadSplash();
        splashScene = new Splash();
        currentScene = splashScene;
        pOnCreateSceneCallback.onCreateSceneFinished(splashScene);
        
    }
    
    private void disposeSplashScene(){
    	
        RManager.get().unloadSplash();
        splashScene.disposeScene();
        splashScene = null;
        
    }
    
    public void createMenuScene(){
    	
    	RManager.get().loadMenu();
        menuScene = new MainMenu();
        setScene(menuScene);
        disposeSplashScene();
    	
    }
    
    public void createLoadScene(){
    	
    	RManager.get().unloadMenu();
    	RManager.get().loadLoad();
    	loadingScene = new LoadScreen();
    	setScene(loadingScene);
    	
    	engine.registerUpdateHandler(new TimerHandler(0.1f, new ITimerCallback() 
        {
            public void onTimePassed(final TimerHandler pTimerHandler) 
            {
                engine.unregisterUpdateHandler(pTimerHandler);
                RManager.get().loadGame();
                gameScene = new GameScene();
                setScene(gameScene);
            }
        }));
    	
    	}
    }


