package model;

import java.util.ArrayList;

public class Block {
    int xPos;
    int yPos;

    ArrayList<Block> adjBlocks;
    Board board;

    public Block(int x, int y, Board b) {
        this.xPos = x;
        this.yPos = y;
        this.board = b;

    }



    private void intAdjBlocks(Board b) {

    }
}
