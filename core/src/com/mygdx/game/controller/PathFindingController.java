package com.mygdx.game.controller;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.entity.Node;

import java.util.ArrayList;

public class PathFindingController {

    private ArrayList<Node> openSet;
    private ArrayList<Node> closeSet;
    private ArrayList<Node> path;
    private Node endNode;
    private Node startNode;
    public static boolean isDone = false;
    public static boolean failure = false;
    private DrawController drawController;

    public PathFindingController() {
        openSet = new ArrayList<>();
        closeSet = new ArrayList<>();
        path = new ArrayList<>();
        drawController = new DrawController();

    }

   public  void performSearch() {
        Node current;

        if(!openSet.isEmpty() && !isDone) {


            this.resetPath();
            int lowest = 0;
            for(int i=0;i<openSet.size();i++) {
                if(openSet.get(i).getF() < openSet.get(lowest).getF()) {
                    lowest = i;
                }
            }
            current = openSet.get(lowest);
            if(current == endNode) {
                System.out.println("DONE");
                isDone = true;
            }
            openSet.remove(current);
            closeSet.add(current);

            for(int i=0;i<current.getNeighbours().size();i++) {
                Node neighbour = current.getNeighbours().get(i);
                 if(!closeSet.contains(neighbour) && !neighbour.isWall()) {
                     float tmpG = current.getG()+heuristic(current,neighbour);
                     boolean newPath = false;
                     if(openSet.contains(neighbour)) {
                         if(tmpG < neighbour.getG()) {
                             neighbour.setG(tmpG);
                             newPath = true;
                         }
                     }else {
                         neighbour.setG(tmpG);
                         openSet.add(neighbour);
                         newPath = true;
                     }
                     if(newPath) {
                         neighbour.setH(heuristic(neighbour, endNode));
                         neighbour.setF(neighbour.getG() + neighbour.getH());
                         neighbour.setPrevious(current);
                     }
                 }
            }

            Node tmp = current;
            this.path.add(tmp);
            while(tmp.getPrevious()!= null)
            {
                this.path.add(tmp.getPrevious());
                tmp = tmp.getPrevious();
            }

        } else if(!isDone)  {
           failure = true;
            System.out.println("Nie udalo sie , sorry mate");
        }
    }

    public void draw() {
        this.drawController.drawNodeSet(this.openSet, Color.PURPLE);
        this.drawController.drawNodeSet(this.closeSet,Color.YELLOW);
        this.drawController.drawNodeSet(this.path,Color.GREEN);
        if(startNode!= null) {
            this.drawController.drawNode(startNode, Color.BLUE);
        }
        if(endNode!=null) {
            this.drawController.drawNode(endNode, Color.RED);
        }
    }

    private static float heuristic(Node neighbour, Node endNode) {
       // return  Point2D.distance(neighbour.getPosition().x,neighbour.getPosition().y,
       //       endNode.getPosition().x,endNode.getPosition().y);

        double x1 = neighbour.getPosition().x;
        double y1 = neighbour.getPosition().y;
        double x2 = endNode.getPosition().x;
        double y2 = endNode.getPosition().y;

            double ac = Math.abs(y2 - y1);
            double cb = Math.abs(x2 - x1);

            return (float) Math.hypot(ac, cb);
    }
    //add start node to openset and calculate its f as heuristic to end node
    public void initialize() {

        this.startNode.setF(heuristic(this.startNode,this.endNode));
        this.openSet.add(this.startNode);

    }

    public void resetPathFindingController() {
        this.openSet.clear();
        this.closeSet.clear();
        this.path.clear();
        isDone = false;
        failure = false;
        draw();
    }

    // getters and setters
    public void setStartNode(Node start) {
        this.startNode = start;

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
    public Node getStartNode() {
        return startNode;
    }

    public ArrayList<Node> getPath() {
        return path;
    }

    public boolean isDone() {
        return isDone;
    }

    public void resetPath() {
        this.path.clear();
    }


}
