package com.company.sample;

public class terminalPrinting {

public terminalPrinting()
{
    System.out.println("hello to the terminal screen");
}

void fillarr(int size , int [][] arr)
{
    for(int i =0;i<size;i++)
    {
        for(int j=0;j<size;j++)
        {arr[i][j]= (i+j + 21)%2;}
    }
}
 void printTerminal(int size,int [][]arr)
    {
        for(int i =0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                System.out.print(" "+arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
