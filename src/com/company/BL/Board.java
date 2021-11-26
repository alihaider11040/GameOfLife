package com.company.BL;

public class Board {
    // here we will add cell class

    public boolean dataBase_Flag=true;
    public int rows;
    public int cols;
    public cell[][] gameBoard;
    public boolean stateRun;

    public Board()
    {
        rows=0;
        cols=0;
        stateRun=false;
    }
    public Board(int r, int c)
    {
        rows=r;
        cols=c;
        stateRun=false;
        gameBoard=new cell[r][c];
        for(int i=0; i<rows; i++)
        {

            for(int j=0; j<cols;j++)
            {

                gameBoard[i][j]=new cell(i,j,false);
            }
        }
    }
    public int getTotalRows()
    {
        return rows;
    }
    public int getTotalCols()
    {
        return cols;
    }
    public cell[][] getGameBoard() {
        return gameBoard;
    }
}
