package com.mygdx.game.controller;

import com.mygdx.game.Main;
import com.mygdx.game.builder.WallBuilder;
import com.mygdx.game.entity.Grid;

public class StateController {
    private WallBuilder wallBuilder;
    private Grid grid;

    public StateController() {
        this.grid = new Grid(Main.NODES_AMOUNT,Main.NODES_AMOUNT);
        this.wallBuilder = new WallBuilder(this.grid);
    }

    public void buildGrid() {

    }

    public void initializeGrid() {

    }

    public void resetGrid() {

    }

    public void proceedSearch() {

    }

}
