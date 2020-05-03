package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Board {

    ArrayList<ArrayList<Block>> board;
    int size;

    public Board(int size, int dim) {
        this.size = size;
        board = new ArrayList<ArrayList<Block>>();


        //board is 2D Arraylist of x by y blocks

        for(int i = 0; i < size; i++ ){
            board.add(new ArrayList<Block>());
            for (int j = 0; j < size; j++) {
                Block block = new Block(i*dim,j*dim,this);
                Rectangle r = new Rectangle(dim,dim);
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        r.setFill(Color.CORNFLOWERBLUE);
                    } else {
                        r.setFill(Color.GRAY);
                    }
                }
                if (i % 2 != 0) {
                    if (j % 2 == 0) {
                        r.setFill(Color.GRAY);
                    } else {
                        r.setFill(Color.CORNFLOWERBLUE);
                    }
                }


                block.setRect(r);
                board.get(i).add(block);
            }
        }


    }

    public ArrayList<ArrayList<Block>> getBoard() {
        return this.board;
    }
}
