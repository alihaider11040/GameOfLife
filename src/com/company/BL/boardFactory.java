package com.company.BL;
import com.company.BL.Board;
import com.company.Filing.Boardfact;

public class boardFactory implements Boardfact {
    public Board getBoard(){
        Board obj=new Board(24,80);
        return obj;
    }
};




