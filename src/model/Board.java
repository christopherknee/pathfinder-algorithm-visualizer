package model;

import java.util.ArrayList;

public class Board {

    ArrayList<ArrayList<Block>> board;
    int size;

    public Board(int size) {
        this.size = size;
        board = new ArrayList<ArrayList<Block>>();


        //board is 2D Arraylist of x by y blocks

        for(int i = 0; i < size; i++ ){
            board.add(new ArrayList<Block>());
            for (int j = 0; j < size; j++) {
                board.get(i).add(new Block(i,j,this));
            }
        }


    }
}
