package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.controller.MainController;
import com.mygdx.game.controller.PathFindingController;

public class MainScreen implements Screen {
    private MainController mainController;

    public MainScreen() {
        this.mainController = new MainController();
        Gdx.input.setInputProcessor(this.mainController);
        Gdx.gl20.glClearColor(1,1,1,1);
    }
    @Override
    public void show() {

    }
    @Override
    public void render(float delta) {
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
            if(MainController.enableRun && !PathFindingController.failure && !PathFindingController.isDone) {
               this.mainController.proceedSearch();
                }
            this.mainController.drawGrid();

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
