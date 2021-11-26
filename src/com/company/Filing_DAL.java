package com.company;
import java.io.File;  // Import the File
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Filing_DAL implements DB_interface
{
    @Override
    public void SaveGrid(int id ,Board obj)
    {
        try
        {
            FileWriter write = new FileWriter("src/save_grid.txt");
            cell[][] board = obj.getGameBoard();
            for (int i = 0; i < obj.rows; i++)
            {
                for (int j = 0; j < obj.cols; j++)
                {
                    write.write(String.valueOf(id));
                    write.write(" ");
                    write.write(String.valueOf(i));
                    write.write(" ");
                    write.write(String.valueOf(j));
                    write.write(" ");
                    write.write(String.valueOf(board[i][j].aliveStatus));
                    write.write("\n");
                    // end line
                }
            }
            write.close();
        } catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public Board LoadGrid( int Grid_ID) throws SQLException
    {

        return LoadGrid(Grid_ID);
    }

    @Override
    public void delete_saved_state(int Grid_ID) throws SQLException
    {

    }

    @Override
    public void GetLexicon() throws SQLException
    {

    }
}
