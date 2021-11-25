package com.company;

public class cell {
    int rowNum;
    int colNum;
    boolean aliveStatus;

    public cell()
    {
        rowNum=0;
        colNum=0;
        aliveStatus=false;

    }
    public cell(int r, int c)
    {
        rowNum=r;
        colNum=c;
        aliveStatus=true;
    }
    public int getRowNum()
    {
        return rowNum;
    }

    public int getColNum()
    {
        return colNum;
    }

    public boolean isAliveStatus() {
        return aliveStatus;
    }
    public void updateStatus(boolean status)
    {
        aliveStatus = status;
    }
    public void printCell()
    {
        if(aliveStatus == true)
            System.out.println("cell at " + rowNum +" "+ colNum + " is alive");
        else
            System.out.println("cell at " + rowNum +" "+ colNum + " is dead");
    }
}
