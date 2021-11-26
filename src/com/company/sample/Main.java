package com.company.sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;

// main is child of application
public class Main extends Application {

    int row=20;
    int col=50;
    Button bt1= new Button("Start");
    Button bt2= new Button("Stop");
    Button bt3= new Button("Next");
    Button bt4= new Button("Lexicon");
    Button bt5= new Button("Explaination");
    Button bt6= new Button("Reset");
    Slider s1= new Slider();
    Slider s2= new Slider();

    GridPane g1= new GridPane();

    @Override
    public void start(Stage stage) throws Exception {
        //show stage
        // link sample.fxml file
        // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //adding root node to scene

        Scene scene= new Scene(g1,600,600, Color.DARKGREY);
        //link sample.css file
        // scene.getStylesheets().add(getClass().getResource("sample.css").toExternalForm());
        // adding scene to stage
        stage.setScene(scene);
        // add title to stage
        stage.setTitle("Game of Life");
        // add Image to icon
        //Image icon = new Image("i1.PNG");
        // stage.getIcons().add(icon);
        // set Width and height of stage
        //  stage.setWidth(600);
        // stage.setHeight(600);
        // we are not able to change the stage size
        stage.setResizable(true);
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

        Text text=new Text();
        text.setText("Game of Life");
        text.setX(150);
        text.setY(50);
        // text.setFont(Font.font("papyrus",50));
        text.setFont(Font.font("papyrus",FontWeight.findByWeight(50),FontPosture.REGULAR, 50 ));
        text.setFill(Color.YELLOW);
        //add text on scene
        //  root.getChildrenUnmodifiable().add(text);
        //////////////////////// Grid /////////////////////////
        GridCells(row,col);
        stage.show();

    }


    public void GridCells(int row, int col)
    {
        for (int i=0; i<row;i++)
        {
            for (int j=0;j<col;j++)
            {
                Button button=new Button();
                button.getStyleClass().add("emptybutton");
                g1.add(button,j,i,1,1);
            }
        }
        // g1.add(bt1,40,50,1,1);
    }


    public static void main(String[] args) {
        // belong to application class
        // static method that we inherit from parent application class
        launch(args);


    }


}
