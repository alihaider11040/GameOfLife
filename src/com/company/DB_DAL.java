package com.company;

import java.sql.*;

public class DB_DAL implements DB_interface {
    static final String DB_url = "jdbc:mysql://localhost:3306/my_game_of_life";
    static final String USER_NAME = "root";
    static final String Pass = "crown$4242";

    @Override
    public void SaveGrid(Board obj) {
        try {
            Connection connection = DriverManager.getConnection(DB_url,USER_NAME,Pass );
            Statement one=connection.createStatement();
            String query= null;
            for (int i=0; i<obj.getTotalRows();i++)
            {
                for(int j=0; j<obj.getTotalCols();j++)
                {
                    //CALL SAVED_STATE_VALUES (1,30,30,15,15,1);
                    boolean is_alive = obj.gameBoard[i][j].isAliveStatus();
                    query= "call SAVED_STATE_VALUES(" + 2+ "," + obj.getTotalRows() +"," + obj.getTotalCols() +"," + i +","+j +","+is_alive +");";
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
    public void LoadGrid() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_url,USER_NAME,Pass);
        CallableStatement game_details = connection.prepareCall("{call SAVE_INTO_GAME_RECORD_DETAILS(?,?,?,?)}");
        game_details.setInt(1,1);
        game_details.setInt(2, 10);
        game_details.setInt(3,15);
        game_details.setBoolean(4,true);
        game_details.execute();
        connection.close();
    }

    @Override
    public void delete_game_details() throws SQLException
    {
        Connection connection = DriverManager.getConnection(DB_url,USER_NAME,Pass);
        CallableStatement delete_game_details= connection.prepareCall("{call DELETE_GAME_DETAILS(?)}");
        delete_game_details.setInt(1,1);
        delete_game_details.execute();
        connection.close();
    }

    @Override
    public void delete_game_record_details() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_url,USER_NAME,Pass);
        CallableStatement delete_game_record_details =connection.prepareCall("{call DELETE_GAME_RECORD_DETAILS}");
        delete_game_record_details.setInt(1,1);
        delete_game_record_details.execute();
        connection.close();
    }

    @Override
    public void GetLexicon() throws SQLException
    {
        Connection connection = DriverManager.getConnection(DB_url,USER_NAME,Pass);
        //Statement haroon= connection.createStatement();
        //ResultSet shariq= haroon.executeQuery("select * from Lexicon");
        //while(shariq.next())
        //{
        //    shariq.getInt("Lexicon_ID");
        //}
        CallableStatement get_lexicon = connection.prepareCall(("{call GET_LEXICON(?)}"));
        get_lexicon.setInt(1,1);
        get_lexicon.execute();
        connection.close();
    }
}
