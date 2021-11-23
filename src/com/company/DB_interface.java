package com.company;

import java.sql.SQLException;

public interface DB_interface {
    public void SaveGrid();
    public void LoadGrid() throws SQLException;
    public void GetLexicon() throws SQLException;
}
