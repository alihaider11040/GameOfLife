package com.company.sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;

// main is child of application
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //show stage
        // link sample.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //adding root node to scene
        Scene scene= new Scene(root,600,600, Color.DARKGREY);
        //link sample.css file
        scene.getStylesheets().add(getClass().getResource("sample.css").toExternalForm());
        // adding scene to stage
        stage.setScene(scene);
        // add title to stage
        stage.setTitle("Game of Life");
        // add Image to icon
        Image icon = new Image("i1.PNG");
        stage.getIcons().add(icon);
        // set Width and height of stage
      //  stage.setWidth(600);
       // stage.setHeight(600);
        // we are not able to change the stage size
        stage.setResizable(false);
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
        stage.show();

    }


    public static void main(String[] args)
    {
        // belong to application class
        // static method that we inherit from parent application class
        launch(args);
    }


}
