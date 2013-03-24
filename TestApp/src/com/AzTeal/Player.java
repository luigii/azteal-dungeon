package com.AzTeal;

import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.entity.sprite.Sprite;
import org.andengine.util.color.Color;

public class Player{ 
	
	private float startX;
	private float startY;
	
	private final int boundryLeft;
	private final int boundryRight;
	private final int boundryTop;
	private final int boundryBottom;
	
	final PhysicsHandler physicsHandler;
	public Sprite player;
	
	public Player(Sprite player, float x, float y, int left, int right, int top, int bottom){
		
		this.player = player;
		physicsHandler = new PhysicsHandler(player);
		player.registerUpdateHandler(physicsHandler);
		this.startX = x;
		this.startY = y;
		this.player.setPosition(startX, startY);
		
		boundryLeft = left;
		boundryRight = right;
		boundryTop = top;
		boundryBottom = bottom;
		
	}
	
	public void move(float X, float Y){	
		
		while(player.getX() < boundryLeft){
			
			player.setPosition(boundryLeft, player.getY());
			
		}
		
		while(player.getX() > boundryRight){
			
			player.setPosition(boundryRight, player.getY());
			
		}
		
		while(player.getY() < boundryTop){
			
			player.setPosition(player.getX(), 65);
				
		}
		
		while(player.getY() > boundryBottom){
			
			player.setPosition(player.getX(), 610);
				
		}
		
		physicsHandler.setVelocity(X, Y);	
		
	}
		
}
