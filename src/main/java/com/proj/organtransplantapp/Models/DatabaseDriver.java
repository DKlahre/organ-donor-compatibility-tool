package com.proj.organtransplantapp.Models;

import javafx.application.Application;
import javafx.stage.Stage;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class DatabaseDriver {


    private Connection conn1;
    private Connection conn2;
    private Connection conn3;
    private Connection conn4;

     String [] micaSourceArray = new String[64];
     String [] dqSourceArray = new String[64];
     String [] drbSourceArray = new String[64];
     String [] abcSourceArray = new String[64];
     String [] dpSourceArray = new String[64];

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

    public ResultSet searchDonorsDB(String organParam, String bloodType, String micaApr, String dqApr, String drbApr, String abcApr, String dpApr, String dp, String abc, String drb, String dq, String mica) throws SQLException {
        Statement statement2;
        Statement statement3;
        Statement statement4;
        Statement statement5;
        Statement statement6;
        Statement statement7;
        Statement statement8;
        Statement statement9;
        Statement statement10;


      //  ArrayList<String> dpList = new ArrayList<>();

        int candDpRequisite = (int) Double.parseDouble(dp);
        int candAbcRequisite = (int) Double.parseDouble(abc);
        int candDrbRequisite = (int) Double.parseDouble(drb);
        int candDqRequisite = (int) Double.parseDouble(dq);
        int candMicaRequisite = (int) Double.parseDouble(mica);


//        System.out.println("dpCount: " + dpCount);
//        System.out.println("dpCount: " + abcCount);
//        System.out.println("dpCount: " + drbCount);
//        System.out.println("dpCount: " + dqCount);
//        System.out.println("dpCount: " + micaCount);



        ///////// Selects from specific organ list all donors having specific blood type
//        ResultSet resultSet = null;
//        try {
//            statement2 = this.conn2.createStatement();
//            resultSet = statement2.executeQuery("SELECT * FROM '" + organParam + "' Where BloodType = '" + bloodType + "';");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //////////////////////



//        while (resultSet.next()) {
//            try {
//                String fName = resultSet.getString(1);
//                String lName = resultSet.getString(2);
//                String gender = resultSet.getString(3);
//                String age = resultSet.getString(4);
//                String weight = resultSet.getString(5);
//                String email = resultSet.getString(6);
//                String organ = resultSet.getString(7);
//                String bloodtype = resultSet.getString(8);
//                String dp1 = resultSet.getString(9);
//                String dp2 = resultSet.getString(10);
//                String dp3 = resultSet.getString(11);
//                String abc1 = resultSet.getString(12);
//                String abc2 = resultSet.getString(13);
//                String abc3 = resultSet.getString(14);
//                String drb1 = resultSet.getString(15);
//                String drp2 = resultSet.getString(16);
//                String drb3 = resultSet.getString(17);
//                String dq1 = resultSet.getString(18);
//                String dq2 = resultSet.getString(19);
//                String dq3 = resultSet.getString(20);
//                String mica1 = resultSet.getString(21);
//                String mica2 = resultSet.getString(22);
//                String mica3 = resultSet.getString(23);
//                statement3 = this.conn2.createStatement();
//                statement3.executeUpdate("INSERT INTO TempTable(FirstName, LastName, Gender, Age, Weight, Email, Organ, BloodType, " +
//                        "DP1, DP2, DP3, ABC1, ABC2, ABC3, DRB1, DRB2, DRB3, DQ1, DQ2, DQ3, MICA1, MICA2, MICA3)" +
//                        "VALUES ('" + fName + "', '" + lName + "', '" + gender + "', '" + age + "', '" + weight + "', '" + email + "', '" + organ + "', '" + bloodtype +
//                        "', '" + dp1 + "', '" + dp2 + "', '" + dp3 + "', '" + abc1 + "', '" + abc2 + "', '" + abc3 + "', '" + drb1 + "', '" + drp2 + "', '" + drb3 +
//                        "','" + dq1 + "', '" + dq2 + "', '" + dq3 + "', '" + mica1 + "', '" + mica2 + "', '" + mica3 + "');");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//       }

        ////////////// Selects all possible eplets
        ResultSet resultSetPickedCandidate = null;
        ResultSet resultSetEplets = null;
        try{
            statement5 = this.conn4.createStatement();
            resultSetEplets = statement5.executeQuery("SELECT * FROM Eplets");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /////////////////////////////




        ///////// Picks row of information representing the picked candidate
        int j = 0;
        int micaMatchCount = 0;
        int dqMatchCount = 0;
        int drbMatchCount = 0;
        int abcMatchCount = 0;
        int dpMatchCount = 0;
        boolean micaRequisiteSatisfied = false;
        boolean dqRequisiteSatisfied = false;
        boolean drbRequisiteSatisfied = false;
        boolean abcRequisiteSatisfied = false;
        boolean dpRequisiteSatisfied = false;


                statement4 = this.conn1.createStatement();
                resultSetPickedCandidate = statement4.executeQuery("SELECT * FROM Candidates Where Email = '" + Model.getInstance().getEmailStore() + "';");
                String candMica1 = resultSetPickedCandidate.getString(21);
                String candMica2 = resultSetPickedCandidate.getString(22);
                String candMica3 = resultSetPickedCandidate.getString(23);
                String candDq1 = resultSetPickedCandidate.getString(18);
                String candDq2 = resultSetPickedCandidate.getString(19);
                String candDq3 = resultSetPickedCandidate.getString(20);
                String candDrb1 = resultSetPickedCandidate.getString(15);
                String candDrb2 = resultSetPickedCandidate.getString(16);
                String candDrb3 = resultSetPickedCandidate.getString(17);
                String candAbc1 = resultSetPickedCandidate.getString(12);
                String candAbc2 = resultSetPickedCandidate.getString(13);
                String candAbc3 = resultSetPickedCandidate.getString(14);
                String candDp1 = resultSetPickedCandidate.getString(9);
                System.out.println("candDP1 " + candDp1);
                String candDp2 = resultSetPickedCandidate.getString(10);
                String candDp3 = resultSetPickedCandidate.getString(11);

        while (resultSetEplets.next()) {

            try {
                micaSourceArray[j] = resultSetEplets.getString(5);
                dqSourceArray[j] = resultSetEplets.getString(4);
                drbSourceArray[j] = resultSetEplets.getString(3);
                abcSourceArray[j] = resultSetEplets.getString(2);
                dpSourceArray[j] = resultSetEplets.getString(1);
                System.out.println("dpSourceArray[j] " + micaSourceArray[j]);

                if (Objects.equals(micaSourceArray[j], candMica1) || Objects.equals(micaSourceArray[j], candMica2) || Objects.equals(micaSourceArray[j], candMica3)) {
                    micaMatchCount++;
                }
                if (Objects.equals(dqSourceArray[j], candDq1 ) || Objects.equals(dqSourceArray[j], candDq2) || Objects.equals(dqSourceArray[j], candDq3)) {
                    dqMatchCount++;
                }
                if (Objects.equals(drbSourceArray[j], candDrb1 ) || Objects.equals(drbSourceArray[j], candDrb2) || Objects.equals(drbSourceArray[j], candDrb3)) {
                    drbMatchCount ++;
                    System.out.println("candDrb1 " + candDrb1);
                    System.out.println("candDrb2 " + candDrb2);
                    System.out.println("candDrb3 " + candDrb3);
                    System.out.println("(drbSourceArray[j] " + (drbSourceArray[j]));
                }
                if (abcSourceArray[j].equals(candAbc1) || abcSourceArray[j].equals(candAbc2) || abcSourceArray[j].equals(candAbc3)) {
                    abcMatchCount ++;
                    System.out.println("candAbc1 " + candAbc1);
                    System.out.println("candAbc2 " + candAbc2);
                    System.out.println("candAbc3 " + candAbc3);
                    System.out.println("(abcSourceArray[j] " + (abcSourceArray[j]));
                }
                if (Objects.equals(dpSourceArray[j], candDp1 ) || Objects.equals(dpSourceArray[j], candDp2) || Objects.equals(dpSourceArray[j], candDp3)) {
                    dpMatchCount ++;
                    System.out.println("candDp1 " + candDp1);
                    System.out.println("candDp2 " + candDp2);
                    System.out.println("candDp3 " + candDp3);
                    System.out.println("(dpSourceArray[j] " + (dpSourceArray[j]));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            j++;
        }

        System.out.println("micaMatchCount " + micaMatchCount);
        System.out.println("dqMatchCount " + dqMatchCount);
        System.out.println("drbMatchAccount " + drbMatchCount);
        System.out.println("abcMatchAccount " + abcMatchCount);
        System.out.println("dpMatchAccount " + dpMatchCount);
       // String micaApr1 = micaApr;
        System.out.println("micaApr " + micaApr);
        System.out.println("dqApr " + dqApr);
        System.out.println("drbApr " + drbApr);
        System.out.println("abcApr " + abcApr);
        System.out.println("dpApr " + dpApr);

        //////////////////////////////////////

        ResultSet resultSet = null;
        try {
            statement2 = this.conn2.createStatement();
            resultSet = statement2.executeQuery("SELECT * FROM '" + organParam + "' Where BloodType = '" + bloodType + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (resultSet.next()) {
            try {
                String donFirstName = resultSet.getString(1);
                String donLastName = resultSet.getString(2);
                String donGender = resultSet.getString(3);
                String donAge = resultSet.getString(4);
                String donWeight = resultSet.getString(5);
                String donEmail = resultSet.getString(6);
                String donOrgan = resultSet.getString(7);
                String donBloodType = resultSet.getString(8);
                String donDp1 = resultSet.getString(9);
                String donDp2 = resultSet.getString(10);
                String donDp3 = resultSet.getString(11);
                String donAbc1 = resultSet.getString(12);
                String donAbc2 = resultSet.getString(13);
                String donAbc3 = resultSet.getString(14);
                String donDrb1 = resultSet.getString(15);
                String donDrb2 = resultSet.getString(16);
                String donDrb3 = resultSet.getString(17);
                String donDq1 = resultSet.getString(18);
                String donDq2 = resultSet.getString(19);
                String donDq3 = resultSet.getString(20);
                String donMica1 = resultSet.getString(21);
                String donMica2 = resultSet.getString(22);
                String donMica3 = resultSet.getString(23);

            } catch (SQLException e) {
                e.printStackTrace();
            }
       }



//        statement10 = this.conn2.createStatement();
//        int deletedRows = statement10.executeUpdate("DELETE FROM TempTable;");

        return resultSet;
    }
}