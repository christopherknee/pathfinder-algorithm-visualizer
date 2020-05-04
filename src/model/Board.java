package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

import java.util.ArrayList;

public class Board {

    ArrayList<ArrayList<Block>> board;
    int size;
    private Boolean startReady;
    private Boolean endReady;

    public Board(int size, int dim) {
        this.size = size;
        board = new ArrayList<ArrayList<Block>>();
        startReady = false;
        endReady = false;


        //board is 2D Arraylist of x by y blocks

        for(int i = 0; i < size; i++ ){
            board.add(new ArrayList<Block>());
            for (int j = 0; j < size; j++) {
                Block block = new Block(i*dim,j*dim,this);
                Rectangle r = new Rectangle(dim,dim);
                initializeRect(block, r);
                board.get(i).add(block);
            }
        }


    }


    private void initializeRect(Block block, Rectangle r) {
        r.setStroke(Color.BLACK);
        r.setStrokeType(StrokeType.INSIDE);
        r.setFill(Color.CORNFLOWERBLUE);
        block.setRect(r);
    }

    public Block getBlock(int i, int j) {
        return this.board.get(i).get(j);
    }

    public ArrayList<ArrayList<Block>> getBoard() {
        return this.board;
    }

    public void setStartReady(Boolean startReady) {
        this.startReady = startReady;
    }

    public void setEndReady(Boolean endReady) {
        this.endReady = endReady;
    }

    public Boolean getStartReady() {
        return startReady;
    }

    public Boolean getEndReady() {
        return endReady;
    }
}

