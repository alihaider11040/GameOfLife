package com.company.sample;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Button;
import java.awt.*;
import java.util.Collection;

public class Button_extended extends Button {
    int row ;
    int col;
    public Button_extended(){
        super();
    }
    public Button_extended(int i,int j){
        super();
        row=i;
        col=j;
    }
    public int get_Row(){return row;}
    public  int get_Col(){return col;}

}
