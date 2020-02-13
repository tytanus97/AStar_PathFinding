package com.mygdx.game.builder;

import com.mygdx.game.Main;
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

    public void setRandomWalls(int x,int y) {
        for(int i=0;i<x;i++) {
            for(int j=0;j<y;j++) {
                if(Math.random() > Main.WALL_CHANCE)
                {
                    if(nodes[i][j] != this.pathFindingController.getStartNode() &&
                            nodes[i][j] != this.pathFindingController.getEndNode()) {
                        nodes[i][j].setWall(true);
                    }
                }
            }
        }
    }

    public void setWall(int x, int y,boolean wall) throws IndexOutOfBoundsException {
        if(nodes[x][y] != this.pathFindingController.getStartNode() &&
                nodes[x][y] != this.pathFindingController.getEndNode()) {
            nodes[x][y].setWall(wall);
        }
    }

    public void setStart(int x, int y) {
        this.nodes[x][y].setWall(false);
        this.pathFindingController.setStartNode(nodes[x][y]);
        this.pathFindingController.draw();
    }
    public void setEnd(int x,int y) {
        this.nodes[x][y].setWall(false);
        this.pathFindingController.setEndNode(nodes[x][y]);
        this.pathFindingController.draw();
    }
}
