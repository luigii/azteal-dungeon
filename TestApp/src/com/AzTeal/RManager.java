package com.AzTeal;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.font.*;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;

import android.graphics.Color;
import android.graphics.Typeface;

public class RManager {
	
	private static final RManager RMAN = new RManager(); //singleton
	
	public Font font;
	public Engine engine;
	public GameActivity activity;
	public Camera cam;
	public VertexBufferObjectManager vbom;
	public ITextureRegion splash_region;
	//public ITextureRegion menu_background_region;
	public ITextureRegion play_region;
	public ITextureRegion options_region;
	public ITextureRegion load_region;
	public ITextureRegion control_region;
	public ITextureRegion knob_region;
	public ITextureRegion player_region;
	public ITextureRegion bg_region;
	//public ITiledTextureRegion player_region;
	public final static int BADGE_OFFSET = 128;
	public final static int CONTROLLER_OFFSET = 128;
	public final static int FONT_SIZE = 32;
	   
	private BuildableBitmapTextureAtlas menuTextureAtlas;
	private BitmapTextureAtlas splashTextureAtlas;
	private BitmapTextureAtlas loadingTextureAtlas;
	private BitmapTextureAtlas controlTextureAtlas;
	private BitmapTextureAtlas levelTextureAtlas;
	private BitmapTextureAtlas playerTextureAtlas;
	
	public void loadMenu(){
		
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		menuTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), activity.WIDTH, activity.HEIGHT, TextureOptions.BILINEAR);
		//menu_background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "menu_background.png");
		play_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "play.png");
		options_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "options.png");
		       
		try 
		{
		    this.menuTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
		    this.menuTextureAtlas.load();
		} 
		catch (final TextureAtlasBuilderException e)
		{
		        Debug.e(e);
		}
			
	}
	
	public void unloadMenu(){
		
		menuTextureAtlas.unload();
		play_region = null;
		options_region = null;		
		
	}
	
	public void loadGame(){
		
		final ITexture fontTexture = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
		this.font = FontFactory.createFromAsset(activity.getFontManager(), fontTexture, activity.getAssets(), "gfx/fnt/8-BIT WONDER.TTF", FONT_SIZE, true, Color.WHITE);
		this.font.load();

		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/Player/");
		playerTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(), 80, 80, TextureOptions.BILINEAR);
		player_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(playerTextureAtlas, activity, "player.png", 0, 0);
		              //BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(playerTextureAtlas, activity, "player.png", 3, 1);
		playerTextureAtlas.load();
		
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/Controller/");
		controlTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(), 256, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		control_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(controlTextureAtlas, activity, "Controller.png", 0, 0);
		knob_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(controlTextureAtlas, activity, "Knob.png", 128, 0);
		controlTextureAtlas.load();
		
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/level/");
		levelTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(), 1280, 800,TextureOptions.BILINEAR);
		bg_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(levelTextureAtlas, activity, "Dungeon.png", 0, 0);
		levelTextureAtlas.load();
		

	}
	
	
	public void loadLoad(){
		
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/loading/");
		loadingTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
		load_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(loadingTextureAtlas, activity, "load.png", 0, 0);
		loadingTextureAtlas.load();
		
	}
	
	
	public void loadSplash(){
		
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		splashTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
		splash_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(splashTextureAtlas, activity, "splash.png", 0, 0);
		splashTextureAtlas.load();
		
	}
	
	public void unloadSplash(){
		
		splashTextureAtlas.unload();
		splash_region = null;
		
	}
	
	public static void prepManager(Engine engine, GameActivity activity, Camera cam, VertexBufferObjectManager vbom){
		
		get().engine = engine;
		get().activity = activity;
		get().cam = cam;
		get().vbom = vbom;
		
	}
	
	public static RManager get(){
		
		return RMAN;
		
	}
	
	
}
