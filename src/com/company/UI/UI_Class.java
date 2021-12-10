package com.company.UI;
import java.lang.Object;
import java.util.EventObject;
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

//import static jdk.vm.ci.sparc.SPARC.g1;

import com.company.BL.Board;
import com.company.BL.factory;
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

import java.sql.SQLException;
    public class UI_Class implements Display_interface {

//    @Override
//    public void SaveGrid(Board obj) {
//
//    }
//
//    @Override
//    public Board LoadGrid(int Grid_ID) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public void delete_saved_state(int Grid_ID) throws SQLException {
//
//    }
//
//    @Override
//    public void Save_game_details(int Game_ID, Board obj) {
//
//    }
//
//    @Override
//    public Board load_game_details(int Game_ID) throws SQLException {
//        return null;
//    }

        factory fact = new factory();
        com.company.BL.Board gameBoard = fact.getBoard();
        //com.company.BL.Board gameBoard.fillBoard();
        int i = 0, j = 0;
        int zizo;
        Stage window;

        public void start(Stage stage, Board obj) throws Exception {
            window = stage;
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
            zoomIN.setId("zoomIN");
            zoomOUT.setId("zoomOUT");

            /////////////////////// Grid ///////////////
            GridPane g1 = new GridPane();
            GridPane b1 = new GridPane();
            GridPane finalGrid = new GridPane();

            RowConstraints labell = new RowConstraints();
            labell.setPercentHeight(5);

            RowConstraints boardd = new RowConstraints();
            boardd.setPercentHeight(80);

            RowConstraints buttonss = new RowConstraints();
            buttonss.setPercentHeight(15);
            finalGrid.getRowConstraints().addAll(labell, boardd, buttonss);
            g1.setId("grid");
            ///////////////////////// Event handler //////////////////
            start_event(bt1,obj);
            stop_event(bt2, obj);
            next_event(bt3, obj);
            save_event(bt4, obj);
            reset_event(bt5, obj);
            view_event(bt6, obj);
            load_event(bt7, obj);
            zoom_in_event(zoomIN, obj, g1);
            zoom_out_event(zoomOUT, obj, g1);

            ////////////  Button to grid b1 /////////////
            add_control_on_b1_grid(b1, bt1, bt2, bt3, bt4, bt5, bt6, bt7, zoomIN, zoomOUT);

            //////////////// Grid g1 add cells ////////////////
            GridCells(row, col, g1,obj);
            //////////////////// Final Grid /////////////////////////
            GridPane labelGrid = new GridPane();
            Label label = new Label("Game of Life");
            label.setPadding(new Insets(5, 600, 10, 650));
            label.setFont(Font.font(20));
            label.setAlignment(Pos.CENTER);
            label.setId("Lable");
            labelGrid.add(label, 1, 0, 11, 1);

            finalGrid.add(labelGrid, 0, 0);
            finalGrid.add(g1, 0, 1);
            finalGrid.add(b1, 0, 2);

            ////////// display/////////





            //finalGrid.setAlignment(Pos.CENTER);
            /////////////////////// Scene //////////////////////
            Scene scene = new Scene(finalGrid, finalGrid.getMaxWidth(), finalGrid.getMaxWidth(), Color.DARKGREY);
            //link sample.css file
            //////////////////   CSS stylesheet //////////////////
            scene.getStylesheets().add(getClass().getResource("sample.css").toExternalForm());
            // adding scene to window
            window.setScene(scene);
            window.setTitle("Game of Life");
            ////////////// Show window/////////////
            window.show();

        }

        public void drag_event(Button button, GridPane g1) {
            button.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    g1.setPadding(new Insets(mouseEvent.getSceneY(), 0, 0, mouseEvent.getSceneX()));
                }
            });
        }

        ///////////////// Grid cell function //////////////
        public void GridCells(int row, int col, GridPane g1, Board obj) {

            for (i = 0; i < row; i++) {
                for (j = 0; j < col; j++) {

                       Button_extended button = new Button_extended(i, j);
                       ///////// set ID to Grid button/
                       button.getStyleClass().add("empty_button");
                    if( obj.getStatus(i,j)) {
                        button.setStyle("-fx-background-color: grey");
                    }
                    else
                    {
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
                   }

                    //grid dragging
                    drag_event(button, g1);

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

                    obj.set_StateRun(true);
                    System.out.println("start");
                }
            });
        }

        public void stop_event(Button bt2, Board obj) {
            bt2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    obj.set_StateRun(false);
                    System.out.println("stop");
                }
            });
        }

        public void next_event(Button bt3, Board obj) {
            bt3.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    System.out.println("next");
                }
            });
        }

        public void save_event(Button bt4, Board obj) {
            bt4.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    System.out.println("save");
                }
            });
        }

        public void reset_event(Button bt5, Board obj) {
            bt5.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    obj.fillBoard();
                    System.out.println("reset");
                }
            });
        }

        public void view_event(Button bt6, Board obj) {
            bt6.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    System.out.println("view state");
                }
            });
        }

        public void load_event(Button bt7, Board obj) {
            bt7.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    System.out.println("load state");
                }
            });
        }

        public void zoom_in_event(Button zoomIN, Board obj, GridPane g1) {
            zoomIN.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    g1.setScaleX(g1.getScaleX() + 1);
                    g1.setScaleY(g1.getScaleY() + 1);
                    zizo++;

                }
            });
        }

        public void zoom_out_event(Button zoomOUT, Board obj, GridPane g1) {
            zoomOUT.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    double X = g1.getScaleX() - 1;
                    if (X >= 1) {
                        g1.setScaleX(X);
                    }
                    double Y = g1.getScaleY() - 1;
                    if (Y >= 1) {
                        g1.setScaleY(Y);
                    }
                }
            });
        }

        public void add_control_on_b1_grid(GridPane b1, Button bt1, Button bt2, Button bt3, Button bt4, Button bt5, Button bt6, Button bt7, Button zoomIN, Button zoomOUT) {
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
            b1.setId("Controls");
        }

        @Override
        public void SaveGrid(Board obj) {

        }

        @Override
        public void print(Board obj) throws Exception {


            Stage stage = null;
            start(stage, obj);

        }

        @Override
        public Board LoadGrid(int Grid_ID) throws SQLException {
            return null;
        }

        @Override
        public void delete_saved_state(int Grid_ID) throws SQLException {

        }

        @Override
        public void Save_game_details(int Game_ID, Board obj) {

        }

        @Override
        public Board load_game_details(int Game_ID) throws SQLException {
            return null;
        }
    };
