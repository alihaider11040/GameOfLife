package com.company.sample;////package com.company.sample;
//package com.company.sample;
//import java.lang.Object;
//import java.util.EventObject;
//
//import com.company.BL.Save;
//import com.company.Filing.Filing_DAL;
//import javafx.event.Event;
//import javafx.scene.input.InputEvent;
//import javafx.scene.input.MouseEvent;
//import com.company.BL.Board;
//import com.company.BL.factory;
//import com.company.UI.Button_extended;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.RowConstraints;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.stage.Stage;
//import java.util.Scanner;
//import com.company.UI.terminalPrinting;
////import static jdk.vm.ci.sparc.SPARC.g1;
//
//
//// main is child of application
// class Main_1{
//
//}
//
////////////////////////////
///*
//import com.company.BL.Board;
//import com.company.Database.DB_DAL;
//
//import java.sql.SQLException;
//
//public class Main {
//    public static void main(String[] args) throws SQLException {
//        // belong to application class
//        // static method that we inherit from parent application class
//        Board obj = new Board(3, 3);
//        DB_DAL dal = new DB_DAL();
//        //dal.Save_game_details(1,obj);
//        //dal.load_game_details(1);
//        //dal.SaveGrid(6,obj);
//        dal.delete_saved_state(6);
//    }
//*/
import java.util.Scanner;
import com.company.UI.terminalPrinting;
import com.company.BL.Board;
import com.company.BL.Save;

public class Main {
    public static void main(String args[])
    {
        int r = 15;
        int c = 40;
        terminalPrinting t1 = new terminalPrinting();
        Board b1 = new Board(r,c);
        Save sav1 = new Save();
        b1.fillBoard();
        while(true) {
            t1.printTerminal(r,c ,b1);
            int x;
            int time = 2500;
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
                sav1.SaveStateToFile(79,b1);
            } else if (x == 2) {
                System.out.println("loading....");
                sav1.LoadStateFromFile(79,r,c);

            } else if (x == 3) {
               System.out.println("speeding up");
                if(time>=500)
                    time = time-500;
            } else if (x == 4) {
                System.out.println("slowing down");
                if(time<=5000)
                    time=time+500;
            } else if (x == 5) {
                System.out.println("Next");
            } else if (x == 0) {
                System.out.println("Bye");
                System.exit(0);
            }

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            b1.PlayOn();
        }


    }
}