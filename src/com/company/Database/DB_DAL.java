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

        Board new_obj= load_game_details(Grid_ID);
        Board obj= new Board(new_obj.rows, new_obj.cols);
        obj.zoom=new_obj.zoom;
        obj.speed=new_obj.speed;
        obj.setBoard_ID(new_obj.Board_ID);
        Connection con = DriverManager.getConnection(DB_url,USER_NAME,Pass);
        String load_query= "Select X_COOR, Y_COOR from SAVED_STATE WHERE Game_ID = ?" ;
        PreparedStatement preparedStatement = con.prepareStatement(load_query);
        preparedStatement.setInt(1,Grid_ID);
        ResultSet load_query_result = preparedStatement.executeQuery();
        while(load_query_result.next())
        {
            obj.gameBoard[load_query_result.getInt("X_COOR")][load_query_result.getInt("Y_COOR")].updateStatus(true);
        }
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
    public void Save_game_details(int Game_ID, Board obj)
    {
        try
        {
            Connection connection = DriverManager.getConnection(DB_url,USER_NAME,Pass);
            Statement one = connection.createStatement();
            String query = null;
            String game_details_query = "call SAVE_INTO_GAME_DETAILS (" + Game_ID + "," + obj.getSpeed() + "," +obj.zoom + "," + obj.getTotalRows() + " ," + obj.getTotalCols() + ");" ;
            one.executeQuery(game_details_query);
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
}
