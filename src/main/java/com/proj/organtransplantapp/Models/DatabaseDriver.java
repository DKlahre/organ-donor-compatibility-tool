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
            this.conn2 = DriverManager.getConnection("jdbc:sqlite:organdonors.db");
            this.conn3 = DriverManager.getConnection("jdbc:sqlite:organdonors.db");
//            this.conn4 = DriverManager.getConnection("jdbc:sqlite:epletmaster.db");
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet searchDonorsDB(String organ, String bloodType ) throws SQLException {
        Statement statement2;
        Statement statement3;
        ResultSet resultSet = null;
        String fName = "hawr";
        String lName = "agaz";
        String gender = "trshgr";
        String age = "sthrg";
        String weight = "trhegr";
        String email = "agh";
        String orgn = "yjrth";
        String bloodtype = "thgr";
        String dp1 = "hetr";
        String dp2 = "trhrg";
        String dp3 = "sthrg";
        String abc1 = "ynthgr";
        String abc2 = "mhynth";
        String abc3 = "mnngr";
        String drb1 = "yrnthebgr";
        String drp2 = "mtnghg";
        String drb3 = "yrn";
        String dq1 = "ngr";
        String dq2 = "nhg";
        String dq3 = "ynthegr";
        String mica1 = "nrth";
        String mica2 = "hngb";
        String mica3 = "mhng";

        try {
            statement2 = this.conn2.createStatement();
            resultSet = statement2.executeQuery("SELECT * FROM '" + organ + "' Where BloodType = '" + bloodType + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (resultSet.next()) {
            try {
                statement3 = this.conn2.createStatement();
                statement3.executeUpdate("INSERT INTO TempTable(FirstName, LastName, Gender, Age, Weight, Email, Organ, BloodType, DP1, DP2, DP3, ABC1, ABC2, ABC3, DRB1, DRB2, DRB3, DQ1, DQ2, DQ3, MICA1, MICA2, MICA3)" +
                        "VALUES ('"+fName +"', '"+ lName+"', '"+ gender+"', '"+ age+"', '"+ weight+"', '"+ email+"', '"+ orgn+"', '"+ bloodtype+"', '"+ dp1+"', '"+ dp2+"', '"+ dp3+"', '"+ abc1+"', '"+ abc2+"', '"+ abc3+"', '"+ drb1+"', '"+ drp2+"', '"+ drb3+"','" +dq1+"', '"+ dq2+"', '"+ dq3+"', '"+mica1+"', '"+ mica2+"', '"+ mica3+"');");
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
