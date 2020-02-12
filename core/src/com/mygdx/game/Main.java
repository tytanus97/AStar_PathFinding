package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screen.MainScreen;

public class Main extends Game {
	SpriteBatch batch;
	public static final int WIDTH = 900;
	public static final int HEIGHT = 900;
	public static final int NODES_AMOUNT = 100;
	public static final int NODE_SIZE = WIDTH/NODES_AMOUNT;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new MainScreen());

	}

}
