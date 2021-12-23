package com.company.UI;
import com.company.BL.Board;
//import com.company.UI.UI_Class;
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
 public void printTerminal(int r,int c,Board arr)
    {
        for(int i =0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(arr.getGameBoard()[i][j].isAliveStatus()== true)
                System.out.print(" "+ 0 + " ");
                else System.out.print(ANSI_RED+" 0 "+ANSI_RESET);
            }
            System.out.println();
        }
    }
}
/*package com.company.sample;
import com.company.BL.Board;
import com.company.UI.terminalPrinting;
import java.util.Scanner;
import java.lang.Thread;


public class Main {
    public static void main(String args[])
    {
        terminalPrinting t1 = new terminalPrinting();
        Board b1 = new Board(5,5);
        b1.fillBoard();
        while(true) {
            t1.printTerminal(5, b1);
            int x;
            int y = 2500;
            System.out.println("Press 1 to save game");
            System.out.println("Press 2 to load saved game");
            System.out.println("press 3 to speed up game");
            System.out.println("press 4 to slow down game");
            System.out.println("press 5 to go next");
            System.out.println("press 0 to end game");
            Scanner s1 = new Scanner(System.in);
            x = s1.nextInt();
            if (x == 1) {
                System.out.println("saving...");
            } else if (x == 2) {
                System.out.println("loading....");


            } else if (x == 3) {
                System.out.println("speeding up");
                if(y>=500)
                    y = y-500;
            } else if (x == 4) {
                System.out.println("slowing down");
                if(y<=5000)
                    y=y+500;
            } else if (x == 5) {
                System.out.println("Next");
            } else if (x == 0) {
                System.out.println("Bye");
                System.exit(0);
            }

            try {
                Thread.sleep(y);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}*/