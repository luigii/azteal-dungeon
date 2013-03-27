package com.AzTeal;

import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;

import com.AzTeal.SManager.SceneType;

public class MainMenu extends BaseScene implements IOnMenuItemClickListener {

	private MenuScene menu;
	private final int MENU_PLAY = 0;
	private final int MENU_OPTIONS = 1;

	@Override
	public void createScene() {

		menu = new MenuScene(cam);
		menu.setPosition(0, 200);
		
		final IMenuItem playMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_PLAY, resources.play_region, vbom), 1.2f, 1);
		final IMenuItem optionsMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_OPTIONS, resources.options_region, vbom), 1.2f, 1);

		menu.addMenuItem(playMenuItem);
		menu.addMenuItem(optionsMenuItem);

		menu.buildAnimations();
		menu.setBackgroundEnabled(false);

		playMenuItem.setPosition(playMenuItem.getX(), playMenuItem.getY());
		optionsMenuItem.setPosition(optionsMenuItem.getX(), optionsMenuItem.getY());

		menu.setOnMenuItemClickListener(this);

		setChildScene(menu);

	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub

	}

	@Override
	public SceneType getSceneType() {

		return SceneType.SCENE_MENU;

	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem, float pMenuItemLocalX, float pMenuItemLocalY) {

		switch(pMenuItem.getID())
		{
		case MENU_PLAY:
			SManager.get().createLoadScene();
			return true;
		case MENU_OPTIONS:
			return true;
		default:
			return false;
		}
	}

}
