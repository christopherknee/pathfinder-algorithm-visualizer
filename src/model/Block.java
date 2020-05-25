package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Block {
    int xPos;
    int yPos;

    ArrayList<Block> adjBlocks;
    Board board;                                  //Every Block has a Board it belongs to
    Rectangle rect;                               //rect is graphical representation of a Block

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

    public void visit() {
        if (getRect().getFill() != Color.LIGHTGREEN) {
            getRect().setFill(Color.ORANGERED);
        }
    }
}
