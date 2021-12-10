package com.company.BL;

import com.company.BL.Board;
import com.company.BL.lexicon;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public interface DB_interface
{
    public void delete_saved_state(int Grid_ID) throws SQLException;
    public void Save_game_details(int Game_ID, Board obj);
    public Board load_game_details(int Game_ID) throws SQLException;

    Board load_game_details(int Game_ID, int size);

    Board load_game_details(int Game_ID, int r, int c) throws FileNotFoundException;
}
