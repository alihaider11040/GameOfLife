package com.company;
import java.io.File;  // Import the File
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Filing_DAL implements DB_interface
{
 @Override
 public void ReadFile()
 {
          try
          {
             File myObj = new File("src/filename.txt");
             Scanner myReader = new Scanner(myObj);
             while (myReader.hasNextLine())
             {
                String data = myReader.nextLine();
                System.out.print(myReader.nextLine());
             }
             myReader.close();
          } catch (IOException e)
          {
             System.out.println("An error occurred.");
             e.printStackTrace();
          }
 }

    @Override
    public void SaveGrid(Board obj) {
        try
        {
            FileWriter write = new FileWriter("src/filename1.txt");
            cell[][] board = obj.getGameBoard();
            for (int i = 0; i < obj.rows; i++) {
                for (int j = 0; j < obj.cols; j++) {
                    // save alivestatus in file
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
    public void LoadGrid() throws SQLException
    {

    }

    @Override
    public void delete_game_details() throws SQLException {

    }

    @Override
    public void delete_game_record_details() throws SQLException {

    }

    @Override
    public void GetLexicon() throws SQLException {

    }
}
