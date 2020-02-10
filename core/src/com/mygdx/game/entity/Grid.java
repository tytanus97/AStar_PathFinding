package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Main;
import com.mygdx.game.controller.DrawController;
import com.mygdx.game.controller.PathFindingController;

import java.util.ArrayList;

public class Grid {
    private int nodes_x;
    private int nodes_y;
    private Node[][] nodes;
    private PathFindingController pathFindingController;
    private DrawController drawController;
    private ArrayList<Node> openSet;
    private ArrayList<Node> closeSet;

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
        //set first element of array as start node and last as end node
        this.nodes[0][0] = new Node(new Vector2(0,0));
        this.nodes[Main.NODES_AMOUNT-1][Main.NODES_AMOUNT-1] = new Node(new Vector2(Main.NODES_AMOUNT-1,Main.NODES_AMOUNT-1));

        //pass the start and end node to controller
        this.pathFindingController.setStart(this.nodes[0][0]);
        this.pathFindingController.setEndNode(this.nodes[Main.NODES_AMOUNT - 1][Main.NODES_AMOUNT - 1]);

        //update openset and closeset from pathController
        this.openSet = this.pathFindingController.getOpenSet();
        this.closeSet = this.pathFindingController.getCloseSet();

    }

    public void calculatePath() {
        this.pathFindingController.performSearch();
    }

    public void draw() {
        this.drawController.drawNodes(this.nodes,this.nodes_x,this.nodes_y);
        this.drawController.drawNodeSet(this.openSet,Color.GREEN);
        this.drawController.drawNodeSet(this.closeSet,Color.YELLOW);
    }
}
