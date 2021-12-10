package com.company.Filing;
import com.company.BL.DB_interface;
import  com.company.BL.Board;
import com.company.BL.cell;


import java.io.*;
import java.sql.SQLException;
import java.util.Scanner;

public class Filing_DAL implements DB_interface
{



    @Override
    public void delete_saved_state(int Grid_ID) throws SQLException
    {
        try
        {
            FileWriter write1 = new FileWriter(Integer.toString(Grid_ID) + ".txt");
            Board obj = new Board();
            cell[][] board = obj.getGameBoard();

            for (int i = 0; i < obj.getTotalRows(); i++)
            {
                for (int j = 0; j < obj.getTotalCols(); j++)
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
            FileWriter write1 = new FileWriter(Integer.toString(Game_ID) + ".txt");
            cell[][] board = obj.getGameBoard();
            for (int i = 0; i < obj.getTotalRows(); i++)
            {
                for (int j = 0; j < obj.getTotalCols(); j++)
                {
                    if(board[i][j].isAliveStatus())
                    {
                        write1.write('1');
                    }
                    else if(!board[i][j].isAliveStatus())
                    {
                        write1.write('0');
                    }
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
    public Board load_game_details(int Game_ID) throws SQLException {
        return null;
    }

    @Override
    public Board load_game_details(int Game_ID, int size) {
        return null;
    }


    @Override
    public Board load_game_details(int Game_ID, int r, int c) throws FileNotFoundException {
       // System.out.println(2);
        Board b1 = new Board(r, c);
        //int[][] dice = new int[r][c];
        //File myObj = new File(Integer.toString(Game_ID)+".txt");
        //Scanner myReader = null;
        //try {
          //  myReader = new Scanner(myObj);
        //} catch (FileNotFoundException e) {
          //  e.printStackTrace();
        //}
        //for (int i = 0; i < r; i++) {
          //  for (int j = 0; j < c; j++) {
            //    System.out.println(1);
              //  dice[i][j] = myReader.nextInt();
                //if (dice[i][j] == 0) {
                  //  b1.getGameBoard()[i][j].updateStatus(false);
                    //int aliveNeighbourCount = 0;
                    //for(int m= i-1;m<=i+1;m++) {
                      //  for (int n = j - 1; n <= j + 1; n++) {
                        //    if ((m >= 0 && m < b1.getTotalRows()) && (n >= 0 && n < b1.getTotalCols())) {
                          //      if (b1.getGameBoard()[m][n].isAliveStatus() == true) {
                            //        aliveNeighbourCount++;
                              //  }
                            //}
                        //}

                    //}
                    //if(aliveNeighbourCount ==2 || aliveNeighbourCount == 3)
                    //{
                      //  b1.getGameBoard()[i][j].updateStatus(true);
                    //}
                    //}
                   // else {
                    //b1.getGameBoard()[i][j].updateStatus(true);
                    //int aliveNeigbourCount = 0;
                    //for (int m = -1; m < 2; m++) {
                     //   for (int n = 0; n < 2; n++) {
                       //     if (dice[i + m][j + n] == 1) {
                         //       aliveNeigbourCount++;
                           // }
                        //}
                   // }
                    //if (aliveNeigbourCount < 2 || aliveNeigbourCount > 3) {
                      //  b1.getGameBoard()[i][j].updateStatus(false);
                   // }
               // }
                //myReader.close();
        //    }
       // }
  // new implementation//

        Scanner input = new Scanner(new File(Integer.toString(Game_ID)+".txt"));

        while (input.hasNextInt()) {

            // This should be here to get size of array before getting each array


            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {

                    try{
                        if( input.nextInt()==0){
                         b1.getCell(i,j).setAliveStatus(false);
                        }else{
                            b1.getCell(i,j).setAliveStatus(true);
                        }

                    }
                    catch (java.util.NoSuchElementException e) {
                         e.printStackTrace();
                    }
                }
            }

        }






        b1.printBoard();
        return b1;
    }
}