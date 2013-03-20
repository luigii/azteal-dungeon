package com.example.projectgame;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
//import org.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
//import org.andengine.entity.scene.background.ColorBackground;
import org.andengine.entity.text.Text;
import org.andengine.entity.util.FPSLogger;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.texture.Texture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.ui.activity.BaseGameActivity;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;


public class MainActivity extends BaseGameActivity {
        //**************************************************************
        //Constants
        //**************************************************************
        public static final int CAMERA_WIDTH = 800;
        public static final int CAMERA_HEIGHT = 400;
        public static AssetManager sAssetManager;
        public Resources res;
    
        private Camera mCamera;
        
        BitmapTextureAtlas mFloorObjectTexture;
        BitmapTextureAtlas mPlayerTexture;
        TextureRegion mFloorTextureRegion;
        TextureRegion mPlayerTextureRegion;
        Map mMap;
        Player mPlayer;

        @Override
        public EngineOptions onCreateEngineOptions() {
                this.res = getResources();
                this.mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
                this.mMap = new Map(this.res);
                this.mPlayer = new Player(new Location(0,0));
                this.mMap.floor[this.mPlayer.location.getPosY()][this.mPlayer.location.getPosX()].setDestroyed(true);
                return new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), this.mCamera);
        }

        public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback)
				throws Exception {
                this.mFloorObjectTexture = new BitmapTextureAtlas(this.getTextureManager(), 32, 32, TextureOptions.DEFAULT);
                this.mPlayerTexture = new BitmapTextureAtlas(this.getTextureManager(),32,32,TextureOptions.DEFAULT);
               
                this.mFloorTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mFloorObjectTexture, this,"floor.png", 0, 0);
                this.mPlayerTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mPlayerTexture,this,"PlayerIdleForward.png",0,0);
                
                this.mEngine.getTextureManager().loadTexture(this.mFloorObjectTexture);
                this.mEngine.getTextureManager().loadTexture(this.mPlayerTexture);
        }

        public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws Exception {
                this.mEngine.registerUpdateHandler(new FPSLogger());
                final Scene scene = new Scene();
                scene.setBackground(new Background(0, 0, 0));
        }

        public void onLoadComplete() {
                this.mMap.Draw(this.mFloorTextureRegion, this.mEngine.getScene());
                this.mMap.floor[this.mPlayer.location.getPosY()][this.mPlayer.location.getPosX()].isDestroyed();
                this.mPlayer.Draw(this.mEngine.getScene());
                this.mMap.UpdateMap(mEngine.getScene(),mPlayer);
        }

		@Override
		public void onPopulateScene(Scene pScene,
				OnPopulateSceneCallback pOnPopulateSceneCallback)
				throws Exception {
			// TODO Auto-generated method stub
			
		}

}
