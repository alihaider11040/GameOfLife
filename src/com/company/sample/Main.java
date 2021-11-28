package com.company.sample;

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
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.swing.*;

// main is child of application
public class Main extends Application {


    Stage window;
    @Override
    public  void start(Stage stage) throws Exception {
        window=stage;
        int row=23;
        int col=80;
        Button bt1= new Button("Start");
        Button bt2= new Button("Stop");
        Button bt3= new Button("Next");
        Button bt4= new Button("Save");
        Button bt5= new Button("Reset");

        //Zainab
        Button zoomIN = new Button("ZOOM-IN +");
        Button zoomOUT = new Button("ZOOM-OUT -");
        zoomIN.setId("zoomIN");
        zoomOUT.setId("zoomOUT");

        Slider s1= new Slider();
        Slider s2= new Slider();

        ///// set ID to control buttons///
        bt1.setId("start");
        bt2.setId("stop");
        bt3.setId("next");
        bt4.setId("save");
        bt5.setId("reset");

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
        /////////////////////// Grid ///////////////
        GridPane g1= new GridPane();
        GridPane b1=new GridPane();
        GridPane finalGrid=new GridPane();
        g1.setId("grid");


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


        //////////////////////// Grid /////////////////////////


        ////////////// Button addition ////////////////////
        b1.add(bt1,10,0,3,1);
        b1.add(bt2,20,0,3,1);
        b1.add(bt3,30,0,3,1);
        b1.add(bt4,40,0,3,1);
        b1.add(bt5,50,0,3,1);
        b1.add(zoomIN,60,0,3,1);
        b1.add(zoomOUT,70,0,3,1);
        b1.setHgap(3);

        //Zainab zoom-in grid
        zoomIN.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                g1.setScaleX(g1.getScaleX()+1);
                g1.setScaleY(g1.getScaleY()+1);
            }
        });
        zoomOUT.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                g1.setScaleX(g1.getScaleX()-1);
                g1.setScaleY(g1.getScaleY()-1);
            }
        });



        //////////////// Grid g1 add cells ////////////////
        GridCells(row,col, g1);
        //////////////////// Final Grid /////////////////////////
        finalGrid.addRow(0,g1);
        finalGrid.addRow(1,b1);
        /////////////////////// Scene //////////////////////
        Scene scene= new Scene(finalGrid,500,500, Color.DARKGREY);
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
        for (int i=0; i<row;i++) {
           for (int j = 0; j < col; j++) {
                Button button = new Button();
                ///////// set ID to Grid button//
                button.setId("grid_button");
                button.getStyleClass().add("empty_button");
                g1.add(button, j, i, 1, 1);
                g1.setPadding(new Insets(1, 1, 5, 1));
                g1.setVgap(3);
                g1.setHgap(3);

                /*//Zainab's on click yellow code
                button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        button.setStyle("-fx-background-color: #FFFF00; ");
                    }
                });*/

            }
        }
    }
    public static void main(String[] args) {
        // belong to application class
        // static method that we inherit from parent application class
        launch(args);


    }


}
