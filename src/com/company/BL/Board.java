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
    public void set_StateRun(boolean s){stateRun=s; }
    public boolean get_StateRun(){return stateRun;}

    public cell[][] getGameBoard()
    {
        return gameBoard;
    }
    public void fillBoard() {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if((i==2 || i==3) && (j ==2 || j==3|| j== 1))
                {gameBoard[i][j].updateStatus(true);}
                else {gameBoard[i][j].updateStatus(false);}
            }
        }
    }
    public void makeAlive(){
        for (int i = 0; i < rows;i++){
            for(int j = 0; j < cols;j++){
                gameBoard[i][j].aliveStatus = true;
               //gameBoard[i][j].updateStatus(true);
            }
        }
    }

    public void makeDead(){
        for(int i = 0;i<rows;i++){
            for (int j=0;j<cols;j++){
                gameBoard[i][j].aliveStatus = false;
                //gameBoard[i][j].updateStatus(false);
            }
        }
    }
    public void updateStatus(boolean stat){

    }
    public boolean getStatus(int i,int j){
        return gameBoard[i][j].isAliveStatus();
    }
    public cell getCell(int r, int c)
    {
        return gameBoard[r][c];
    }
    public int getSpeed()
    {
        return speed;
    }
    //public int zoom()
    //{
      //  return zoom;
    //}
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

    //public int getBoard_ID(int i ,int j){
        
    //}
  //  {
//        return Board_ID();
    //}
public int getCount(){return 5;}
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
                    System.out.print(" "+1+" ");
                }else System.out.print(" "+0+" ");
            }
            System.out.println();
        }
    }
    public void PlayOn()
    {
        Board temp = new Board(rows,cols);
        for(int i = 0;i<rows;i++)
        {
            for(int j =0;j<cols;j++)
            {
                temp.getGameBoard()[i][j]= this.getGameBoard()[i][j];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {


                int aliveNeighbourCount = 0;
                for (int m = i - 1; m <= i + 1; m++) {
                    for (int n = j - 1; n <= j + 1; n++) {
                        if ((m >= 0 && m < this.getTotalRows()) && (n >= 0 && n < this.getTotalCols())) {
                            if (temp.getGameBoard()[m][n].isAliveStatus() == true) {
                                aliveNeighbourCount++;
                            }
                        }
                    }

                }
                if (aliveNeighbourCount == 2 || aliveNeighbourCount == 3) {
                    this.getGameBoard()[i][j].updateStatus(true);
                } else {
                    temp.getGameBoard()[i][j].updateStatus(true);
                    int aliveNeigbourCount = 0;
                    for (int m = i-1; m <= i+1; m++) {
                        for (int n = j-1; n <=j+1; n++) {
                            if ((m >= 0 && m < this.getTotalRows()) && (n >= 0 && n < this.getTotalCols()))
                            {
                                if (temp.getGameBoard()[m][n].isAliveStatus() == true)
                                {
                                    aliveNeighbourCount++;
                                }
                            }
                        }
                    }
                    if (aliveNeigbourCount < 2 || aliveNeigbourCount > 3) {
                        this.getGameBoard()[i][j].updateStatus(false);
                    }

                }
            }
        }
    }
}
