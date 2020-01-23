package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Main;
import com.mygdx.game.controller.PathFindingController;

public class Grid {
    private int nodes_x;
    private int nodes_y;
    private Node[][] nodes;
    private PathFindingController pathFindingController;
    private Node start;
    private Node end;
    private ShapeRenderer shapeRenderer;


    public Grid() {

    }
    public Grid(int w,int h) {
        this.nodes_x = w;
        this.nodes_y = h;

        this.pathFindingController = new PathFindingController();
        this.shapeRenderer = new ShapeRenderer();
        nodes = new Node[this.nodes_x][this.nodes_y];
        initNodes();
    }

    private void initNodes() {
        for(int i=0;i<this.nodes_x;i++) {
            for(int j=0;j<this.nodes_y;j++) {
                this.nodes[i][j] = new Node(com.badlogic.gdx.graphics.Color.BLACK, new Vector2(i, j));
            }
        }

        start = this.nodes[0][0];
        end = this.nodes[Main.NODES_AMOUNT-1][Main.NODES_AMOUNT-1];

        this.pathFindingController.setStart(start);




    }
    public void drawNodes() {
        this.shapeRenderer.setAutoShapeType(true);
        this.shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        for(int i=0;i<this.nodes_x;i++) {
            for(int j=0;j<this.nodes_y;j++) {

                shapeRenderer.setColor(this.nodes[i][j].getColor());
                if(this.nodes[i][j]==this.start  || this.nodes[i][j]== this.end) {
                    this.shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
                } else this.shapeRenderer.set(ShapeRenderer.ShapeType.Line);
                shapeRenderer.rect(this.nodes[i][j].getPosition().x* Main.NODE_SIZE,this.nodes[i][j].getPosition().y* Main.NODE_SIZE,
                        (float)this.nodes[i][j].getSize()-1,(float)this.nodes[i][j].getSize()-1);
            }
        }
        shapeRenderer.end();

    }


}
