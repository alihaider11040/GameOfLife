package com.company.BL;
import com.company.Database.DB_DAL;
import com.company.Filing.Filing_DAL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
public class Save {
    String filename;


    public Save() {
        //iCounter= new counter();
        System.out.println("Hello");
    }

    public void Save_(Board obj_Board, String f) {
        filename = f;
        try {
            File myObj = new File(filename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter(filename);
            //myWriter.write();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (!obj_Board.getCell(i, j).isAliveStatus()) {
                        myWriter.write("0");
                    } else {
                        myWriter.write("1");
                    }
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

  /*  public void loadBoard(String filename, int size) {
        Board b1 = new Board(size, size);
        int[][] dice = new int[size][size];
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    dice[i][j] = myReader.nextInt();
                    if (dice[i][j] == 0) {
                        b1.getGameBoard()[i][j].updateStatus(false);
                        int aliveNeigbourCount = 0;
                        for (int m = -1; m < 2; m++) {
                            for (int n = 0; n < 2; n++) {
                                if (dice[i + m][j + n] == 1) {
                                    aliveNeigbourCount++;
                                }
                            }
                        }
                        if (aliveNeigbourCount == 3) {
                            b1.getGameBoard()[i][j].updateStatus(true);
                        }


                    } else {
                        b1.getGameBoard()[i][j].updateStatus(true);
                        int aliveNeigbourCount = 0;
                        for (int m = -1; m < 2; m++) {
                            for (int n = 0; n < 2; n++) {
                                if (dice[i + m][j + n] == 1) {
                                    aliveNeigbourCount++;
                                }
                            }
                        }
                        if (aliveNeigbourCount < 2 || aliveNeigbourCount > 3) {
                            b1.getGameBoard()[i][j].updateStatus(false);
                        }
                    }
                    myReader.close();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }*/
    public void SaveGrid(int Game_ID,Board obj)
    {
        DB_DAL db_obj = new DB_DAL();
        db_obj.SaveGrid(Game_ID, obj);
    }
    public Board loadFromDb(int Grid_ID) throws SQLException
    {
        DB_DAL obj = new DB_DAL();
        Board b1 = new Board(5, 5);
        b1.fillBoard();
        obj.delete_saved_state(Grid_ID);
        Board b2 = new Board(b1.getTotalRows(), b1.getTotalCols());
        for(int i =0;i<b1.getTotalRows();i++)
        {
            for(int j =0;j<b1.getTotalCols();j++)
            {
                int aliveNeighbourCount=0;
                if(b1.getGameBoard()[i][j].isAliveStatus()==true)
                {
                    for(int m= i-1;m<=i+1;m++)
                    {
                        for(int n = j-1;n<=j+1;n++)
                        {
                                if ((m >= 0 && m < b2.getTotalRows()) && (n >= 0 && n < b2.getTotalCols()))
                                {
                                    if (b1.getGameBoard()[m][n].isAliveStatus() == true)
                                    {
                                        aliveNeighbourCount++;
                                    }
                                }
                        }
                    }
                    if(aliveNeighbourCount < 2 || aliveNeighbourCount > 3)
                        b1.getGameBoard()[i][j].updateStatus(false);
                }
                else if(b1.getGameBoard()[i][j].isAliveStatus()== false)
                {
                    aliveNeighbourCount = 0;
                    for(int m= i-1;m<=i+1;m++)
                    {
                        for(int n = j-1;n<=j+1;n++)
                        {
                            if ((m >= 0 && m < b2.getTotalRows()) && (n >= 0 && n < b2.getTotalCols()))
                            {
                                if (b1.getGameBoard()[m][n].isAliveStatus() == true)
                                {
                                    aliveNeighbourCount++;
                                }
                            }
                        }
                    }
                    if( aliveNeighbourCount == 3)
                        b1.getGameBoard()[i][j].updateStatus(true);
                }
            }
        }
        //b2.printBoard();
        return b1;
    }
   public void saveToFile(int id, Board b1)
   {
       Filing_DAL obj1 = new Filing_DAL();
       obj1.Save_game_details(id,b1);
   }
   public void SaveStateToFile(int id,Board b1)
   {
       Filing_DAL obj1 = new Filing_DAL();
       obj1.Save_game_details(id,b1);
   }
   public Board LoadStateFromFile(int id,int r,int c) throws FileNotFoundException {
       Filing_DAL obj1 = new Filing_DAL();
       Board b1 = new Board(r,c);
       b1 = obj1.load_game_details(id,r,c);
       b1.printBoard();
       return b1;
   }
}