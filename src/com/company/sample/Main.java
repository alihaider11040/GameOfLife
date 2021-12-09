//package com.company.sample;
package com.company.sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.company.UI.Button_extended;
import com.company.BL.Board;
import com.company.Database.DB_DAL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
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

// main is child of application
public class Main extends Application {

    int i=0,j=0;
    Board obj = new Board();

    Stage window;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        int row = 24;
        int col = 200;
        Button bt1 = new Button("Start");
        Button bt2 = new Button("Stop");
        Button bt3 = new Button("Next");
        Button bt4 = new Button("Save");
        Button bt5 = new Button("Reset");
        Button bt6 = new Button("View Save State");
        Button bt7 = new Button("Load");
        Button zoomIN = new Button("ZOOM-IN +");
        Button zoomOUT = new Button("ZOOM-OUT -");

        ///// set ID to control buttons///
        bt1.setId("start");
        bt2.setId("stop");
        bt3.setId("next");
        bt4.setId("save");
        bt5.setId("reset");
        bt6.setId("view");
        bt7.setId("load");
        zoomIN.setId("zoomIN");
        zoomOUT.setId("zoomOUT");

        /////////////////////// Grid ///////////////
        GridPane g1 = new GridPane();
        GridPane b1 = new GridPane();
        GridPane finalGrid = new GridPane();
        g1.setId("grid");

        bt1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("start");
            }
        });
        bt2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("stop");
            }
        });

        bt3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("next");
            }
        });


        bt4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("save");
            }
        });

        bt5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("reset");
            }
        });

        bt6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("view save state");
            }
        });
        bt7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("load state");
            }
        });

        zoomIN.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                g1.setScaleX(g1.getScaleX() + 1);
                g1.setScaleY(g1.getScaleY() + 1);
            }
        });
        zoomOUT.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                g1.setScaleX(g1.getScaleX() - 1);
                g1.setScaleY(g1.getScaleY() - 1);
            }
        });

        /*//Zoom partially implemented through terminal (Zainab)
        BufferedReader zoomPLUS = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Z to zoomIN : ");
        try {
            String zoomPlus = zoomPLUS.readLine();
            System.out.println(zoomPlus);
            g1.setScaleX(g1.getScaleX()+1);
            g1.setScaleY(g1.getScaleY()+1);

        }catch(Exception e) {
            System.out.println(e);
        }*/

        /*//Zoom partially implemented through terminal (Zainab)
        BufferedReader zoomMINUS = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter X to zoomOUT : ");
        try {
            String zoomMinus = zoomMINUS.readLine();
            System.out.println(zoomMinus);
            g1.setScaleX(g1.getScaleX()-1);
            g1.setScaleY(g1.getScaleY()-1);

        }catch(Exception e) {
            System.out.println(e);
        }*/

        /////////////////////// Window title ////////////////
        //show stage
        // link sample.fxml file
        // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //adding root node to scene


        // add title to stage
        window.setTitle("Game of Life");
        // add Image to icon
        //Image icon = new Image("i1.PNG");
        // stage.getIcons().add(icon);
        // set Width and height of stage
        //  stage.setWidth(600);
        // stage.setHeight(600);
        // we are not able to change the stage size
        //stage.setResizable(true);
        // stage.setMaximized(true);
        //  stage.setMinWidth(1024);
        // stage.setMaxWidth(1200);
        // below two line show the stage on 50,50 position on screen
        //  stage.setX(10);
        //  stage.setY(10);
        //stage.setFullScreen(true);
        // to remove full screen by default key is escape otherwise we select
        // key other than escape
        // stage.setFullScreenExitHint("Press f to exit full_screen mode");
        // stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("f"));

        ////////////// Button addition ////////////////////
        b1.add(bt1, 0, 0, 3, 1);
        b1.add(bt2, 10, 0, 3, 1);
        b1.add(bt3, 20, 0, 3, 1);
        b1.add(bt4, 30, 0, 3, 1);
        b1.add(bt5, 40, 0, 3, 1);
        b1.add(bt6, 50, 0, 3, 1);
        b1.add(bt7, 60, 0, 3, 1);
        b1.add(zoomIN, 70, 0, 3, 1);
        b1.add(zoomOUT, 80, 0, 3, 1);

        b1.setHgap(10);

        //////////////// Grid g1 add cells ////////////////
        GridCells(row, col, g1);
        //////////////////// Final Grid /////////////////////////
        finalGrid.addRow(0,g1);
        finalGrid.addRow(1,b1);
        int r=24;
        int c=90;
        //   final_(r,c,g1,b1,finalGrid);

        /////////////////////// Scene //////////////////////
        Scene scene = new Scene(finalGrid, 500, 500, Color.DARKGREY);
        finalGrid.prefHeightProperty().bind(scene.heightProperty());
        finalGrid.prefWidthProperty().bind(scene.widthProperty());

        //    stage.setResizable(false);
        //link sample.css file
        //////////////////   CSS stylesheet //////////////////
        scene.getStylesheets().add(getClass().getResource("sample.css").toExternalForm());
        // adding scene to window
        window.setScene(scene);
        // Image icon=new Image("i1.PNG");
        //window.getIcons().add(icon);

        ////////////// Show window/////////////
        window.show();

    }

    //  @Override
    // public  void handle(ActionEvent start)
    // {
    //    System.out.println("start");
    //}

    ///////////////// Grid cell function //////////////
    public void GridCells(int row, int col, GridPane g1)
    {
        for ( i = 0; i < row; i++) {
            for ( j = 0; j < col; j++) {
                Button_extended button = new Button_extended(i,j);
                ///////// set ID to Grid button/
                button.getStyleClass().add("empty_button");
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        // button.setStyle("-fx-background-color: yellow");
                        button.getStyleClass().add("selected_button");
                        System.out.println(button.get_Row());
                        System.out.println(button.get_Col());
                        //  g1.getColumnCount();
                        //  System.out.println(g1.set);
                        // g1.getScaleX();
                        obj.updateStatus(true);
                    }
                });
                //button.setStyle("-fx-background-color: grey");
                g1.add(button, j, i, 1, 1);
                g1.setPadding(new Insets(1, 1, 5, 1));
                g1.setVgap(3);
                g1.setHgap(5);


                //Zainab's drag on mouse click
                /*g1.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        g1.setOnDragDetected(new EventHandler<MouseEvent>(one));
                    }
                });*/

                /*Zainab's on click yellow cellsS
                button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent event) {
                        button.setStyle("-fx-background-color: #FFFF00; ");
                    }
                });*/

            }

        }
    }

}

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