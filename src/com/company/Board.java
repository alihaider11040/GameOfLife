package com.company;

public class Board {
    // here we will add cell class
    int rows;
    int cols;
    cell[][] gameBoard=new cell[rows][cols];
    boolean stateRun;
    Board(){

    }
    Board(int r, int c){
        rows=r;
        cols=c;
        stateRun=false;
    }
    public cell[][] getGameBoard() {
        return gameBoard;
    }
}
