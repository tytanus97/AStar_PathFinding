package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.Main;
import com.mygdx.game.entity.Grid;

public class MainScreen implements Screen {
    private Grid grid;

    public MainScreen() {
        this.grid = new Grid(Main.NODES_AMOUNT,Main.NODES_AMOUNT);
        Gdx.gl20.glClearColor(1,1,1,1);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.grid.drawNodes();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
