package com.company;
import java.io.File;  // Import the File
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Filing_DAL implements DB_interface
{
 @Override
 public void ReadFile()
 {
          try {
             File myObj = new File("filename.txt");
             Scanner myReader = new Scanner(myObj);
             while (myReader.hasNextLine()) {
                //String data = myReader.nextLine();
                System.out.print(myReader.nextLine());
             }
             myReader.close();
          } catch (IOException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
          }
 }
    @Override
    public void SaveGrid()
    {

    }

    @Override
    public void LoadGrid() throws SQLException {

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
