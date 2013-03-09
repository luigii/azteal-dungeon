package com.AzTeal;

import org.andengine.entity.sprite.Sprite;
import org.andengine.util.color.Color;

public class Player{ //extends AnimatedSprite {
	
//	private Body body;

//	public Player(float pX, float pY, VertexBufferObjectManager vbo, Camera camera)
//    {
//        super(pX, pY, RManager.get().player_region, vbo);
//    }
	
	private float startX;
	private float startY;
	private float rotation;
	public Sprite player;
	
	public Player(Sprite player, float x, float y){
		
		this.player = player;
		this.startX = x;
		this.startY = y;
		this.player.setPosition(startX, startY);
		
	}
	
	public void move(int direction){
		
		
		switch (direction) {
			
		case 1: player.setPosition(player.getX(), player.getY() - 32);
				player.setColor(Color.CYAN);
				rotation += 30;
				break;
		case 2: player.setPosition(player.getX(), player.getY() + 32);
				player.setColor(Color.PINK);
				rotation -= 30;
				break;
		case 3: player.setPosition(player.getX() + 32, player.getY());
				player.setColor(Color.GREEN);
				rotation += 30;
				break;
		case 4: player.setPosition(player.getX() - 32, player.getY());
				player.setColor(Color.RED);
				rotation -= 30;
				break;		
		
		}
		
		player.setRotation(rotation);
		
	}
	
}
