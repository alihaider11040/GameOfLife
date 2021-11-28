package com.company.BL;

public class Board {
    // here we will add cell class

    public boolean dataBase_Flag = true;
    public int rows;
    public int cols;
    public cell[][] gameBoard;
    public boolean stateRun;
    public int speed;
    public int zoom;
    public int Board_ID;
    public boolean alive;


    public Board() {
        rows = 0;
        cols = 0;
        stateRun = false;
    }
    public Board(int r, int c) {
        rows = r;
        cols = c;
        stateRun = false;
        gameBoard = new cell[r][c];
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                gameBoard[i][j] = new cell(i, j, false);
            }
        }
    }
// setter + setBoardindex(i ,j,v), make alive
    public int getTotalRows() {
        return rows;
    }
    public int getTotalCols() {
        return cols;
    }
    public cell[][] getGameBoard()
    {
        return gameBoard;
    }
    public void fillBoard() {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                gameBoard[i][j] = new cell(i, j, true);

            }
        }
    }
    public void updateStatus(boolean stat){}

    public cell getCell(int r, int c)
    {
        return gameBoard[r][c];
    }
    public int getSpeed()
    {
        return speed;
    }
    public int zoom()
    {
        return zoom;
    }
    public void setRows(int r)
    {
        rows=r;
    }
    public void setCols(int c)
    {
        cols=c;
    }
    public void setSpeed(int s)
    {
        speed=s;
    }
    public void setZoom(int z)
    {
        zoom=z;
    }

    public int getBoard_ID()
    {
        return Board_ID;
    }

    public void setBoard_ID(int board_ID)
    {
        Board_ID = board_ID;
    }
    public boolean isAlive()
    {
        return alive;
    }

    public void setAlive(boolean alive)
    {
        this.alive = alive;
    }
    public void printBoard()
    {
        for(int i =0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(gameBoard[i][j].isAliveStatus()==true)
                {
                    System.out.println(1);
                }else System.out.println(0);
            }
        }
    }
}
