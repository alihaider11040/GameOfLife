///*//package com.company.sample;
//package com.company.sample;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//import com.company.BL.factory;
//import com.company.UI.Button_extended;
//import com.company.BL.Board;
//import com.company.Database.DB_DAL;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.fxml.FXMLLoader;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Group;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.Slider;
//import javafx.scene.control.ScrollBar;
//import javafx.scene.control.TextField;
//import javafx.scene.image.Image;
//import javafx.scene.input.KeyCombination;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.*;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontPosture;
//import javafx.scene.text.FontWeight;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//import javafx.stage.Window;
//
//import javax.swing.*;
//import java.awt.*;
//import java.sql.SQLException;
//
////import static jdk.vm.ci.sparc.SPARC.g1;
//
//
//// main is child of application
//public class Main extends Application {
//    factory fact=new factory();
//    com.company.BL.Board gameBoard=  fact.getBoard();
//    //com.company.BL.Board gameBoard.fillBoard();
//    int i=0,j=0;
//    int zizo;
//    Stage window;
//
//    @Override
//    public void start(Stage stage) throws Exception {
//        window = stage;
//        int row = 20;
//        int col = 73;
//        Button bt1 = new Button("Start");
//        Button bt2 = new Button("Stop");
//        Button bt3 = new Button("Next");
//        Button bt4 = new Button("Save");
//        Button bt5 = new Button("Reset");
//        Button bt6 = new Button("View Save State");
//        Button bt7 = new Button("Load");
//        Button zoomIN = new Button("ZOOM-IN +");
//        Button zoomOUT = new Button("ZOOM-OUT -");
//
//        ///// set ID to control buttons///
//        bt1.setId("start");
//        bt2.setId("stop");
//        bt3.setId("next");
//        bt4.setId("save");
//        bt5.setId("reset");
//        bt6.setId("view");
//        bt7.setId("load");
//        zoomIN.setId("zoomIN");
//        zoomOUT.setId("zoomOUT");
//
//        /////////////////////// Grid ///////////////
//        GridPane g1 = new GridPane();
//        GridPane b1 = new GridPane();
//        GridPane finalGrid = new GridPane();
//
//        RowConstraints labell = new RowConstraints();
//        labell.setPercentHeight(5);
//
//        RowConstraints  boardd = new RowConstraints();
//        boardd.setPercentHeight(80);
//
//        RowConstraints buttonss = new RowConstraints();
//        buttonss.setPercentHeight(15);
//
//        finalGrid.getRowConstraints().addAll(labell,boardd,buttonss);
//
//
//        g1.setId("grid");
//
//        bt1.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//
//
//                System.out.println("start");
//            }
//        });
//        bt2.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("stop");
//            }
//        });
//
//        bt3.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("next");
//            }
//        });
//
//
//        bt4.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("save");
//            }
//        });
//
//        bt5.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("reset");
//            }
//        });
//
//        bt6.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("view save state");
//            }
//        });
//        bt7.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("load state");
//            }
//        });
//
//
//        //zoom functionalities
//        zoomIN.setOnMouseClicked(new EventHandler<MouseEvent>()
//        {
//            @Override
//            public void handle(MouseEvent event)
//            {
//                g1.setScaleX(g1.getScaleX() + 1);
//                g1.setScaleY(g1.getScaleY() + 1);
//                zizo++;
// */
//            }
//        });
//        zoomOUT.setOnMouseClicked(new EventHandler<MouseEvent>()
//        {
//            @Override
//            public void handle(MouseEvent event)
//            {
//                double X = g1.getScaleX() - 1;
//                if (X >= 1)
//                {
//                    g1.setScaleX(X);
//                }
//                double Y = g1.getScaleY() - 1;
//                if (Y >= 1)
//                {
//                    g1.setScaleY(Y);
//                }
//            }
//        });
//
//                // add title to stage
//        window.setTitle("Game of Life");
//        // add Image to icon
//
//        ////////////// Button addition ////////////////////
//        b1.add(bt1, 0, 0, 3, 1);
//        b1.add(bt2, 10, 0, 3, 1);
//        b1.add(bt3, 20, 0, 3, 1);
//        b1.add(bt4, 30, 0, 3, 1);
//        b1.add(bt5, 40, 0, 3, 1);
//        b1.add(bt6, 50, 0, 3, 1);
//        b1.add(bt7, 60, 0, 3, 1);
//        b1.add(zoomIN, 70, 0, 3, 1);
//        b1.add(zoomOUT, 80, 0, 3, 1);
//
//        b1.setHgap(10);
//
//        //////////////// Grid g1 add cells ////////////////
//        GridCells(row, col, g1);
//        //////////////////// Final Grid /////////////////////////
//        GridPane labelGrid = new GridPane();
//        Label label = new Label("Game of Life");
//        label.setPadding(new Insets(0,0,0,700));
//        label.setFont(Font.font(20));
//        label.setAlignment(Pos.CENTER);
//        labelGrid.add(label, 1, 0, 11, 1);
//
//        finalGrid.add(labelGrid,0,0);
//        finalGrid.add(g1, 0, 1);
//        finalGrid.add(b1, 0, 2);
//        //finalGrid.setAlignment(Pos.CENTER);
//        /////////////////////// Scene //////////////////////
//        Scene scene = new Scene(finalGrid, finalGrid.getMaxWidth(),finalGrid.getMaxWidth(), Color.DARKGREY);
//        //finalGrid.prefHeightProperty().bind(scene.heightProperty());
//        //finalGrid.prefWidthProperty().bind(scene.widthProperty());
//
//        //    stage.setResizable(false);
//        //link sample.css file
//        //////////////////   CSS stylesheet //////////////////
//        scene.getStylesheets().add(getClass().getResource("sample.css").toExternalForm());
//        // adding scene to window
//        window.setScene(scene);
//        // Image icon=new Image("i1.PNG");
//        //window.getIcons().add(icon);
//
//        ////////////// Show window/////////////
//        window.show();
//
//    }
//
//    //  @Override
//    // public  void handle(ActionEvent start)
//    // {
//    //    System.out.println("start");
//    //}
//
//    ///////////////// Grid cell function //////////////
//    public void GridCells(int row, int col, GridPane g1) {
//
//        for ( i = 0; i < row; i++) {
//            for ( j = 0; j < col; j++) {
//                Button_extended button = new Button_extended(i,j);
//                ///////// set ID to Grid button/
//                button.getStyleClass().add("empty_button");
//                button.setOnAction(new EventHandler<ActionEvent>() {
//                    @Override
//                    public void handle(ActionEvent actionEvent) {
//                       // button.setStyle("-fx-background-color: yellow");
//                        button.getStyleClass().add("selected_button");
//                        System.out.println(button.get_Row());
//                       // gameBoard.
//                        System.out.println(button.get_Col());
//                      //  g1.getColumnCount();
//                      //  System.out.println(g1.set);
//                       // g1.getScaleX();
//                        //obj.updateStatus(true);
//                    }
//                });
//
//                //grid dragging
//                button.setOnMouseDragged(new EventHandler<MouseEvent>() {
//                    @Override
//                    public void handle(MouseEvent mouseEvent) {
//                        g1.setPadding(new Insets(mouseEvent.getSceneY(), 0, 0, mouseEvent.getSceneX()));
//                    }
//                });
//
//                //button.setStyle("-fx-background-color: grey");
//                g1.add(button, j, i, 1, 1);
//                g1.setPadding(new Insets(1, 1, 5, 1));
//                g1.setVgap(3);
//                g1.setHgap(5);
//
//
//                //Zainab's drag on mouse click
//                /*g1.setOnMouseDragged(new EventHandler<MouseEvent>() {
//                    @Override
//                    public void handle(MouseEvent event) {
//                        g1.setOnDragDetected(new EventHandler<MouseEvent>(one));
//                    }
//                });*/
//
//
//
//                /*Zainab's on click yellow cellsS
//                button.setOnMouseClicked(new EventHandler<MouseEvent>() {
//                    public void handle(MouseEvent event) {
//                        button.setStyle("-fx-background-color: #FFFF00; ");
//                    }
//                });
//
//            }
//
//        }
//    }
//}
//
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
package com.company.sample;
import com.company.BL.Board;
import com.company.BL.Save;
import com.company.UI.terminalPrinting;
import java.util.Scanner;
import java.lang.Thread;


public class Main {
    public static void main(String args[]) {
    /*    terminalPrinting t1 = new terminalPrinting();
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
        Board b = new Board(5,5);
        b.fillBoard();
        Save s1 = new Save();
       // s1.saveToFile(50,b);
       // s1.SaveStateToFile(55,b);
        Board b9 = new Board(5,5);
        b9 =s1.LoadStateFromFile(55,5,5);
        terminalPrinting t2 = new terminalPrinting();
        t2.printTerminal(5,b9);
    }

}