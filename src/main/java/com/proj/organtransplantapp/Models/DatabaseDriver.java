package com.proj.organtransplantapp.Models;

import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseDriver  {

    private Connection conn1;
    private Connection conn2;

    public DatabaseDriver() {
        try {
            this.conn1 = DriverManager.getConnection("jdbc:sqlite:epletmaster.db");
            this.conn2 = DriverManager.getConnection("jdbc:sqlite:transplantcandidates.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
