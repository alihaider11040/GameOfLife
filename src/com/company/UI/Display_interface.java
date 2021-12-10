package com.company.UI;

import com.company.BL.Board;

import java.sql.SQLException;

public interface Display_interface {
    public void SaveGrid(Board obj);
    public void print(Board obj) throws Exception;
    public Board LoadGrid(int Grid_ID) throws SQLException;
    public void delete_saved_state(int Grid_ID) throws SQLException;
    public void Save_game_details(int Game_ID, Board obj);
    public Board load_game_details(int Game_ID) throws SQLException;
}
