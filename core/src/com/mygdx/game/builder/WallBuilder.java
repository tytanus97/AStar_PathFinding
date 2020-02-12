package com.mygdx.game.builder;

import com.mygdx.game.controller.PathFindingController;
import com.mygdx.game.entity.Grid;
import com.mygdx.game.entity.Node;


public class WallBuilder{
    private Node[][] nodes;
    private PathFindingController pathFindingController;

    public WallBuilder(Grid grid,PathFindingController controller) {
        this.nodes = grid.getNodes();
        this.pathFindingController = controller;
    }


    public void setWall(int x, int y,boolean wall) throws IndexOutOfBoundsException {
        nodes[x][y].setWall(wall);
    }

    public void setStart(int x, int y) {

        this.pathFindingController.setStartNode(nodes[x][y]);
        this.pathFindingController.draw();
    }
    public void setEnd(int x,int y) {
        this.pathFindingController.setEndNode(nodes[x][y]);
        this.pathFindingController.draw();
    }
}
