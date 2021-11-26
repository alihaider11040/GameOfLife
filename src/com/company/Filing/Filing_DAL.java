package com.company.Filing;
import com.company.BL.DB_interface;
import  com.company.BL.Board;


import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

public class Filing_DAL implements DB_interface
{

    @Override
    public void SaveGrid(int Game_ID, Board obj)
    {

    }
    @Override
    public Board LoadGrid(int Grid_ID) throws SQLException
    {

    }

    @Override
    public void delete_saved_state(int Grid_ID) throws SQLException
    {

    }

    @Override
    public void Save_game_details(Board obj)
    {

    }

    @Override
    public void load_game_details(int Game_ID) throws SQLException
    {

    }
    @Override
    public void load_all_states() throws SQLException
    {

    }
}
