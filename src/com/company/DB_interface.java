package com.company;

import java.sql.SQLException;

public interface DB_interface
{
    public void SaveGrid(int id , Board obj);
    public Board LoadGrid(int Grid_ID) throws SQLException;
    public void delete_saved_state(int Grid_ID) throws SQLException;
    public void GetLexicon() throws SQLException;
}
