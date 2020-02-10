package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Main;

public class Node {

    private Vector2 position;
    private int size;
    private float f;
    private float g;
    private float h;



    public Node() {

    }
    public Node(Vector2 position) {
        this.size = (Main.WIDTH/Main.NODES_AMOUNT);

        this.position = position;
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





}
