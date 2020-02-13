package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.screen.MainScreen;

public class Main extends Game {
	public static final int WIDTH = 950;
	public static final int HEIGHT = 950;
	public static final int NODES_AMOUNT = 50;
	public static float WALL_CHANCE = 0.5f;
	public static final float NODE_SIZE = ((float)WIDTH/(float)NODES_AMOUNT);
	
	@Override
	public void create () {
		setScreen(new MainScreen());

	}

}
