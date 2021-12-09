package com.company.UI;

import com.company.BL.Board;

public class factory_UI {
    Board getBoard(){
        return new Board(21,80);
    }
}
