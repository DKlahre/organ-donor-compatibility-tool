package com.proj.organtransplantapp.Models;

import javafx.application.Application;
import javafx.stage.Stage;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
     String [] micaDonorArray = new String[64];
     String [] dqDonorArray = new String[64];
     String [] drbDonorArray = new String[64];
     String [] abcDonorArray = new String[64];
     String [] dpDonorArray = new String[64];

    List <ResultSet> resultSetEpletList = new ArrayList<>();



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

    //// Parameters are from the chosen transplant candidate
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

        int candDpRequisite = (int) Double.parseDouble(dp);
        int candAbcRequisite = (int) Double.parseDouble(abc);
        int candDrbRequisite = (int) Double.parseDouble(drb);
        int candDqRequisite = (int) Double.parseDouble(dq);
        int candMicaRequisite = (int) Double.parseDouble(mica);

        int candDpAprRequisite = (int) Double.parseDouble(dpApr);
        int candAbcAprRequisite = (int) Double.parseDouble(abcApr);
        int candDrbAprRequisite = (int) Double.parseDouble(drbApr);
        int candDqAprRequisite = (int) Double.parseDouble(dqApr);
        int candMicaAprRequisite = (int) Double.parseDouble(micaApr);

        System.out.println("candDpRequisite " + candDpRequisite);
        System.out.println("candAbcRequisite " + candAbcRequisite);
        System.out.println("candDrbRequisite " + candDrbRequisite);
        System.out.println("candDqRequisite " + candDqRequisite);
        System.out.println("candMicaRequisite " + candMicaRequisite);
        System.out.println("candDpAprRequisite " + candDpAprRequisite);
        System.out.println("candAbcAprRequisite " + candAbcAprRequisite);
        System.out.println("candDrbAprRequisite " + candDrbAprRequisite);
        System.out.println("candDqAprRequisite " + candDqAprRequisite);
        System.out.println("candMicaAprRequisite " + candMicaAprRequisite);

        ResultSet donResultSet = null;
        try {
            statement2 = this.conn2.createStatement();
            donResultSet = statement2.executeQuery("SELECT * FROM '" + organParam + "' Where BloodType = '" + bloodType + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (donResultSet.next()) {
            try {
                String donFirstName = donResultSet.getString(1);
                String donLastName = donResultSet.getString(2);
                String donGender = donResultSet.getString(3);
                String donAge = donResultSet.getString(4);
                String donWeight = donResultSet.getString(5);
                System.out.println("donWeight " + donWeight);
                String donEmail = donResultSet.getString(6);
                System.out.println("donEmail " + donEmail);
                String donOrgan = donResultSet.getString(7);
                String donBloodType = donResultSet.getString(8);
                String donDp1 = donResultSet.getString(9);
                String donDp2 = donResultSet.getString(10);
                String donDp3 = donResultSet.getString(11);
                String donAbc1 = donResultSet.getString(12);
                String donAbc2 = donResultSet.getString(13);
                String donAbc3 = donResultSet.getString(14);
                String donDrb1 = donResultSet.getString(15);
                String donDrp2 = donResultSet.getString(16);
                String donDrb3 = donResultSet.getString(17);
                String donDq1 = donResultSet.getString(18);
                String donDq2 = donResultSet.getString(19);
                String donDq3 = donResultSet.getString(20);
                String donMica1 = donResultSet.getString(21);
                String donMica2 = donResultSet.getString(22);
                String donMica3 = donResultSet.getString(23);
//                statement3 = this.conn2.createStatement();
//                statement3.executeUpdate("INSERT INTO TempTable(FirstName, LastName, Gender, Age, Weight, Email, Organ, BloodType, " +
//                        "DP1, DP2, DP3, ABC1, ABC2, ABC3, DRB1, DRB2, DRB3, DQ1, DQ2, DQ3, MICA1, MICA2, MICA3)" +
//                        "VALUES ('" + donFirstName + "', '" + donLastName + "', '" + donGender + "', '" + donAge + "', '" + donWeight + "', '" + donEmail + "', '" + donOrgan + "', '" + donBloodType +
//                        "', '" + donDp1 + "', '" + donDp2 + "', '" + donDp3 + "', '" + donAbc1 + "', '" + donAbc2 + "', '" + donAbc3 + "', '" + donDrb1 + "', '" + donDrp2 + "', '" + donDrb3 +
//                        "','" + donDq1 + "', '" + donDq2 + "', '" + donDq3 + "', '" + donMica1 + "', '" + donMica2 + "', '" + donMica3 + "');");
            } catch (SQLException e) {
                e.printStackTrace();
            }
       }


        ResultSet resultSetPickedCandidate = null;
        ResultSet resultSetEplets = null;
        try{
            statement5 = this.conn4.createStatement();
            resultSetEplets = statement5.executeQuery("SELECT * FROM Eplets");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        statement9 = this.conn4.createStatement();
        for (int m = 0 ; m < 6 ; m++){
               resultSetEpletList.add(resultSetEplets = statement9.executeQuery("SELECT * FROM Eplets"));}



        int j = 0;
        int q = 0;

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
                String candDp2 = resultSetPickedCandidate.getString(10);
                String candDp3 = resultSetPickedCandidate.getString(11);

        ResultSet donorResultSet = null;
        try {
            statement7 = this.conn2.createStatement();
            donorResultSet = statement7.executeQuery("SELECT * FROM '" + organParam + "' Where BloodType = '" + bloodType + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        while (donorResultSet.next()) {
//            System.out.println("Under first while");
//            String donMica1 = donorResultSet.getString(21);
//            String donMica2 = donorResultSet.getString(22);
//            String donMica3 = donorResultSet.getString(23);
//            String donDq1 = donorResultSet.getString(18);
//            String donDq2 = donorResultSet.getString(19);
//            String donDq3 = donorResultSet.getString(20);
//            String donDrb1 = donorResultSet.getString(15);
//            String donDrb2 = donorResultSet.getString(16);
//            String donDrb3 = donorResultSet.getString(17);
//            String donAbc1 = donorResultSet.getString(12);
//            String donAbc2 = donorResultSet.getString(13);
//            String donAbc3 = donorResultSet.getString(14);
//            String donDp1 = donorResultSet.getString(9);
//            String donDp2 = donorResultSet.getString(10);
//            String donDp3 = donorResultSet.getString(11);

//        while (resultSetEplets.next()) {
//            System.out.println("Under second while");
//            try {
//
//                micaSourceArray[j] = resultSetEplets.getString(5);
//                dqSourceArray[j] = resultSetEplets.getString(4);
//                drbSourceArray[j] = resultSetEplets.getString(3);
//                abcSourceArray[j] = resultSetEplets.getString(2);
//                dpSourceArray[j] = resultSetEplets.getString(1);
//                //micaDonorArray[j] = donResultSet.getString(5);
//                System.out.println("micaSourceArray[j] " + micaSourceArray[j]);
//                System.out.println("dqSourceArray[j] " + dqSourceArray[j]);
//                System.out.println("drbSourceArray[j] " + drbSourceArray[j]);
//                System.out.println("abcSourceArray[j] " + abcSourceArray[j]);
//                System.out.println("dpSourceArray[j] " + dpSourceArray[j]);
//
////                if (Objects.equals(micaSourceArray[j], donMica1) || Objects.equals(micaSourceArray[j], donMica2) || Objects.equals(micaSourceArray[j], donMica3)) {
////                    micaMatchCount++;
////                }
////                if (Objects.equals(dqSourceArray[j], donDq1) || Objects.equals(dqSourceArray[j], donDq2) || Objects.equals(dqSourceArray[j], donDq3)) {
////                    dqMatchCount++;
////                }
////                if (Objects.equals(drbSourceArray[j], donDrb1) || Objects.equals(drbSourceArray[j], donDrb2) || Objects.equals(drbSourceArray[j], donDrb3)) {
////                    drbMatchCount++;
////                }
////                if (Objects.equals(abcSourceArray[j], donAbc1) || Objects.equals(abcSourceArray[j], donAbc2) || Objects.equals(abcSourceArray[j], donAbc3)) {
////                    abcMatchCount++;
////                }
////                if (Objects.equals(dpSourceArray[j], donDp1) || Objects.equals(dpSourceArray[j], donDp2) || Objects.equals(dpSourceArray[j], donDp3)) {
////                    dpMatchCount++;
////                }
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            j++;
//            //q++;
//
//            System.out.println("micaMatchCount " + micaMatchCount);
//            System.out.println("dqMatchCount " + dqMatchCount);
//            System.out.println("drbMatchAccount " + drbMatchCount);
//            System.out.println("abcMatchAccount " + abcMatchCount);
//            System.out.println("dpMatchAccount " + dpMatchCount);
//
//
//        } // middle while
          //  resultSetEplets.beforeFirst();

     //   }









////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////
        /////////////////////////////////////////
        ///////////////////////////////////////
        ////////////////////////////////////

        while (resultSetEplets.next()) {
            System.out.println("Under second while");

            try {
                micaSourceArray[j] = resultSetEplets.getString(5);
                dqSourceArray[j] = resultSetEplets.getString(4);
                drbSourceArray[j] = resultSetEplets.getString(3);
                abcSourceArray[j] = resultSetEplets.getString(2);
                dpSourceArray[j] = resultSetEplets.getString(1);
                //micaDonorArray[j] = donResultSet.getString(5);
                System.out.println("micaSourceArray[j] " + micaSourceArray[j]);
                System.out.println("dqSourceArray[j] " + dqSourceArray[j]);
                System.out.println("drbSourceArray[j] " + drbSourceArray[j]);
                System.out.println("abcSourceArray[j] " + abcSourceArray[j]);
                System.out.println("dpSourceArray[j] " + dpSourceArray[j]);

            } catch (SQLException e) {
                e.printStackTrace();
            }

            j++;
        }

///////////////////////////////////////////////////////////////////////////////////////////////////

        int k = 0;
        String [] donMica1Array = new String[64];
        String [] donMica2Array = new String[64];
        String [] donMica3Array = new String[64];
        String [] donDq1Array = new String[64];
        String [] donDq2Array = new String[64];
        String [] donDq3Array = new String[64];
        String [] donDrb1Array = new String[64];
        String [] donDrb2Array = new String[64];
        String [] donDrb3Array = new String[64];
        String [] donAbc1Array = new String[64];
        String [] donAbc2Array = new String[64];
        String [] donAbc3Array = new String[64];
        String [] donDp1Array = new String[64];
        String [] donDp2Array = new String[64];
        String [] donDp3Array = new String[64];


        while (donorResultSet.next()) {
            System.out.println("Under first while");
            donMica1Array[k] = donorResultSet.getString(21);
            donMica2Array[k] = donorResultSet.getString(22);
            donMica3Array[k] = donorResultSet.getString(23);
            donDq1Array[k] = donorResultSet.getString(18);
            donDq2Array[k] = donorResultSet.getString(19);
            donDq3Array[k] = donorResultSet.getString(20);
            donDrb1Array[k] = donorResultSet.getString(15);
            donDrb2Array[k] = donorResultSet.getString(16);
            donDrb3Array[k] = donorResultSet.getString(17);
            donAbc1Array[k] = donorResultSet.getString(12);
            donAbc2Array[k] = donorResultSet.getString(13);
            donAbc3Array[k] = donorResultSet.getString(14);
            donDp1Array[k] = donorResultSet.getString(9);
            donDp2Array[k] = donorResultSet.getString(10);
            donDp3Array[k] = donorResultSet.getString(11);

            k++;
        }

        int donorSetSize = k;
        int epletSetSize = j;

        for (int p = 0; p < donorSetSize; p++) {
            for (int n = 0; n < epletSetSize; n++) {

                if (Objects.equals(micaSourceArray[n], donMica1Array[p]) || Objects.equals(micaSourceArray[n], donMica2Array[p]) || Objects.equals(micaSourceArray[n], donMica3Array[p])) {
                    micaMatchCount++;
                }
                if (Objects.equals(dqSourceArray[n], donDq1Array[p]) || Objects.equals(dqSourceArray[n], donDq2Array[p]) || Objects.equals(dqSourceArray[n], donDq3Array[p])) {
                    dqMatchCount++;
                }
                if (Objects.equals(drbSourceArray[n], donDrb1Array[p]) || Objects.equals(drbSourceArray[n], donDrb2Array[p]) || Objects.equals(drbSourceArray[n], donDrb3Array[p])) {
                    drbMatchCount++;
                }
                if (Objects.equals(abcSourceArray[n], donAbc1Array[p]) || Objects.equals(abcSourceArray[n], donAbc2Array[p]) || Objects.equals(abcSourceArray[n], donAbc3Array[p])) {
                    abcMatchCount++;
                }
                if (Objects.equals(dpSourceArray[n], donDp1Array[p]) || Objects.equals(dpSourceArray[n], donDp2Array[p]) || Objects.equals(dpSourceArray[n], donDp3Array[p])) {
                    dpMatchCount++;
                }

            }


          //  System.out.println("donorSetSize = " + donorSetSize);
          //  System.out.println("epletSetSize = " + epletSetSize);
            System.out.println("==============================");
            System.out.println("micaMatchCount " + micaMatchCount);
            System.out.println("candMicaRequisite " + candMicaRequisite );
            if (micaMatchCount <= candMicaRequisite) {
                System.out.println("micaRequisite met");
            }
           // candMicaAprRequisite

            System.out.println("dqMatchCount " + dqMatchCount);
            System.out.println("candDqRequisite " + candDqRequisite);
            if (dqMatchCount <= candDqRequisite) {
                System.out.println("dqRequisite met");
            }
           // candDqAprRequisite
            System.out.println("drbMatchAccount " + drbMatchCount);
            System.out.println("candDrbRequisite " + candDrbRequisite);
            if (drbMatchCount <= candDrbRequisite) {
                System.out.println("drbRequisite met");
            }
           // candDrbAprRequisite
            System.out.println("abcMatchAccount " + abcMatchCount);
            System.out.println("candAbcRequisite " + candAbcRequisite);
            if (abcMatchCount <= candAbcRequisite) {
                System.out.println("abcRequisite met");
            }
           // candAbcAprRequisite
            System.out.println("dpMatchAccount " + dpMatchCount);
            System.out.println("candDpRequisite " + candDpRequisite);
            if (dpMatchCount <= candDpRequisite) {
                System.out.println("dpRequisite met");
            }
           // candDpAprRequisite

            System.out.println("==============================");
            micaMatchCount = 0;
            dqMatchCount = 0;
            drbMatchCount = 0;
            abcMatchCount = 0;
            dpMatchCount = 0;
        }











//
//        System.out.println("micaApr " + micaApr);
//        System.out.println("dqApr " + dqApr);
//        System.out.println("drbApr " + drbApr);
//        System.out.println("abcApr " + abcApr);
//        System.out.println("dpApr " + dpApr);

        //////////////////////////////////////

//        ResultSet resultSet = null;
//        try {
//            statement2 = this.conn2.createStatement();
//            resultSet = statement2.executeQuery("SELECT * FROM '" + organParam + "' Where BloodType = '" + bloodType + "';");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        while (resultSet.next()) {
//            try {
//                String donFirstName = resultSet.getString(1);
//                String donLastName = resultSet.getString(2);
//                String donGender = resultSet.getString(3);
//                String donAge = resultSet.getString(4);
//                String donWeight = resultSet.getString(5);
//                String donEmail = resultSet.getString(6);
//                String donOrgan = resultSet.getString(7);
//                String donBloodType = resultSet.getString(8);
//                String donDp1 = resultSet.getString(9);
//                String donDp2 = resultSet.getString(10);
//                String donDp3 = resultSet.getString(11);
//                String donAbc1 = resultSet.getString(12);
//                String donAbc2 = resultSet.getString(13);
//                String donAbc3 = resultSet.getString(14);
//                String donDrb1 = resultSet.getString(15);
//                String donDrb2 = resultSet.getString(16);
//                String donDrb3 = resultSet.getString(17);
//                String donDq1 = resultSet.getString(18);
//                String donDq2 = resultSet.getString(19);
//                String donDq3 = resultSet.getString(20);
//                String donMica1 = resultSet.getString(21);
//                String donMica2 = resultSet.getString(22);
//                String donMica3 = resultSet.getString(23);
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//       }

//        statement10 = this.conn2.createStatement();
//        int deletedRows = statement10.executeUpdate("DELETE FROM TempTable;");

        return donResultSet;
    }
}