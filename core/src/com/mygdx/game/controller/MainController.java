package com.mygdx.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.Main;
import com.mygdx.game.builder.WallBuilder;
import com.mygdx.game.entity.Grid;

public class MainController implements InputProcessor {
    private WallBuilder wallBuilder;
    private Grid grid;
    private PathFindingController pathController;
    public static boolean enableRun = false;
    private boolean startPlaced = false;
    private boolean endPlaced = false;

    public MainController() {
        Gdx.input.setInputProcessor(this);
        this.grid = new Grid(Main.NODES_AMOUNT,Main.NODES_AMOUNT);
        this.pathController = new PathFindingController();
        this.wallBuilder = new WallBuilder(this.grid,pathController);
    }
    public void drawGrid() {
        this.grid.draw();
        this.pathController.draw();

    }
    public void resetGrid() {
        enableRun = false;
        this.pathController.resetPathFindingController();
    }

    public void proceedSearch() {
        this.pathController.performSearch();
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == 62 && startPlaced && endPlaced) {
            Gdx.input.setInputProcessor(null);
            this.pathController.initialize();
            MainController.enableRun = true;
        } else {
            int y = Math.abs(Gdx.input.getY() - Main.HEIGHT);
            int x = Gdx.input.getX();
            x /= Main.NODE_SIZE;
            y /= Main.NODE_SIZE;
            if (keycode == 30) {
                this.wallBuilder.setStart(x, y);
                startPlaced = true;
            } else if (keycode == 33) {
                this.wallBuilder.setEnd(x, y);
                endPlaced = true;
            }
        }
        return false;
    }

        @Override
        public boolean touchDown ( int screenX, int screenY, int pointer, int button){
            int y = Math.abs(screenY - Main.HEIGHT);
            int x = screenX;
            x /= Main.NODE_SIZE;
            y /= Main.NODE_SIZE;
            if (button == Input.Buttons.LEFT) this.wallBuilder.setWall(x, y, true);
            else if (button == Input.Buttons.RIGHT) this.wallBuilder.setWall(x, y, false);

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
                this.wallBuilder.setWall(x,y,true);
            }catch(IndexOutOfBoundsException exc) {}
            try {
                this.wallBuilder.setWall(x,y+1,true);
            }catch(IndexOutOfBoundsException exc) {}
            try {
                this.wallBuilder.setWall(x+1,y+1,true);
            }catch(IndexOutOfBoundsException exc) {}
            try {
                this.wallBuilder.setWall(x+1,y,true);
            }catch(IndexOutOfBoundsException exc) {}


        }
        else if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT))  this.wallBuilder.setWall(x,y,false);
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
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
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
