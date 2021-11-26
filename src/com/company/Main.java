package com.company;

import com.company.BL.Board;
import com.company.BL.cell;
import com.company.Database.DB_DAL;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        //System.out.println("hello world");
        //cell c1 = new cell(12,13,false);
        //c1.printCell();
        //c1.updateStatus(false);
        //c1.printCell();

        Board obj =new Board(5,5);
        DB_DAL check = new DB_DAL();
        check.Save_game_details(obj);
        //check.SaveGrid(2, obj);
        //check.LoadGrid(1);
        check.load_game_details(1);
    }
}
