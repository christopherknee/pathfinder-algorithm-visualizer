package model;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Block {
    int xPos;
    int yPos;

    ArrayList<Block> adjBlocks;
    Board board;
    Rectangle rect;

    public Block(int x, int y, Board b) {
        this.xPos = x;
        this.yPos = y;
        this.board = b;

    }

    public void setRect(Rectangle r) {
        this.rect = r;
        r.setX(getxPos());
        r.setY(getyPos());
    }

    public Rectangle getRect() {
        return this.rect;
    }



    public int getxPos() {
        return this.xPos;
    }

    public int getyPos() {
        return this.yPos;
    }



    private void intAdjBlocks(Board b) {

    }
}
