package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.controller.DrawController;
import com.mygdx.game.controller.PathFindingController;

import java.util.ArrayList;

public class Grid{
    private int nodes_x;
    private int nodes_y;
    private Node[][] nodes;
    private PathFindingController pathFindingController;
    private DrawController drawController;
    private ArrayList<Node> openSet;
    private ArrayList<Node> closeSet;
    private ArrayList<Node> path;

    public Grid() {

    }
    public Grid(int w,int h) {
        this.nodes_x = w;
        this.nodes_y = h;

        this.pathFindingController = new PathFindingController();
        this.drawController = new DrawController();
        nodes = new Node[this.nodes_x][this.nodes_y];
        initNodes();
    }

    private void initNodes() {
        for(int i=0;i<this.nodes_x;i++) {
            for(int j=0;j<this.nodes_y;j++) {
                this.nodes[i][j] = new Node( new Vector2(i, j));
            }
        }

        //init node neighbours
        for(int i=0;i<this.nodes_x;i++) {
            for(int j=0;j<this.nodes_y;j++) {
                this.nodes[i][j].addNeighbours(this.nodes);
            }
        }

        //update openset and closeset from pathController
        this.openSet = this.pathFindingController.getOpenSet();
        this.closeSet = this.pathFindingController.getCloseSet();
        this.path = this.pathFindingController.getPath();

    }

    public void calculatePath() {
        this.pathFindingController.performSearch();
    }

    public void draw() {
        this.drawController.drawNodes(this.nodes,this.nodes_x,this.nodes_y);
       // this.drawController.drawNodeSet(this.openSet,Color.GREEN);
        this.drawController.drawNodeSet(this.closeSet,Color.YELLOW);
        this.drawController.drawNodeSet(this.path,Color.GREEN);
        if(this.pathFindingController.getStartNode()!= null) {
            this.drawController.drawNode(this.pathFindingController.getStartNode(), Color.BLUE);
        }
        if(this.pathFindingController.getEndNode()!=null) {
            this.drawController.drawNode(this.pathFindingController.getEndNode(), Color.RED);
        }


    }

    public Node[][] getNodes() {
        return this.nodes;
    }

    public int getNodes_x() {
        return nodes_x;
    }

    public int getNodes_y() {
        return nodes_y;
    }

    public void setStart(int x,int y) {
        this.nodes[x][y].setWall(false);
        this.pathFindingController.setStart(this.nodes[x][y]);
        this.draw();


    }
    public void setEnd(int x,int y) {
        this.nodes[x][y].setWall(false);
        this.pathFindingController.setEndNode(this.nodes[x][y]);
        this.draw();

    }

    public void initializePathFindingController() {
        this.pathFindingController.initialize();
    }
}
