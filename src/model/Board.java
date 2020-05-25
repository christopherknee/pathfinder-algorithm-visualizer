package model;

import UI.Main;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;
import sun.awt.image.ImageWatched;

import java.awt.event.ActionEvent;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Board {

    private Block board[][];
    private int size;
    private Boolean startReady;
    private Boolean endReady;
    private Block start;
    private Boolean arr[][];
    private Stack<Block> adjacentBlocksS;
    private Queue<Block> adjacentBlocksQ;
    private Timeline timeline;


    public Board(int size, int dim) {
        this.size = size;
        board = new Block[size][size];
        startReady = false;
        endReady = false;
        start = null;
        arr = new Boolean[size][size];
        adjacentBlocksS = new Stack<>();
        adjacentBlocksQ = new LinkedBlockingQueue<>();
        timeline = new Timeline();




        //board is 2D Arraylist of x by y blocks

        for(int i = 0; i < size; i++ ){
            for (int j = 0; j < size; j++) {
                Block block = new Block(i,j,this);
                Rectangle r = new Rectangle(dim,dim);
                initializeRect(block, r);
                board[i][j] = block;
                arr[i][j] = false;
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
        return this.board[i][j];
    }

    public Block[][] getBoard() {
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

    public Block getStart() {
        return start;
    }

    public void resetArr(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = false;
            }
        }
    }



    public void setStart(Block start) {
        this.start = start;
    }

    public void dfsFind(Block start){
        if (start == null) {
            return;
        }

        Block curr;

        adjacentBlocksS.add(start);
        while (!adjacentBlocksS.isEmpty()) {
            curr = adjacentBlocksS.pop();

            if (curr.getRect().getFill() == Color.LIGHTGREEN) {
                return;
            }

            curr.visit();

            int x = curr.getxPos();
            int y = curr.getyPos();

            arr[x][y] = true;

            Block up;
            if (y+1 < size && !arr[x][y+1]) {
                up = board[x][y+1];
                if (up != null) {
                    adjacentBlocksS.add(up);
                }
            }

            Block down;
            if (y-1 >= 0 && !arr[x][y-1]) {
                down = board[x][y-1];
                if (down != null) {
                    adjacentBlocksS.add(down);
                }
            }
            Block left;
            if (x-1 >= 0 && !arr[x-1][y]) {
                left = board[x-1][y];
                if (left != null) {
                    adjacentBlocksS.add(left);
                }
            }
            Block right;
            if (x+1 < size && !arr[x+1][y]) {
                right = board[x+1][y];
                if (right != null) {
                    adjacentBlocksS.add(right);
                }
            }
        }


    }

    public void bfsFind(Block start) {


        Block curr;

        adjacentBlocksQ.add(start);
        while (!adjacentBlocksQ.isEmpty()) {
            curr = adjacentBlocksQ.remove();

            if (curr.getRect().getFill() == Color.LIGHTGREEN) {
                adjacentBlocksQ = new LinkedBlockingQueue<>();
                return;
            }

            curr.visit();

            int x = curr.getxPos();
            int y = curr.getyPos();

            arr[x][y] = true;

            Block up;
            if (y+1 < size && x <= size) {
                if(!arr[x][y+1]) {
                    up = board[x][y+1];
                    adjacentBlocksQ.add(up);
                }
            }

            Block down;
            if (y-1 >= 0 && x <= size){
                if(!arr[x][y-1]) {
                    down = board[x][y-1];
                    adjacentBlocksQ.add(down);
                }
            }
            Block left;
            if (x-1 >= 0 && y < size) {
                if (!arr[x - 1][y]) {

                    left = board[x-1][y];
                    adjacentBlocksQ.add(left);
                }
            }
            Block right;
            if (x+1 < size && y<size){
                if( !arr[x+1][y]) {
                    right = board[x+1][y];
                    adjacentBlocksQ.add(right);

                }
            }
        }


    }


}

