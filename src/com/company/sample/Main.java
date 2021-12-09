//package com.company.sample;
package com.company.sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.company.BL.factory;
import com.company.UI.Button_extended;
import com.company.BL.Board;
import com.company.Database.DB_DAL;
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

    Stage window;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        int row = 24;
        int col = 80;
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

        RowConstraints labell = new RowConstraints();
        labell.setPercentHeight(5);

        RowConstraints  boardd = new RowConstraints();
        boardd.setPercentHeight(80);

        RowConstraints buttonss = new RowConstraints();
        buttonss.setPercentHeight(15);

        finalGrid.getRowConstraints().addAll(labell,boardd,buttonss);


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


        //zoom functionalities
        zoomIN.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                g1.setScaleX(g1.getScaleX() + 1);
                g1.setScaleY(g1.getScaleY() + 1);
            }
        });
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

                // add title to stage
        window.setTitle("Game of Life");
        // add Image to icon

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
        Label label = new Label("Game of Life");
        label.setFont(Font.font(20));
        label.setAlignment(Pos.CENTER);
        finalGrid.add(label, 0, 0, 1, 1);

        finalGrid.add(g1, 0, 1);
        finalGrid.add(b1, 0, 2);
        //finalGrid.setAlignment(Pos.CENTER);
        /////////////////////// Scene //////////////////////
        Scene scene = new Scene(finalGrid, finalGrid.getMaxWidth(),finalGrid.getMaxWidth(), Color.DARKGREY);
        //finalGrid.prefHeightProperty().bind(scene.heightProperty());
        //finalGrid.prefWidthProperty().bind(scene.widthProperty());

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
    public void GridCells(int row, int col, GridPane g1) {

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
                       // gameBoard.
                        System.out.println(button.get_Col());
                      //  g1.getColumnCount();
                      //  System.out.println(g1.set);
                       // g1.getScaleX();
                        //obj.updateStatus(true);
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