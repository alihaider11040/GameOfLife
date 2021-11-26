package com.company.BL;

import com.company.BL.Board;
import com.company.BL.lexicon;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public interface DB_interface
{
    public void SaveGrid(int Game_ID,Board obj) throws FileNotFoundException;
    public Board LoadGrid(int Grid_ID) throws SQLException, FileNotFoundException;
    public void delete_saved_state(int Grid_ID) throws SQLException;
    public void Save_game_details(Board obj);
    public void load_game_details(int Game_ID) throws SQLException;


}