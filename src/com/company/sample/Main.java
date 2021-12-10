//package com.company.sample;
package com.company.sample;
import com.company.BL.Board;
import com.company.BL.Save;

import java.io.FileNotFoundException;
//import static jdk.vm.ci.sparc.SPARC.g1;


// main is child of application


//////////////////////////
/*
import com.company.BL.Board;
import com.company.Database.DB_DAL;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // belong to application class
        // static method that we inherit from parent application class
        Board obj = new Board(3, 3);
        DB_DAL dal = new DB_DAL();
        //dal.Save_game_details(1,obj);
        //dal.load_game_details(1);
        //dal.SaveGrid(6,obj);
        dal.delete_saved_state(6);
    }
*/


public class Main {
    public static void main(String args[]) throws FileNotFoundException {
      /*  terminalPrinting t1 = new terminalPrinting();
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
        }*/
        Board b1 = new Board(5,5);
        Save s1 = new Save();
        b1.fillBoard();
        s1.SaveStateToFile(55,b1);
        b1=s1.LoadStateFromFile(55,5,5);
        b1.printBoard();
    }
}