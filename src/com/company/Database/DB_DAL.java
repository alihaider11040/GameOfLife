package com.company.Database;

import com.company.BL.Board;
import com.company.BL.DB_interface;
import com.mysql.cj.result.Row;

import java.net.ConnectException;
import java.sql.*;

public class DB_DAL implements DB_interface
{
    static final String DB_url = "jdbc:mysql://localhost:3306/my_Game_of_life";
    static final String USER_NAME = "root";
    static final String Pass = "crown$4242";
    @Override
    public void delete_saved_state(int Grid_ID) throws SQLException
    {
        Connection connection = DriverManager.getConnection(DB_url,USER_NAME,Pass);
        Statement one= connection.createStatement();
        String del_query= "call DELETE_SAVED_STATE" + "("+ Grid_ID +" );";
        one.executeQuery(del_query);
        connection.close();
    }
    @Override
    public void Save_game_details(int Game_ID, Board obj)
    {
        try
        {
            Connection connection = DriverManager.getConnection(DB_url,USER_NAME,Pass);
            Statement one = connection.createStatement();
            String query = null;
           // String game_details_query = "call SAVE_INTO_GAME_DETAILS (" + Game_ID + "," + obj.getSpeed() + "," +obj.get_zoom() + "," + obj.getTotalRows() + " ," + obj.getTotalCols() + ");" ;
         //   one.executeQuery(game_details_query);
            connection.close();
        }
         catch (SQLException e)
         {
            e.printStackTrace();
         }
    }
    @Override
    public Board load_game_details(int Game_ID) throws SQLException
    {
        Board obj= new Board();
        Connection connection = DriverManager.getConnection(DB_url,USER_NAME,Pass);
        Statement one = connection.createStatement();
        String query= "call GET_GAME_DETAILS" + "("+ Game_ID +" );";
        ResultSet query_result = one.executeQuery(query);
        query_result.next();
        int G_ID = query_result.getInt(1);
        int speed= query_result.getInt(2);
        int zoom= query_result.getInt(3);
        int r= query_result.getInt(4);
        int c= query_result.getInt(5);
        obj.setRows(r);
        obj.setCols(c);
        obj.setSpeed(speed);
        obj.setZoom(zoom);
        obj.setBoard_ID(G_ID);
        return obj;
    }
    @Override
    public Board load_game_details(int Game_ID, int size) {
        return null;
    }
    @Override
    public Board load_game_details(int Game_ID, int r, int c) {
        return null;
    }
}
