package com.mygdx.game.controller;

import com.mygdx.game.entity.Node;
import com.sun.javafx.geom.Point2D;

import java.util.ArrayList;
import java.util.Arrays;

public class PathFindingController {

    private ArrayList<Node> openSet;
    private ArrayList<Node> closeSet;
    private ArrayList<Node> path;
    private DrawController drawController;
    private Node endNode;
    private boolean isDone = false;

    public PathFindingController() {
        openSet = new ArrayList<>();
        closeSet = new ArrayList<>();
        path = new ArrayList<Node>();
        drawController = new DrawController();
    }

    public void performSearch() {
        Node current;
        if(!openSet.isEmpty() && !isDone) {
            int lowest = 0;
            for(int i=0;i<openSet.size();i++) {
                if(openSet.get(i).getF() < openSet.get(lowest).getF()) {
                    lowest = i;
                }
            }
            current = openSet.get(lowest);
            if(current==endNode) {
                System.out.println("DONE");
                Node tmp = current;
                this.path.add(tmp);
                while(tmp.getPrevious()!= null)
                {
                    this.path.add(tmp.getPrevious());
                    tmp = tmp.getPrevious();
                }
                isDone = true;
            }
            openSet.remove(current);
            closeSet.add(current);

            for(int i=0;i<current.getNeighbours().size();i++) {
                Node neighbour = current.getNeighbours().get(i);
                 if(!closeSet.contains(neighbour)) {
                     float tmpG = current.getG()+1;
                     if(openSet.contains(neighbour)) {
                         if(tmpG < neighbour.getG()) {
                             neighbour.setG(tmpG);
                         }
                     }else {
                         neighbour.setG(tmpG);
                         openSet.add(neighbour);
                     }
                     neighbour.setH(heuristic(neighbour,endNode));
                     neighbour.setF(neighbour.getG()+neighbour.getH());
                     neighbour.setPrevious(current);
                 }
            }


        }
    }

    public static float heuristic(Node neighbour, Node endNode) {
        return Point2D.distance(neighbour.getPosition().x,neighbour.getPosition().y,
                                endNode.getPosition().x,neighbour.getPosition().y);
//        return (Math.abs((int)neighbour.getPosition().x-(int)endNode.getPosition().x) +
//                Math.abs((int)neighbour.getPosition().y-(int)endNode.getPosition().y));
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

    public ArrayList<Node> getPath() {
        return path;
    }

    public boolean isDone() {
        return isDone;
    }
}
