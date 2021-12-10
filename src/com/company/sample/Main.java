//package com.company.sample;
package com.company.sample;
import java.lang.Object;
import java.util.EventObject;

import com.company.BL.Save;
import com.company.Filing.Filing_DAL;
import javafx.event.Event;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import com.company.BL.Board;
import com.company.BL.factory;
import com.company.UI.Button_extended;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.Scanner;
import com.company.UI.terminalPrinting;
//import static jdk.vm.ci.sparc.SPARC.g1;


// main is child of application
 class Main_1{

}

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
    public static void main(String args[])
    {
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