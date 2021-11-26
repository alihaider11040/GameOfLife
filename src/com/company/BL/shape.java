package com.company.BL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class shape {
    cell[][] shape;
    int size;
    String name;

    public shape(int x,String n) {
        size = x;
        shape = new cell[size][size];
        name =n;
    }

    void fillShape(String filename, int size) {
        int[][] dice = new int[size][size];
        try {
            File newObj = new File(filename);
            Scanner fileReader = new Scanner(newObj);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    dice[i][j] = fileReader.nextInt();
                    if (dice[i][j] == 0) {
                        shape[i][j] = new cell(i, j, false);
                    } else {
                        shape[i][j] = new cell(i, j, true);
                    }
                    //System.out.println(dice[i][j]);
                }
            }

        }catch(FileNotFoundException e)
        {
            System.out.println("Error File not found");
            e.printStackTrace();
        }
    }

    void printShape()
    {
        for(int i = 0;i<size;i++)
        {
            for(int j =0;j<size;j++) {
                if (shape[i][j].isAliveStatus()) {
                    System.out.println(1);
                } else System.out.println(0);
            }
        }

    }
    String getName()
    {
        return name;
    }
}

