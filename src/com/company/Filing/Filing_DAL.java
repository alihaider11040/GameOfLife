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
            FileWriter write = new FileWriter(Integer.toString(Game_ID) + ".txt");
            cell[][] board = obj.getGameBoard();

            for (int i = 0; i < obj.rows; i++)
            {
                for (int j = 0; j < obj.cols; j++)
                {
                    write.write(i);
                    write.write(" ");
                    write.write(j);
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
    public Board LoadGrid(int Grid_ID) throws SQLException
    {
        Board object = new Board();
        try
        {
            boolean statuss = false;
            Scanner reader = new Scanner(new FileReader(Integer.toString(Grid_ID) + ".txt"));

            while (reader.hasNextLine())
            {
                object.getCell(object.rows = reader.nextInt(), object.cols = reader.nextInt());
                if (reader.nextInt() == 1)
                {
                    statuss = true;
                }
                else if (reader.nextInt() == 0)
                {
                    statuss = false;
                }
                object.updateStatus(statuss);
            }
            reader.close();

            return object;
        } catch (FileNotFoundException e)
        {
            System.out.print("File not FOUND");
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public void delete_saved_state(int Grid_ID) throws SQLException
    {
        try
        {
            FileWriter write1 = new FileWriter(Integer.toString(Grid_ID) + ".txt");
            Board obj = new Board();
            cell[][] board = obj.getGameBoard();

            for (int i = 0; i < obj.rows; i++)
            {
                for (int j = 0; j < obj.cols; j++)
                {
                        write1.write("-");
                }
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
    public void Save_game_details(int Game_ID, Board obj)
    {
        try
        {
            FileWriter write1 = new FileWriter(Integer.toString(Game_ID) + "_2.txt");
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
    public Board load_game_details(int Game_ID)
    {
        Board obj1 = new Board();
        try
        {
            Scanner reader1 = new Scanner(new FileReader(Integer.toString(Game_ID) + "_2.txt"));
            boolean stat = false;
            int val = 0;

            while (reader1.hasNextLine())
            {
                for (int i = 0; i < obj1.rows; i++)
                {
                    for (int j = 0; j < obj1.cols; j++)
                    {
                        val = reader1.nextInt();
                        if (val == 0)
                        {
                            stat = false;
                        } else if (val == 1)
                        {
                            stat = true;
                        }
                        obj1.updateStatus(stat);
                    }
                }
            }
            reader1.close();

            return obj1;
        } catch (FileNotFoundException e)
        {
            System.out.print("File not FOUND");
            e.printStackTrace();
        }
        return obj1;
    }
}