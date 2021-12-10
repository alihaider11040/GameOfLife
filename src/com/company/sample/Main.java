//package com.company.sample;
package com.company.sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.company.BL.Board;
import com.company.UI.terminalPrinting;
import java.util.Scanner;
import java.lang.Thread;

import com.company.BL.factory;
import com.company.UI.Button_extended;
import com.company.BL.Board;
import com.company.Database.DB_DAL;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

//import static jdk.vm.ci.sparc.SPARC.g1;


// main is child of application
public class Main extends Application {
    factory fact=new factory();
    com.company.BL.Board gameBoard=  fact.getBoard();
    //com.company.BL.Board gameBoard.fillBoard();
    int i=0,j=0;
    int zizo;
    Stage window;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        Board obj=new Board();
        int row = 20;
        int col = 73;
        Button bt1 = new Button("  Start  ");
        Button bt2 = new Button("  Stop  ");
        Button bt3 = new Button("  Next  ");
        Button bt4 = new Button(" Save ");
        Button bt5 = new Button(" Reset ");
        Button bt6 = new Button("View State");
        Button bt7 = new Button("  Load  ");
        Button bt8=new Button(" Speed + ");
        Button bt9=new Button(" Speed - ");
        Button zoomIN = new Button(" ZOOM + ");
        Button zoomOUT = new Button(" ZOOM - ");
        bt1.setMinWidth(30);
        bt2.setMinWidth(30);
        bt3.setMinWidth(30);
        bt4.setMinWidth(30);
        bt5.setMinWidth(30);
        bt6.setMinWidth(30);
        bt7.setMinWidth(50);
        bt8.setMinWidth(30);
        bt9.setMinWidth(30);
        zoomIN.setMinWidth(30);
        zoomOUT.setMinWidth(30);


        ///// set ID to control buttons///
        bt1.setId("start");
        bt2.setId("stop");
        bt3.setId("next");
        bt4.setId("save");
        bt5.setId("reset");
        bt6.setId("view");
        bt7.setId("load");
        bt8.setId("speed_up");
        bt9.setId("speed_down");
        zoomIN.setId("zoomIN");
        zoomOUT.setId("zoomOUT");

        /////////////////////// Grid ///////////////
        GridPane g1 = new GridPane();
        GridPane b1 = new GridPane();
        GridPane finalGrid = new GridPane();

        RowConstraints labell = new RowConstraints();
        labell.setPercentHeight(5);

        RowConstraints  boardd = new RowConstraints();
        boardd.setPercentHeight(80);

        RowConstraints buttonss = new RowConstraints();
        buttonss.setPercentHeight(15);
        finalGrid.getRowConstraints().addAll(labell,boardd,buttonss);
        g1.setId("grid");
        ///////////////////////// Event handler //////////////////
        start_event(bt1, obj);
        stop_event(bt2,obj);
        next_event(bt3,obj);
        save_event(bt4,obj);
        reset_event(bt5,obj);
        view_event(bt6,obj);
        load_event(bt7,obj);
        speed_up_event(bt8,obj);
        speed_down_event(bt9,obj);
        zoom_in_event(zoomIN,obj,g1);
        zoom_out_event(zoomOUT,obj,g1);

        ////////////  Button to grid b1 /////////////
        add_control_on_b1_grid(b1,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,zoomIN,zoomOUT);

        //////////////// Grid g1 add cells ////////////////
        GridCells(row, col, g1);
        //////////////////// Final Grid /////////////////////////
        GridPane labelGrid = new GridPane();
        Label label = new Label("Game of Life");
        label.setPadding(new Insets(5,600,10,650));
        label.setFont(Font.font(20));
        label.setAlignment(Pos.CENTER);
        label.setId("Lable");
        labelGrid.add(label, 1, 0, 11, 1);

      //  Label count=new Label(obj.getco)

