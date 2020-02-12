package com.mygdx.game.entity;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.controller.DrawController;

public class Grid{
    private int nodes_x;
    private int nodes_y;
    private Node[][] nodes;
    private DrawController drawController;

    public Grid() {

    }
    public Grid(int w,int h) {
        this.nodes_x = w;
        this.nodes_y = h;
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
    }

    public void draw() {
        this.drawController.drawNodes(this.nodes,this.nodes_x,this.nodes_y);

    }
    public void reset() {
        for(int i=0;i<this.nodes_x;i++) {
            for(int j=0;j<this.nodes_y;j++) {
                this.nodes[i][j].setWall(false);
                this.nodes[i][j].setPrevious(null);
            }
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
}
