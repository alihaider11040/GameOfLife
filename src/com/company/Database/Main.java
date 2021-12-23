package com.company.Database;

import com.company.BL.Board;

import java.sql.SQLException;

public class Main {
    public static void main(String args[]) throws SQLException
    {
        Board obj = new Board(5,5);
       DB_DAL dal = new DB_DAL();
       dal.Save_game_details(1,obj);
       dal.load_game_details(1);
       dal.delete_saved_state(1);
    }
}
