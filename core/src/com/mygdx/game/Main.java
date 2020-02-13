package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screen.MainScreen;

public class Main extends Game {
	SpriteBatch batch;
	public static final int WIDTH = 900;
	public static final int HEIGHT = 900;
	public static final int NODES_AMOUNT = 50;
	public static float WALL_CHANCE = 0.5f;
	public static final float NODE_SIZE = ((float)WIDTH/(float)NODES_AMOUNT);
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new MainScreen());

	}

}
