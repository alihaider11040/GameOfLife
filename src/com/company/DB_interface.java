package com.company;

import java.sql.SQLException;

public interface DB_interface
{
    public void SaveGrid(Board obj);
    public void LoadGrid(int Grid_ID) throws SQLException;
    public void delete_saved_state(int Grid_ID) throws SQLException;
    public void GetLexicon(lexicon obj) throws SQLException;
}
