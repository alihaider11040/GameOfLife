package com.company.UI;
import com.company.BL.Board;
import com.company.sample.Main;
public class terminalPrinting {

public terminalPrinting()
{
    System.out.println("hello to the terminal screen");
}
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
/*public void fillarr(int size , Board[][] arr)
{
    for(int i =0;i<size;i++)
    {
        for(int j=0;j<size;j++)
        {arr[i][j]= (i+j + 21)%2;}
    }
}*/
 public void printTerminal(int size,Board arr)
    {
        for(int i =0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(arr.getGameBoard()[i][j].isAliveStatus()== true)
                System.out.print(" "+ 0 + " ");
                else System.out.print(ANSI_RED+" 0 "+ANSI_RESET);
            }
            System.out.println();
        }
    }
}
