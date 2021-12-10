package com.company.BL;

public class Board {
    // here we will add cell class

    boolean dataBase_Flag = true;
    int rows;
    int cols;
    cell[][] gameBoard;
    boolean stateRun;
    int speed;
    int Board_ID;
    boolean alive;
    int zoom;


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

    public void set_StateRun(boolean s) {
        stateRun = s;
    }

    public boolean get_StateRun() {
        return stateRun;
    }

    public cell[][] getGameBoard() {
        return gameBoard;
    }

    public void fillBoard() {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == 2 || i == 3) && (j == 2 || j == 3 || j == 1)) {
                    gameBoard[i][j].updateStatus(true);
                } else {
                    gameBoard[i][j].updateStatus(false);
                }
            }
        }
    }

    public void makeAlive() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                gameBoard[i][j].aliveStatus = true;
                //gameBoard[i][j].updateStatus(true);
            }
        }
    }

    public void makeDead() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                gameBoard[i][j].aliveStatus = false;
                //gameBoard[i][j].updateStatus(false);
            }
        }
    }

    public void updateStatus(boolean stat) {

    }

    public boolean getStatus(int i, int j) {
        return gameBoard[i][j].isAliveStatus();
    }

    public cell getCell(int r, int c) {
        return gameBoard[r][c];
    }

    public int getSpeed() {
        return speed;
    }

    public void setZoom_1(int z) {
        zoom = z;
    }

    public int getZoom_1() {
        return zoom;
    }

    public void setRows(int r) {
        rows = r;
    }

    public void setCols(int c) {
        cols = c;
    }

    public void setSpeed(int s) {
        speed = s;
    }

    public void setZoom(int z) {
        zoom = z;
    }

    public int getBoard_ID() {
        return Board_ID;
    }

    public int getCount() {
        return 5;
    }

    public void setBoard_ID(int board_ID) {
        Board_ID = board_ID;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (gameBoard[i][j].isAliveStatus() == true) {
                    System.out.print(" " + 1 + " ");
                } else System.out.print(" " + 0 + " ");
            }
            System.out.println();
        }
    }

    int count(int row, int cols) {
        int countt = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = cols - 1; j <= cols + 1; j++) {
                if (i != rows || j != cols) {
                    countt += (getState(i, j)) ? 1 : 0;
                }
            }
        }
        return countt;
    }

    public boolean getState(int row, int cols) {
        if (row < 0 || row >= this.rows) return false;
        if (cols < 0 || cols >= this.cols) return false;
        return this.getGameBoard()[row][cols].isAliveStatus();
    }

    public void PlayOn() {


        Board temp = new Board(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int aliveNeighborCount = 0;
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        if ((k >= 0 && k < this.getTotalRows()) && (l >= 0 && l < this.getTotalCols())) {
                            if (temp.getGameBoard()[k][l].isAliveStatus() == true && k != i && l != j) {
                                aliveNeighborCount++;
                            }
                        }
                    }
                }
                if (temp.getGameBoard()[i][j].isAliveStatus() == true && (aliveNeighborCount == 2 || aliveNeighborCount == 3)) {
                    this.getGameBoard()[i][j].updateStatus(true);
                } else if (aliveNeighborCount == 3) {
                    this.getGameBoard()[i][j].updateStatus(true);
                }
            }
        }
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {


                int aliveNeighbourCount = 0;
                for (int m = i - 1; m <= i + 1; m++) {
                    for (int n = j - 1; n <= j + 1; n++) {
                        if ((m >= 0 && m < temp.getTotalRows()) && (n >= 0 && n < temp.getTotalCols())) {
                            if (temp.getGameBoard()[m][n].isAliveStatus() == true) {
                                aliveNeighbourCount++;
                            }
                        }
                    }

                }
                if (aliveNeighbourCount == 3) {
                    this.getGameBoard()[i][j].updateStatus(true);
                } else if (this.getGameBoard()[i][j].isAliveStatus() == alive && (aliveNeighbourCount < 2 || aliveNeighbourCount > 3)) {
                    this.getGameBoard()[i][j].updateStatus(false);
                }


                else {
                    temp.getGameBoard()[i][j].updateStatus(true);
                    int aliveNeigbourCount = 0;
                    for (int m = i-1; m <= i+1; m++) {
                        for (int n = j-1; n <=j+1; n++) {
                            if ((m >= 0 && m < temp.getTotalRows()) && (n >= 0 && n < temp.getTotalCols()))
                            {
                                if (temp.getGameBoard()[m][n].isAliveStatus() == true)
                                {
                                    aliveNeighbourCount++;
                                }
                            }
                        }
                    }


                }
            }
    }
}

