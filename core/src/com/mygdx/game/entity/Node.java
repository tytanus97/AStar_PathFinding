package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Main;

public class Node {

    private Color color;
    private Vector2 position;
    private int size;


    public Node() {

    }
    public Node(Color color,Vector2 position) {
        this.size = Main.WIDTH/Main.NODES_AMOUNT;
        this.color = color;
        this.position = position;
    }

    public Vector2 getPosition() {
        return this.position;
    }

    public Color getColor() {
        return this.color;
    }

    public double getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
