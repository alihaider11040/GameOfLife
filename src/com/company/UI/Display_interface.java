package com.company.UI;

import com.company.BL.Board;

import java.sql.SQLException;

public interface Display_interface {
    public boolean SaveGrid(boolean saveClicked);
    public void print(Board obj);
    public Board LoadGrid(int Grid_ID) throws SQLException;
    public void delete_saved_state(int Grid_ID) throws SQLException;

}
