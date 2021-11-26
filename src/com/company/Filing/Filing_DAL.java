/*package com.company.Filing;
import com.company.BL.DB_interface;
import  com.company.BL.Board;
import com.company.BL.cell;


import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

public class Filing_DAL implements DB_interface
{
    @Override
    public void SaveGrid(int Game_ID, Board obj)
    {
        try
        {
            FileWriter write = new FileWriter("src/save_grid.txt");
            cell[][] board = obj.getGameBoard();
            for (int i = 0; i < obj.rows; i++)
            {
                for (int j = 0; j < obj.cols; j++)
                {
                    write.write(String.valueOf(Game_ID));
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
    public void LoadGrid(int Grid_ID) throws SQLException
    {
        Board obj1 = new Board();

    }

    @Override
    public void delete_saved_state(int Grid_ID) throws SQLException {

    }

    @Override
    public void Save_game_details(Board obj) {

    }

    @Override
    public void load_game_details(int Game_ID) throws SQLException {

    }
}
*/