package com.company;
import com.company.BL.Board;
import com.company.BL.DB_interface;
import com.company.BL.cell;
import com.company.BL.lexicon;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

public class Filing_DAL implements DB_interface
{

    public void SaveGrid(Board obj) {
        try
        {
            FileWriter write = new FileWriter("src/filename1.txt");
            cell[][] board = obj.getGameBoard();
            for (int i = 0; i < obj.rows; i++) {
                for (int j = 0; j < obj.cols; j++) {

                    write.write(String.valueOf(board[i][j].aliveStatus));
                }
            }

        } catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void SaveGrid(int Game_ID, Board obj) {

    }

    @Override
    public void LoadGrid(int Grid_ID) throws SQLException {

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

    @Override
    public void Save_game_details() {

    }

    public void GetLexicon(lexicon obj) throws SQLException {

    }
}
