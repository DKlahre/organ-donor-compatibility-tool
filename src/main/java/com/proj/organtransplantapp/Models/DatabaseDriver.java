package com.proj.organtransplantapp.Models;

import javafx.application.Application;
import javafx.stage.Stage;

import javax.xml.transform.Result;
import java.sql.*;

public class DatabaseDriver  {

    private Connection conn1;
    private Connection conn2;
    private Connection conn3;

    public DatabaseDriver() {
        try {
            this.conn1 = DriverManager.getConnection("jdbc:sqlite:transplantcandidates.db");
//            this.conn2 = DriverManager.getConnection("jdbc:sqlite:organdonors.db");
//            this.conn3 = DriverManager.getConnection("jdbc:sqlite:epletmaster.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet searchHeartList(int ageLower, int ageHigher) {

        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn2.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Heart WHERE Age BETWEEN '" + ageLower + "' AND '" + ageHigher + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet searchKidneyList(int ageLower, int ageHigher) {

        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn2.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Kidney WHERE Age BETWEEN '" + ageLower + "' AND '" + ageHigher + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet searchLiverList(int ageLower, int ageHigher) {

        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn2.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Liver WHERE Age BETWEEN '" + ageLower + "' AND '" + ageHigher + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet searchLungList(int ageLower, int ageHigher) {

        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn2.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Lung WHERE Age BETWEEN '" + ageLower + "' AND '" + ageHigher + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet searchPancreasList(int ageLower, int ageHigher) {

        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn2.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Pancreas WHERE Age BETWEEN '" + ageLower + "' AND '" + ageHigher + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet searchCandEmail(String email) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn1.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Candidates Where Email = '"+email+"';");
//            System.out.println("Inside searchCandEmail - Hello");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet searchCandLastName(String lastName) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn1.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Candidates Where LastName = '"+lastName+"';");
//            System.out.println("Inside searchCandLastName - Hello");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

//    public ResultSet getAllCandidatesData() {
//        Statement statement;
//        ResultSet resultSet = null;
//        try {
//            statement = this.conn1.createStatement();
//            resultSet = statement.executeQuery("SELECT * FROM Candidates;");
//        } catch (SQLException e) {
//            System.out.println("We got a problem here - getAllCandidatesData()");
//            e.printStackTrace();
//        }
//        return resultSet;
//    }



}
