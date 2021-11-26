package com.company;

import java.sql.*;

public class DB_DAL implements DB_interface {
    static final String DB_url = "jdbc:mysql://localhost:3306/my_game_of_life";
    static final String USER_NAME = "root";
    static final String Pass = "crown$4242";


    @Override
    public void SaveGrid(Board obj) {
        try {
            Connection connection = DriverManager.getConnection(DB_url, USER_NAME, Pass);
            Statement one = connection.createStatement();
            String query = null;
            for (int i = 0; i < obj.getTotalRows(); i++) {
                for (int j = 0; j < obj.getTotalCols(); j++) {
                    //CALL SAVED_STATE_VALUES (1,30,30,15,15,1);
                    boolean is_alive = obj.gameBoard[i][j].isAliveStatus();
                    query = "call SAVED_STATE_VALUES(" + 2 + "," + obj.getTotalRows() + "," + obj.getTotalCols() + "," + i + "," + j + "," + is_alive + ");";
                    one.executeQuery(query);
                }
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    @Override
    public void LoadGrid(int Grid_ID) throws SQLException
    {
        Connection connection = DriverManager.getConnection(DB_url,USER_NAME,Pass);
        Statement one=connection.createStatement();
        String query= "call LOAD_SAVED_STATE" + "("+ Grid_ID +" );";
        ResultSet query_result = one.executeQuery(query);
        while(query_result.next())
        {
            System.out.println(query_result.getString(1)+ " "+query_result.getString(2)+ " "+query_result.getString(3)+ " "+query_result.getString(4)+ " "+query_result.getString(5)+ " "+query_result.getString(6));
        }
        connection.close();
    }
    @Override
    public void delete_saved_state(int Grid_ID) throws SQLException
    {
        Connection connection = DriverManager.getConnection(DB_url,USER_NAME,Pass);
        Statement one= connection.createStatement();
        String del_query= "call DELETE_SAVED_STATE" + "("+ Grid_ID +" );";
        one.executeQuery(del_query);
        connection.close();
        //..
    }
    @Override
    public void GetLexicon() throws SQLException
    {

    }
}
