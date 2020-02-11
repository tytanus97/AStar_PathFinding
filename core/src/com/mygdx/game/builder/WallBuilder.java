package com.mygdx.game.builder;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.Main;
import com.mygdx.game.entity.Grid;
import com.mygdx.game.entity.Node;
import com.mygdx.game.screen.MainScreen;

public class WallBuilder implements InputProcessor {
    private Grid grid;
    private Node[][] nodes;
    private boolean startPlaced = false;
    private boolean endPlaced = false;

    public WallBuilder(Grid grid) {
        Gdx.input.setInputProcessor(this);
        this.grid = grid;
        this.nodes = this.grid.getNodes();
    }

    public void draw() {
        this.grid.draw();
    }


    private void setWall(int x, int y,boolean wall) throws IndexOutOfBoundsException {
        nodes[x][y].setWall(wall);
    }


    @Override
    public boolean keyDown(int keycode) {
        if (keycode == 62 && startPlaced && endPlaced) {
            Gdx.input.setInputProcessor(null);
            this.grid.initializePathFindingController();
            MainScreen.enableRun = true;

        }
        else {
            int y = Math.abs(Gdx.input.getY() - Main.HEIGHT);
            int x = Gdx.input.getX();
            x /= Main.NODE_SIZE;
            y /= Main.NODE_SIZE;
            if (keycode == 30) {
                this.grid.setStart(x,y);
                startPlaced = true;
            }
            else if(keycode == 33) {
                this.grid.setEnd(x,y);
                endPlaced = true;
            }
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
        int y = Math.abs(screenY - Main.HEIGHT);
        int x = screenX;
        x /= Main.NODE_SIZE;
        y /= Main.NODE_SIZE;
        if(button == Input.Buttons.LEFT) setWall(x,y,true);
        else if (button == Input.Buttons.RIGHT) setWall(x,y,false);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }



    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        int y = Math.abs(screenY - Main.HEIGHT);
        int x = screenX;
        x /= Main.NODE_SIZE;
        y /= Main.NODE_SIZE;
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            try {
                setWall(x,y,true);
            }catch(IndexOutOfBoundsException exc) {}
            try {
                setWall(x,y+1,true);
            }catch(IndexOutOfBoundsException exc) {}
            try {
                setWall(x+1,y+1,true);
            }catch(IndexOutOfBoundsException exc) {}
            try {
                setWall(x+1,y,true);
            }catch(IndexOutOfBoundsException exc) {}


        }
        else if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) setWall(x,y,false);
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
