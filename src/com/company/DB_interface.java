package com.company;

import java.sql.SQLException;

public interface DB_interface {
    public void SaveGrid();
    public void LoadGrid() throws SQLException;
    public void delete_game_details() throws SQLException;
    public void delete_game_record_details() throws SQLException;
    public void GetLexicon() throws SQLException;

}
