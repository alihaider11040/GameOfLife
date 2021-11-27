package com.company.Filing;
import com.company.BL.DB_interface;
import  com.company.BL.Board;
import com.company.BL.cell;


import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

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
                    write.write(String.valueOf(board[i][j].isAliveStatus()));
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
        try
        {

            Scanner reader = new Scanner(new FileReader("src/save_grid.txt"));
            Board object = new Board();
            object.

            /*if(Grid_ID != 0)
            {
                while (reader.hasNextLine())
                {
                    String data = reader.nextLine();
                    System.out.println(data);
                }
            }*/

            reader.close();
        } catch (FileNotFoundException e)
        {
            System.out.print("File not FOUND");
            e.printStackTrace();
        }

    }

    @Override
    public void delete_saved_state(int Grid_ID) throws SQLException {
        try
        {
            FileWriter write1 = new FileWriter("src/save_grid.txt");
            Board obj = new Board();
            cell[][] board = obj.getGameBoard();

            for (int i = 0; i < obj.rows; i++)
            {
                for (int j = 0; j < obj.cols; j++) {
                    if (Grid_ID == (i * j))
                        write1.write("-");
                    else if ((Grid_ID == i) || (Grid_ID == j))
                        write1.write("-");
                }
                write1.write("\n");
                // end line
            }
            write1.close();
        } catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void Save_game_details(Board obj)
    {
        try
        {
            FileWriter write1 = new FileWriter("src/save_details_grid.txt");
            cell[][] board = obj.getGameBoard();
            for (int i = 0; i < obj.rows; i++)
            {
                for (int j = 0; j < obj.cols; j++)
                {
                    write1.write(String.valueOf(board[i][j].isAliveStatus()));
                    write1.write(" ");
                }
                write1.write("\n");
                // end line
            }
            write1.close();
        } catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void  load_game_details(int Game_ID)//dstring
    {
        try
        {
            FileReader read1 = new FileReader("src/save_details_grid.txt");//Gsmrid.txt
            Scanner reader1 = new Scanner(read1);
            Board obj1 = new Board();
            cell[][] board = obj1.getGameBoard();

            if(Game_ID != 0)
            {
                while (reader1.hasNextLine())
                {
                    for (int i = 0; i < obj1.rows; i++)
                    {
                        for (int j = 0; j < obj1.cols; j++)
                        {
                            String data = reader1.nextLine();
                            if(board[i][j].isAliveStatus())
                                System.out.println(data);
                            else
                                System.out.println("0");
                        }
                    }
                }
            }

            reader1.close();
        } catch (FileNotFoundException e)
        {
            System.out.print("File not FOUND");
            e.printStackTrace();
        }
    }
}