        finalGrid.add(labelGrid,0,0);
        finalGrid.add(g1, 0, 1);
        finalGrid.add(b1, 0, 2);
        finalGrid.setHgap(5);
        finalGrid.setVgap(8);
        //finalGrid.setAlignment(Pos.CENTER);
        /////////////////////// Scene //////////////////////
        Scene scene = new Scene(finalGrid, finalGrid.getMaxWidth(),finalGrid.getMaxWidth(), Color.DARKGREY);
        //link sample.css file
        //////////////////   CSS stylesheet //////////////////
        scene.getStylesheets().add(getClass().getResource("sample.css").toExternalForm());
        // adding scene to window
        window.setScene(scene);
        window.setTitle("Game of Life");
        ////////////// Show window/////////////
        window.show();

    }

    ///////////////// Grid cell function //////////////
    public void GridCells(int row, int col, GridPane g1) {

        for ( i = 0; i < row; i++) {
            for ( j = 0; j < col; j++)
            {
                Button_extended button = new Button_extended(i,j);
                ///////// set ID to Grid button/
                button.getStyleClass().add("empty_button");
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                       // button.setStyle("-fx-background-color: yellow");
                        button.getStyleClass().add("selected_button");
                        System.out.println(button.get_Row());
                       // gameBoard.
                        System.out.println(button.get_Col());
                       // obj.updateStatus(true);
                    }
                });

                //grid dragging
                button.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        g1.setPadding(new Insets(mouseEvent.getSceneY(), 0, 0, mouseEvent.getSceneX()));
                    }
                });

                //button.setStyle("-fx-background-color: grey");
                g1.add(button, j, i, 1, 1);
                g1.setPadding(new Insets(1, 1, 5, 1));
                g1.setVgap(3);
                g1.setHgap(5);
            }

        }
    }

    /////////////// Event functions /////////////////
    public void start_event(Button bt1, Board obj)
    {
        bt1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                System.out.println("start");
            }
        });
    }

    public void stop_event(Button bt2, Board obj)
    {
        bt2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("stop");
            }
        });
    }

    public void next_event(Button bt3, Board obj)
    {
        bt3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("next");
            }
        });
    }

    public void save_event(Button bt4, Board obj)
    {
        bt4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("save");
            }
        });
    }

    public void reset_event(Button bt5, Board obj)
    {
        bt5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("reset");
            }
        });
    }

    public void view_event(Button bt6, Board obj)
    {
        bt6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("view state");
            }
        });
    }

    public void load_event(Button bt7, Board obj)
    {
        bt7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("load state");
            }
        });
    }

    public void speed_up_event(Button bt8, Board obj)
    {
        bt8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("speed up");
            }
        });
    }

    public void speed_down_event(Button bt9, Board obj)
    {
        bt9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("speed down");
            }
        });
    }

    public void zoom_in_event(Button zoomIN, Board obj, GridPane g1)
    {
        zoomIN.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                g1.setScaleX(g1.getScaleX() + 1);
                g1.setScaleY(g1.getScaleY() + 1);
                zizo++;

            }
        });
    }

    public  void zoom_out_event(Button zoomOUT, Board obj, GridPane g1)
    {
        zoomOUT.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                double X = g1.getScaleX() - 1;
                if (X >= 1)
                {
                    g1.setScaleX(X);
                }
                double Y = g1.getScaleY() - 1;
                if (Y >= 1)
                {
                    g1.setScaleY(Y);
                }
            }
        });

    }

    public void add_control_on_b1_grid(GridPane b1, Button bt1, Button bt2,Button bt3,Button bt4,Button bt5,Button bt6,Button bt7, Button bt8, Button bt9 ,Button zoomIN,Button zoomOUT)
    {
        ////////////// Button addition ////////////////////
        b1.add(bt1, 5, 1, 3, 5);
        b1.add(bt2, 10, 1, 3, 5);
        b1.add(bt3, 15, 1, 3, 5);
        b1.add(bt4, 20, 1, 3, 5);
        b1.add(bt5, 25, 1, 3, 5);
        b1.add(bt6, 30, 1, 3, 5);
        b1.add(bt7, 35, 1, 3, 5);
        b1.add(bt8, 40, 1, 3, 5);
        b1.add(bt9, 45, 1, 3, 5);
        b1.add(zoomIN, 50, 1, 3, 5);
        b1.add(zoomOUT, 55, 1, 3, 4);
        b1.setHgap(8);
        b1.setVgap(3);
        b1.setId("Controls");
    }
}
///////////////////////////////////////////
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




//public class Main {
  //  public static void main(String args[])
//    {
  //      terminalPrinting t1 = new terminalPrinting();
  //      Board b1 = new Board(5,5);
    //    b1.fillBoard();
 //       while(true) {
   //         t1.printTerminal(5, b1);
     //       int x;
    //        int y = 2500;
      //      System.out.println("Press 1 to save game");
   //         System.out.println("Press 2 to load saved game");
    //        System.out.println("press 3 to speed up game");
    //        System.out.println("press 4 to slow down game");
    //        System.out.println("press 5 to go next");
    //        System.out.println("press 0 to end game");
    //        Scanner s1 = new Scanner(System.in);
    //        x = s1.nextInt();
    //        if (x == 1) {
    //            System.out.println("saving...");
    //        } else if (x == 2) {
    //            System.out.println("loading....");


     //       } else if (x == 3) {
      ///          System.out.println("speeding up");
       //         if(y>=500)
        //            y = y-500;
       //     } else if (x == 4) {
        //        System.out.println("slowing down");
        //        if(y<=5000)
        //            y=y+500;
       //     } else if (x == 5) {
       //         System.out.println("Next");
      //      } else if (x == 0) {
      //          System.out.println("Bye");
       ///         System.exit(0);
        //    }

       //     try {
       //         Thread.sleep(y);
      //      } catch (InterruptedException e) {
      //          e.printStackTrace();
      //      }
     //   }
    //}
//}