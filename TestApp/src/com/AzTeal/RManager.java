package com.AzTeal;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;

public class RManager {
	
	private static final RManager RMAN = new RManager(); //singleton
	
	public Engine engine;
	public GameActivity activity;
	public Camera cam;
	public VertexBufferObjectManager vbom;
	public ITextureRegion splash_region;
	//public ITextureRegion menu_background_region;
	public ITextureRegion play_region;
	public ITextureRegion options_region;
	public ITextureRegion load_region;
	public final static int BADGE_OFFSET = 128;
	   
	private BuildableBitmapTextureAtlas menuTextureAtlas;
	private BitmapTextureAtlas splashTextureAtlas;
	private BitmapTextureAtlas loadingTextureAtlas;
	
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
