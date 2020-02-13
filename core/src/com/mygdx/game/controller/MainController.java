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

        this.grid = new Grid(Main.NODES_AMOUNT,Main.NODES_AMOUNT);
        this.pathController = new PathFindingController();
        this.wallBuilder = new WallBuilder(this.grid,pathController);
    }
    public void drawGrid() {

        this.pathController.draw();
        this.grid.draw();
    }
    public void resetGrid() {
        enableRun = false;

        this.pathController.resetPathFindingController();
        this.grid.reset();
        this.grid.draw();
    }

    public void proceedSearch() {
        this.pathController.performSearch();
    }
    @Override
    public boolean keyDown(int keycode) {
        if(keycode == 46) {
            resetGrid();
        }
        if(!MainController.enableRun && !PathFindingController.isDone) {
            if (keycode == 62 && startPlaced && endPlaced) {

                this.pathController.initialize();
                MainController.enableRun = true;
            } else if (keycode == 44) {
                this.grid.reset();
                this.wallBuilder.setRandomWalls(this.grid.getNodes_x(), this.grid.getNodes_y());

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
        }
        return false;
    }

        @Override
        public boolean touchDown ( int screenX, int screenY, int pointer, int button){
            if(!MainController.enableRun && !PathFindingController.isDone) {
                int y = Math.abs(screenY - Main.HEIGHT);
                int x = screenX;
                x /= Main.NODE_SIZE;
                y /= Main.NODE_SIZE;
                if (button == Input.Buttons.LEFT) this.wallBuilder.setWall(x, y, true);
                else if (button == Input.Buttons.RIGHT) this.wallBuilder.setWall(x, y, false);
            }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if(!MainController.enableRun && !PathFindingController.isDone) {
            int y = Math.abs(screenY - Main.HEIGHT);
            int x = screenX;
            x /= Main.NODE_SIZE;
            y /= Main.NODE_SIZE;
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                this.wallBuilder.setWall(x, y, true);
            }
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) {
                try {
                    this.wallBuilder.setWall(x, y, true);
                } catch (IndexOutOfBoundsException exc) {
                }
                try {
                    this.wallBuilder.setWall(x, y + 1, true);
                } catch (IndexOutOfBoundsException exc) {
                }
                try {
                    this.wallBuilder.setWall(x + 1, y + 1, true);
                } catch (IndexOutOfBoundsException exc) {
                }
                try {
                    this.wallBuilder.setWall(x + 1, y, true);
                } catch (IndexOutOfBoundsException exc) {
                }


            } else if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) this.wallBuilder.setWall(x, y, false);
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        if(character == 'r' || character == 'R') {
            resetGrid();
        }
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
        if(!MainController.enableRun && !PathFindingController.isDone) {
        if (amount == 1 && Main.WALL_CHANCE > 0.4) {
            this.grid.reset();
            Main.WALL_CHANCE -= 0.02f;
            this.wallBuilder.setRandomWalls(this.grid.getNodes_x(), this.grid.getNodes_y());
        } else if (amount == -1 && Main.WALL_CHANCE < 0.8f) {
            this.grid.reset();
            Main.WALL_CHANCE += 0.02f;
            this.wallBuilder.setRandomWalls(this.grid.getNodes_x(), this.grid.getNodes_y());

        }
    }
        return false;
    }
}
