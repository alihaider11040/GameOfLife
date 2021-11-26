package com.company.Filing;
import com.company.BL.DB_interface;
import  com.company.BL.Board;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Filing_DAL implements DB_interface
{

    @Override
    public void SaveGrid(int Game_ID, Board obj) throws FileNotFoundException {


    }

    @Override
    public Board LoadGrid(int Grid_ID) throws SQLException, FileNotFoundException {
        Scanner scanner = new Scanner(new File("tall.txt"));
        int [] arr = new int [100];
        int i = 0;
        while(scanner.hasNextInt())
        {
            arr[i] = scanner.nextInt();
            System.out.println(arr[i++]);
        }
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
