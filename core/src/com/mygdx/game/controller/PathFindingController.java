package com.mygdx.game.controller;

import com.mygdx.game.entity.Node;

import java.util.ArrayList;
import java.util.Arrays;

public class PathFindingController {

    private ArrayList<Node> openSet;
    private ArrayList<Node> closeSet;
    private ArrayList<Node> nodes;
    private Node endNode;

    public PathFindingController() {
        openSet = new ArrayList<>();
        closeSet = new ArrayList<>();
    }

    public void setStart(Node start) {
        this.openSet.add(start);
    }
    public void setEndNode(Node endNode) {
        this.endNode = endNode;
    }



}
