package com.mygdx.game.controller;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Main;
import com.mygdx.game.entity.Node;

import java.util.ArrayList;

public class DrawController {
    private ShapeRenderer shapeRenderer;

    public DrawController() {
        this.shapeRenderer = new ShapeRenderer();
        this.shapeRenderer.setAutoShapeType(true);
    }

    public void drawNodes(Node[][] nodes,int nodes_x,int nodes_y){
        this.shapeRenderer.begin();
        this.shapeRenderer.setColor(Color.BLACK);
        this.shapeRenderer.set(ShapeRenderer.ShapeType.Line);
        for(int i=0;i<nodes_x;i++) {
            for(int j=0;j<nodes_y;j++) {
                if(nodes[i][j].isWall()) this.shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
                else this.shapeRenderer.set(ShapeRenderer.ShapeType.Line);
                shapeRenderer.rect(nodes[i][j].getPosition().x* Main.NODE_SIZE,nodes[i][j].getPosition().y* Main.NODE_SIZE,
                       nodes[i][j].getSize(),nodes[i][j].getSize());
               // this.shapeRenderer.circle(nodes[i][j].getPosition().x*Main.NODE_SIZE+nodes[i][j].getSize()/2,nodes[i][j].getPosition().y*Main.NODE_SIZE+1+nodes[i][j].getSize()/2,nodes[i][j].getSize()/2);

            }
        }
        shapeRenderer.end();
    }

    public void drawNodeSet(ArrayList<Node> openSet,Color color) {

        this.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        this.shapeRenderer.setColor(color);
        for (Node node:openSet) {
            this.shapeRenderer.rect(node.getPosition().x*Main.NODE_SIZE,node.getPosition().y*Main.NODE_SIZE+1,node.getSize()-1,node.getSize()-1);
           // this.shapeRenderer.circle(node.getPosition().x*Main.NODE_SIZE+node.getSize()/2,node.getPosition().y*Main.NODE_SIZE+1+node.getSize()/2,node.getSize()/2);
        }
        this.shapeRenderer.end();
    }





}
