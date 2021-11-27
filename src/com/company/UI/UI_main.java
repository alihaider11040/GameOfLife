package com.company.UI;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
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
public class UI_main extends Application {


    Stage window;
    @Override
    public void start(Stage stage) throws Exception {
        window=stage;
        int row=20;
        int col=50;
        Button bt1= new Button("Start");
        Button bt2= new Button("Stop");
        Button bt3= new Button("Next");
        Button bt4= new Button("Explanation");
        Button bt5= new Button("Reset");
        Slider s1= new Slider();
        Slider s2= new Slider();

        ///// set ID to control buttons///
        bt1.setId("play_button");
        bt2.setId("play_button");
        bt3.setId("play_button");
        bt4.setId("play_button");
        bt5.setId("play_button");

///////////////////////////////////BUTTON STYLE////////////////////////////


        ///////////////////////////BUTTON STYLE////////////
        GridPane g1= new GridPane();
        GridPane b1=new GridPane();
        GridPane finalGrid=new GridPane();
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

        ///// Grid///////
        GridCells(row,col, g1);
        b1.add(bt1,0,0,1,1);
        b1.add(bt2,10,0,1,5);
        b1.add(bt3,20,0,1,5);
        b1.add(bt4,30,0,1,5);
        b1.add(bt5,40,0,1,5);
        b1.add(s1,50,0,1,5);
        b1.add(s2,60,0,1,5);
        bt1.setLineSpacing(3);
        //b1.setStyle("-fx-background-color: pink");
        // g1.add(bt1,40,50,1,1);
        finalGrid.addRow(0,g1);
        finalGrid.addRow(1,b1);
        Scene scene= new Scene(finalGrid, Color.DARKGREY);
        finalGrid.prefHeightProperty().bind(scene.heightProperty());
        finalGrid.prefWidthProperty().bind(scene.widthProperty());

        //g1.setHgrow(g1,Priority.ALWAYS);
        //  g1.setVgrow(g1,Priority.ALWAYS);

        //    stage.setResizable(false);
        //link sample.css file
        scene.getStylesheets().add(getClass().getResource("sample.css").toExternalForm());
        // adding scene to stage
        window.setScene(scene);
        // Image icon=new Image("i1.PNG");
        //window.getIcons().add(icon);

        window.show();

    }


    public void GridCells(int row, int col, GridPane g1)
    {
        for (int i=0; i<row;i++)
        {
            for (int j=0;j<col;j++)
            {
                Button button=new Button();
                ///////// set ID to Grid button//
                button.setId("grid_button");
                button.getStyleClass().add("emptybutton");
                g1.add(button,j,i,1,1);
                g1.setPadding(new Insets(1,1,10,1));
                g1.setVgap(3);
                g1.setHgap(3);
            }
        }
    }


    public static void main(String[] args) {
        // belong to application class
        // static method that we inherit from parent application class
        launch(args);


    }


}

