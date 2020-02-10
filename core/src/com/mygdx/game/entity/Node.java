package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Main;

import java.util.ArrayList;

public class Node {

    private Vector2 position;
    private int size;
    private float f;
    private float g;
    private float h;
    private Node previous;
    private ArrayList<Node> neighbours;
    private boolean wall = false;


    public Node() {

    }
    public Node(Vector2 position) {
        this.size = (Main.WIDTH/Main.NODES_AMOUNT);
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.position = position;
        this.neighbours = new ArrayList<Node>();
        this.previous = null;



    }

    public void addNeighbours(Node[][] nodes) {
        try {
            this.neighbours.add(nodes[(int) this.position.x - 1][(int) this.position.y + 1]);
        }catch(IndexOutOfBoundsException exc) {}
        try {
            this.neighbours.add(nodes[(int) this.position.x ][(int) this.position.y + 1]);
        }catch(IndexOutOfBoundsException exc) {}
        try {
            this.neighbours.add(nodes[(int) this.position.x + 1][(int) this.position.y + 1]);
        }catch(IndexOutOfBoundsException exc) {}
        try {
            this.neighbours.add(nodes[(int) this.position.x - 1][(int) this.position.y]);
        }catch(IndexOutOfBoundsException exc) {}
        try {
            this.neighbours.add(nodes[(int) this.position.x + 1][(int) this.position.y]);
        }catch(IndexOutOfBoundsException exc) {}
        try {
            this.neighbours.add(nodes[(int) this.position.x - 1][(int) this.position.y - 1]);
        }catch(IndexOutOfBoundsException exc) {}
        try {
            this.neighbours.add(nodes[(int) this.position.x][(int) this.position.y - 1]);
        }catch(IndexOutOfBoundsException exc) {}
        try {
            this.neighbours.add(nodes[(int) this.position.x + 1][(int) this.position.y - 1]);
        }catch(IndexOutOfBoundsException exc) {}
    }


    //getters and setters
    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public float getF() {
        return f;
    }

    public void setF(float f) {
        this.f = f;
    }

    public float getG() {
        return g;
    }

    public void setG(float g) {
        this.g = g;
    }

    public float getH() {
        return h;
    }

    public void setH(float h) {
        this.h = h;
    }

    public ArrayList<Node> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(ArrayList<Node> neighbours) {
        this.neighbours = neighbours;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public boolean isWall() {
        return wall;
    }

    public void setWall(boolean wall) {
        this.wall = wall;
    }
}
