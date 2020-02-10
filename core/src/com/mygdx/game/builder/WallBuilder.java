package com.mygdx.game.builder;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.Main;
import com.mygdx.game.entity.Grid;
import com.mygdx.game.entity.Node;
import com.mygdx.game.screen.MainScreen;

public class WallBuilder implements InputProcessor {
    private Grid grid;
    private Node[][] nodes;

    public WallBuilder(Grid grid) {
        Gdx.input.setInputProcessor(this);
        this.grid = grid;
        this.nodes = this.grid.getNodes();
    }

    public void draw() {
        this.grid.draw();
    }


    private void setWall(int x, int y) {
        nodes[x][y].setWall(true);
    }


    @Override
    public boolean keyDown(int keycode) {
        if (keycode == 62) {
            Gdx.input.setInputProcessor(null);
            MainScreen.enableRun = true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        int y = Math.abs(screenY - Main.HEIGHT);
        int x = screenX;
        x /= Main.NODE_SIZE;
        y /= Main.NODE_SIZE;
        setWall(x,y);
        return false;
    }



    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        int y = Math.abs(screenY - Main.HEIGHT);
        int x = screenX;
        x /= Main.NODE_SIZE;
        y /= Main.NODE_SIZE;
        setWall(x,y);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
