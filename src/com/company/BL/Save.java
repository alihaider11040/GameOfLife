package com.company.BL;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileNotFoundException;
public class Save {
    String filename;
    counter iCounter;
    public Save()
    {
        iCounter= new counter();
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
    public void loadBoard(String filename, int size) {
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
                        int aliveNeigbourCount=0;
                        for(int m =-1;m<2;m++)
                        {
                            for(int n =0;n<2;n++)
                            {
                                if(dice[i+m][j+n]==1)
                                {
                                    aliveNeigbourCount++;
                                }
                            }
                        }
                        if(aliveNeigbourCount==3)
                        {
                            b1.getGameBoard()[i][j].updateStatus(true);
                        }


                    } else {
                        b1.getGameBoard()[i][j].updateStatus(true);
                        int aliveNeigbourCount=0;
                        for(int m =-1;m<2;m++)
                        {
                            for(int n =0;n<2;n++)
                            {
                                if(dice[i+m][j+n]==1)
                                {
                                    aliveNeigbourCount++;
                                }
                            }
                        }
                        if(aliveNeigbourCount<2 || aliveNeigbourCount>3)
                        {
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
    }


}


