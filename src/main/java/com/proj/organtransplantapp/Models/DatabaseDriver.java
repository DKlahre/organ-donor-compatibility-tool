package com.proj.organtransplantapp.Models;

import javafx.application.Application;
import javafx.stage.Stage;

import javax.xml.transform.Result;
import java.sql.*;

public class DatabaseDriver {


    private Connection conn1;
    private Connection conn2;
    private Connection conn3;
    private Connection conn4;

   // String [] micaSourceArray = new String[100];

    public DatabaseDriver() {
        try {
            this.conn1 = DriverManager.getConnection("jdbc:sqlite:transplantcandidates.db");
            this.conn2 = DriverManager.getConnection("jdbc:sqlite:organdonors.db");
            this.conn3 = DriverManager.getConnection("jdbc:sqlite:organdonors.db");
            this.conn4 = DriverManager.getConnection("jdbc:sqlite:epletmaster.db");
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
            resultSet = statement.executeQuery("SELECT * FROM Candidates Where Email = '" + email + "';");
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
            resultSet = statement.executeQuery("SELECT * FROM Candidates Where LastName = '" + lastName + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet searchDonorsDB(String organParam, String bloodType, String micaApr) throws SQLException {
        Statement statement2;
        Statement statement3;
        Statement statement4;
        Statement statement5;
        Statement statement6;
        Statement statement7;
        Statement statement8;
        Statement statement9;
        Statement statement10;
        ResultSet resultSet = null;

        try {
            statement2 = this.conn2.createStatement();
            resultSet = statement2.executeQuery("SELECT * FROM '" + organParam + "' Where BloodType = '" + bloodType + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (resultSet.next()) {
            try {
                String fName = resultSet.getString(1);
                String lName = resultSet.getString(2);
                String gender = resultSet.getString(3);
                String age = resultSet.getString(4);
                String weight = resultSet.getString(5);
                String email = resultSet.getString(6);
                String organ = resultSet.getString(7);
                String bloodtype = resultSet.getString(8);
                String dp1 = resultSet.getString(9);
                String dp2 = resultSet.getString(10);
                String dp3 = resultSet.getString(11);
                String abc1 = resultSet.getString(12);
                String abc2 = resultSet.getString(13);
                String abc3 = resultSet.getString(14);
                String drb1 = resultSet.getString(15);
                String drp2 = resultSet.getString(16);
                String drb3 = resultSet.getString(17);
                String dq1 = resultSet.getString(18);
                String dq2 = resultSet.getString(19);
                String dq3 = resultSet.getString(20);
                String mica1 = resultSet.getString(21);
                String mica2 = resultSet.getString(22);
                String mica3 = resultSet.getString(23);
                statement3 = this.conn2.createStatement();
                statement3.executeUpdate("INSERT INTO TempTable(FirstName, LastName, Gender, Age, Weight, Email, Organ, BloodType, " +
                        "DP1, DP2, DP3, ABC1, ABC2, ABC3, DRB1, DRB2, DRB3, DQ1, DQ2, DQ3, MICA1, MICA2, MICA3)" +
                        "VALUES ('" + fName + "', '" + lName + "', '" + gender + "', '" + age + "', '" + weight + "', '" + email + "', '" + organ + "', '" + bloodtype +
                        "', '" + dp1 + "', '" + dp2 + "', '" + dp3 + "', '" + abc1 + "', '" + abc2 + "', '" + abc3 + "', '" + drb1 + "', '" + drp2 + "', '" + drb3 +
                        "','" + dq1 + "', '" + dq2 + "', '" + dq3 + "', '" + mica1 + "', '" + mica2 + "', '" + mica3 + "');");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        ResultSet resultSetPickedCandidate = null;
        try {
            statement4 = this.conn1.createStatement();
            resultSetPickedCandidate = statement4.executeQuery("SELECT * FROM Candidates Where Email = '" + Model.getInstance().getEmailStore() + "';");
            System.out.println("picked candidate firstname" + resultSetPickedCandidate.getString(1));
            System.out.println("picked candidate lastname" + resultSetPickedCandidate.getString(2));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet resultSetEplets = null;
        try{
            statement5 = this.conn4.createStatement();
            resultSetEplets = statement5.executeQuery("SELECT * FROM Eplets");
          //  System.out.println("mica: " + resultSetEplets.getString(5));
           // System.out.println("picked candidate lastname" + resultSetEplets.getString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        int j = 0;
//        while (resultSetEplets.next()) {
//            try {
//                micaSourceArray[j] = resultSetEplets.getString(5);
//                System.out.println("micaSourceArray: " + micaSourceArray[j]);
//                j++;
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }


//        statement10 = this.conn2.createStatement();
//        int deletedRows = statement10.executeUpdate("DELETE FROM TempTable;");

        return resultSet;
    }
}




