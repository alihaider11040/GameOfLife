package com.company.Database;

import com.company.BL.Board;
import com.company.BL.DB_interface;

import java.sql.*;

public class DB_DAL implements DB_interface {
    static final String DB_url = "jdbc:mysql://localhost:3306/my_game_of_life";
    static final String USER_NAME = "root";
    static final String Pass = "crown$4242";
    @Override
    public void SaveGrid(int Game_ID,Board obj)
    {
        try {
            Connection connection = DriverManager.getConnection(DB_url, USER_NAME, Pass);
            Statement one = connection.createStatement();
            String query = null;
            for (int i = 0; i < obj.getTotalRows(); i++) {
                for (int j = 0; j < obj.getTotalCols(); j++)
                {
                    //CALL SAVED_STATE_VALUES (1,30,30,15,15,1);
                    boolean is_alive = obj.gameBoard[i][j].isAliveStatus();
                    query = "call SAVED_STATE_VALUES(" + Game_ID + ","  + i + "," + j + "," + is_alive + ");";
                    one.executeQuery(query);
                }
            }
            connection.close();
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }
    @Override
    public Board LoadGrid(int Grid_ID) throws SQLException
    {
        Board obj =new Board();
        Connection connection = DriverManager.getConnection(DB_url,USER_NAME,Pass);
        Statement one=connection.createStatement();
        String query= "call LOAD_SAVED_STATE" + "("+ Grid_ID +" );";
        ResultSet query_result = one.executeQuery(query);
        while(query_result.next())
        {
            System.out.println(query_result.getString(1)+ " "+query_result.getString(2)+ " "+query_result.getString(3)+ " "+query_result.getString(4));
        }
        connection.close();
        return obj;
    }
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
    public void Save_game_details(Board obj)
    {
        try
        {
            Connection connection = DriverManager.getConnection(DB_url,USER_NAME,Pass);
            Statement one = connection.createStatement();
            String query = null;
            String game_details_query = "call SAVE_INTO_GAME_DETAILS (" + 2 + "," + 20 + "," + 30 + "," + obj.getTotalRows() + " ," + obj.getTotalCols() + ");" ;
            one.executeQuery(game_details_query);
            connection.close();
        }
         catch (SQLException e)
         {
            e.printStackTrace();
         }

    }
    @Override
    public void load_game_details(int Game_ID) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_url,USER_NAME,Pass);
        Statement one = connection.createStatement();
        String query= "call GET_GAME_DETAILS" + "("+ Game_ID +" );";
        ResultSet query_result = one.executeQuery(query);
        while(query_result.next())
        {
            System.out.println(query_result.getString(Game_ID)+ " "+query_result.getString(2)+ " "+query_result.getString(3)+ " "+query_result.getString(4)+ " "+query_result.getString(5));
        }
        connection.close();

    }
    @Override
    public void load_all_states() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_url,USER_NAME,Pass);
        Statement one = connection.createStatement();
        String query = "LOAD_ALL_SAVED_STATES";
        ResultSet load_all_query= one.executeQuery(query);
        while(load_all_query.next())
        {
            System.out.println(load_all_query.getString(1)+ " "+load_all_query.getString(2)+ " "+load_all_query.getString(3)+ " "+load_all_query.getString(4));

        }
        connection.close();
    }


}
