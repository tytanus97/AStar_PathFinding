package com.mygdx.game.controller;

import com.mygdx.game.entity.Node;

import java.util.ArrayList;
import java.util.Arrays;

public class PathFindingController {

    private ArrayList<Node> openSet;
    private ArrayList<Node> closeSet;
    private DrawController drawController;
    private Node endNode;

    public PathFindingController() {
        openSet = new ArrayList<>();
        closeSet = new ArrayList<>();
        drawController = new DrawController();
    }


    public void performSearch() {

    }


    // getters and setters
    
    public void setStart(Node start) {
        this.openSet.add(start);
    }
    public void setEndNode(Node endNode) {
        this.endNode = endNode;
    }

    public ArrayList<Node> getOpenSet() {
        return openSet;
    }

    public void setOpenSet(ArrayList<Node> openSet) {
        this.openSet = openSet;
    }

    public ArrayList<Node> getCloseSet() {
        return closeSet;
    }

    public void setCloseSet(ArrayList<Node> closeSet) {
        this.closeSet = closeSet;
    }

    public Node getEndNode() {
        return endNode;
    }
}
