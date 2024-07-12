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
    public ResultSet searchDonorsDB(String organParam, String bloodType, String mica, String dq, String drb, String abc, String dp, String dpApr, String abcApr, String drbApr, String dqApr, String micaApr) throws SQLException {
        Statement statement2;
        Statement statement3;
        Statement statement4;
        Statement statement5;

        Statement statement7;

        Statement statement9;
//        Statement statement10;

        int candDpAprRequisite = (int) Double.parseDouble(dpApr);
        int candAbcAprRequisite = (int) Double.parseDouble(abcApr);
        int candDrbAprRequisite = (int) Double.parseDouble(drbApr);
        int candDqAprRequisite = (int) Double.parseDouble(dqApr);
        int candMicaAprRequisite = (int) Double.parseDouble(micaApr);

        int candDpRequisite = (int) Double.parseDouble(dp);
        int candAbcRequisite = (int) Double.parseDouble(abc);
        int candDrbRequisite = (int) Double.parseDouble(drb);
        int candDqRequisite = (int) Double.parseDouble(dq);
        int candMicaRequisite = (int) Double.parseDouble(mica);


        ResultSet donResultSet = null;
        try {
            statement2 = this.conn2.createStatement();
            donResultSet = statement2.executeQuery("SELECT * FROM '" + organParam + "' Where BloodType = '" + bloodType + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ///////////////////////////////

//        Statement statement;
//        ResultSet resultSet = null;
//        try {
//            statement = this.conn1.createStatement();
//            resultSet = statement.executeQuery("SELECT * FROM Candidates Where Email = '" + email + "';");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        ///////////////////////////////////

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
        boolean micaAprRequisiteSatisfied = false;
        boolean dqAprRequisiteSatisfied = false;
        boolean drbAprRequisiteSatisfied = false;
        boolean abcAprRequisiteSatisfied = false;
        boolean dpAprRequisiteSatisfied = false;


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
                String candBloodType = resultSetPickedCandidate.getString(8);
                String candOrgan = resultSetPickedCandidate.getString(7);
                String candEmail = resultSetPickedCandidate.getString(6);
                String candWeight = resultSetPickedCandidate.getString(5);
                String candAge = resultSetPickedCandidate.getString(4);
                String candGender = resultSetPickedCandidate.getString(3);
                String candLastName = resultSetPickedCandidate.getString(2);
                String candFirstName = resultSetPickedCandidate.getString(1);

        ResultSet donorResultSet = null;
        try {
            statement7 = this.conn2.createStatement();
            donorResultSet = statement7.executeQuery("SELECT * FROM '" + organParam + "' Where BloodType = '" + bloodType + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        while (resultSetEplets.next()) {

            try {
                micaSourceArray[j] = resultSetEplets.getString(5);
                dqSourceArray[j] = resultSetEplets.getString(4);
                drbSourceArray[j] = resultSetEplets.getString(3);
                abcSourceArray[j] = resultSetEplets.getString(2);
                dpSourceArray[j] = resultSetEplets.getString(1);

            } catch (SQLException e) {
                e.printStackTrace();
            }

            j++;
        }

///////////////////////////////////////////////////////////////////////////////////////////////////

        int k = 0;

        String [] donOrganArray = new String[64];
        String [] donBloodTypeArray = new String[64];
        String [] donEmailArray = new String[64];
        String [] donWeightArray = new String[64];
        String [] donAgeArray = new String[64];
        String [] donGenderArray = new String[64];
        String [] donLastNameArray = new String[64];
        String [] donFirstNameArray = new String[64];
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
            donBloodTypeArray[k] = donorResultSet.getString(8);
            donOrganArray[k] = donorResultSet.getString(7);
            donEmailArray[k] = donorResultSet.getString(6);
            donWeightArray[k] = donorResultSet.getString(5);
            donAgeArray[k] = donorResultSet.getString(4);
            donGenderArray[k] = donorResultSet.getString(3);
            donLastNameArray[k] = donorResultSet.getString(2);
            donFirstNameArray[k] = donorResultSet.getString(1);

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


            if (candMicaAprRequisite >= 99) {
                candMicaAprRequisite = 3;
            } else if (candMicaAprRequisite == 66) {
                candMicaAprRequisite = 2;
            } else if (candMicaAprRequisite == 33) {
                candMicaAprRequisite = 1; }

            if (candDqAprRequisite >= 99) {
                candDqAprRequisite  = 3;
            } else if (candDqAprRequisite  == 66) {
                candDqAprRequisite  = 2;
            } else if (candDqAprRequisite  == 33) {
                candDqAprRequisite  = 1; }

            if (candDrbAprRequisite >= 99) {
                candDrbAprRequisite = 3;
            } else if (candDrbAprRequisite == 66) {
                candDrbAprRequisite = 2;
            } else if (candDrbAprRequisite == 33) {
                candDrbAprRequisite = 1; }

            if (candAbcAprRequisite >= 99) {
                candAbcAprRequisite = 3;
            } else if (candAbcAprRequisite == 66) {
                candAbcAprRequisite = 2;
            } else if (candAbcAprRequisite == 33) {
                candAbcAprRequisite = 1; }

            if (candDpAprRequisite >= 99) {
                candDpAprRequisite = 3;
            } else if (candDpAprRequisite == 66) {
                candDpAprRequisite = 2;
            } else if (candDpAprRequisite == 33) {
                candDpAprRequisite = 1; }

            /////////////

            System.out.println("=====================");
            if (micaMatchCount >= candMicaAprRequisite) {
                micaAprRequisiteSatisfied = true;
                System.out.println("micaMatchCount " + micaMatchCount);
                System.out.println("candMicaAprRequisite " + candMicaAprRequisite);
                System.out.println("micaAprRequisiteSatisfied = true");
            } else {
                System.out.println("micaMatchCount " + micaMatchCount);
                System.out.println("candMicaAprRequisite " + candMicaAprRequisite);
                System.out.println("micaAprRequisiteSatisfied = false");}
            System.out.println("=====================");
            if (dqMatchCount >= candDqAprRequisite) {
                dqAprRequisiteSatisfied = true;
                System.out.println("dqMatchCount " + dqMatchCount);
                System.out.println("candDqAprRequisite " + candDqAprRequisite);
                System.out.println("dqAprRequisiteSatisfied = true");
            } else {
                System.out.println("dqMatchCount " + dqMatchCount);
                System.out.println("candDqAprRequisite " + candDqAprRequisite);
                System.out.println("dqAprRequisiteSatisfied  = false");}
            System.out.println("=====================");
            if (drbMatchCount >= candDrbAprRequisite) {
                drbAprRequisiteSatisfied = true;
                System.out.println("drbMatchCount " + drbMatchCount);
                System.out.println("candDrbAprRequisite " + candDrbAprRequisite);
                System.out.println("drbAprRequisiteSatisfied = true");
            } else {
                System.out.println("drbMatchCount " + drbMatchCount);
                System.out.println("candDrbAprRequisite " + candDrbAprRequisite);
                System.out.println("drbAprRequisiteSatisfied  = false");}
            System.out.println("=====================");
            if (abcMatchCount >= candAbcAprRequisite) {
                abcAprRequisiteSatisfied = true;
                System.out.println("abcMatchCount " + abcMatchCount);
                System.out.println("candAbcAprRequisite " + candAbcAprRequisite);
                System.out.println("abcAprRequisiteSatisfied = true");
            } else {
                System.out.println("abcMatchCount " + abcMatchCount);
                System.out.println("candAbcAprRequisite " + candAbcAprRequisite);
                System.out.println("abcAprRequisiteSatisfied  = false");}
            System.out.println("=====================");
            if (dpMatchCount >= candDpAprRequisite) {
                dpAprRequisiteSatisfied = true;
                System.out.println("dpMatchCount " + dpMatchCount);
                System.out.println("candDpAprRequisite " + candDpAprRequisite);
                System.out.println("dpAprRequisiteSatisfied = true");
            } else {
                System.out.println("dpMatchCount " + dpMatchCount);
                System.out.println("candDpAprRequisite " + candDpAprRequisite);
                System.out.println("dpAprRequisiteSatisfied  = false");}
            System.out.println("=====================");

            if (((dpAprRequisiteSatisfied) && (abcAprRequisiteSatisfied) && (drbAprRequisiteSatisfied) && (dqAprRequisiteSatisfied) && (micaAprRequisiteSatisfied))) {
                System.out.println("All five conditions met ");

                statement9 = this.conn2.createStatement();
                statement9.executeUpdate("INSERT INTO TempTable(FirstName, LastName, Gender, Age, Weight, Email, Organ, BloodType, " +
                        "DP1, DP2, DP3, ABC1, ABC2, ABC3, DRB1, DRB2, DRB3, DQ1, DQ2, DQ3, MICA1, MICA2, MICA3)" +
                        "VALUES ('" + donFirstNameArray[p] + "', '" + donLastNameArray[p] + "', '" + donGenderArray[p] + "', '" + donAgeArray[p] + "', '" + donWeightArray[p] + "', '" + donEmailArray[p] + "', '" + donOrganArray[p] + "', '" + donBloodTypeArray[p] +
                        "', '" + donDp1Array[p] + "', '" + donDp2Array[p] + "', '" + donDp3Array[p] + "', '" + donAbc1Array[p] + "', '" + donAbc2Array[p] + "', '" + donAbc3Array[p] + "', '" + donDrb1Array[p] + "', '" + donDrb2Array[p] + "', '" + donDrb3Array[p] +
                        "','" + donDq1Array[p] + "', '" + donDq2Array[p] + "', '" + donDq3Array[p] + "', '" + donMica1Array[p] + "', '" + donMica2Array[p] + "', '" + donMica3Array[p] + "');");

            } else {
                System.out.println("All five conditions not met ");
            }

            micaMatchCount = 0;
            dqMatchCount = 0;
            drbMatchCount = 0;
            abcMatchCount = 0;
            dpMatchCount = 0;
            dpAprRequisiteSatisfied = false;
            abcAprRequisiteSatisfied = false;
            drbAprRequisiteSatisfied = false;
            dqAprRequisiteSatisfied = false;
            micaAprRequisiteSatisfied = false;

        }

        candDonorCheck(resultSetPickedCandidate, candMicaRequisite, candDqRequisite, candDrbRequisite, candAbcRequisite, candDpRequisite);



        return donResultSet;
    }

    private ResultSet candDonorCheck(ResultSet resultSetPickedCandidate, int candMicaRequisite, int candDqRequisite, int candDrbRequisite, int candAbcRequisite, int candDpRequisite) throws SQLException {


        int micaMatchCount = 0;
        int dqMatchCount = 0;
        int drbMatchCount = 0;
        int abcMatchCount = 0;
        int dpMatchCount = 0;
        int h = 0;
        int k = 0;
        int epletMatchTotal = 0;
        boolean micaRequisiteSatisfied = false;
        boolean dqRequisiteSatisfied = false;
        boolean drbRequisiteSatisfied = false;
        boolean abcRequisiteSatisfied = false;
        boolean dpRequisiteSatisfied = false;


        Statement statement8;
        Statement statement6;
        Statement statement10;
        Statement statement11;

        String [] filteredDonMica1Array = new String[64];
        String [] filteredDonMica2Array = new String[64];
        String [] filteredDonMica3Array = new String[64];
        String [] filteredDonDq1Array = new String[64];
        String [] filteredDonDq2Array = new String[64];
        String [] filteredDonDq3Array = new String[64];
        String [] filteredDonDrb1Array = new String[64];
        String [] filteredDonDrb2Array = new String[64];
        String [] filteredDonDrb3Array = new String[64];
        String [] filteredDonAbc1Array = new String[64];
        String [] filteredDonAbc2Array = new String[64];
        String [] filteredDonAbc3Array = new String[64];
        String [] filteredDonDp1Array = new String[64];
        String [] filteredDonDp2Array = new String[64];
        String [] filteredDonDp3Array = new String[64];
        String [] filteredDonBloodTypeArray = new String[64];
        String [] filteredDonOrganArray = new String[64];
        String [] filteredDonEmailArray = new String[64];
        String [] filteredDonWeightArray = new String[64];
        String [] filteredDonAgeArray = new String[64];
        String [] filteredDonGenderArray = new String[64];
        String [] filteredDonLastNameArray = new String[64];
        String [] filteredDonFirstNameArray = new String[64];

        String [] candMica1Array = new String[1];
        String [] candMica2Array = new String[1];
        String [] candMica3Array = new String[1];
        String [] candDq1Array = new String[1];
        String [] candDq2Array = new String[1];
        String [] candDq3Array = new String[1];
        String [] candDrb1Array = new String[1];
        String [] candDrb2Array = new String[1];
        String [] candDrb3Array = new String[1];
        String [] candAbc1Array = new String[1];
        String [] candAbc2Array = new String[1];
        String [] candAbc3Array = new String[1];
        String [] candDp1Array = new String[1];
        String [] candDp2Array = new String[1];
        String [] candDp3Array = new String[1];
        String [] candBloodTypeArray = new String[1];
        String [] candOrganArray = new String[1];
        String [] candEmailArray = new String[1];
        String [] candWeightArray = new String[1];
        String [] candAgeArray = new String[1];
        String [] candGenderArray = new String[1];
        String [] candLastNameArray = new String[1];
        String [] candFirstNameArray = new String[1];


        statement10 = this.conn2.createStatement();
        int deletedRows2 = statement10.executeUpdate("DELETE FROM TempTable2;");

       // Statement statement8;
        ResultSet tempResultSet = null;
        try {
            statement8 = this.conn2.createStatement();
            tempResultSet = statement8.executeQuery("SELECT * FROM TempTable;");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet rpc = resultSetPickedCandidate;

        while (rpc.next()) {

            candMica1Array[0] = rpc.getString(21);
            candMica2Array[0] = rpc.getString(22);
            candMica3Array[0] = rpc.getString(23);
            candDq1Array[0] = rpc.getString(18);
            candDq2Array[0] = rpc.getString(19);
            candDq3Array[0] = rpc.getString(20);
            candDrb1Array[0] = rpc.getString(15);
            candDrb2Array[0] = rpc.getString(16);
            candDrb3Array[0] = rpc.getString(17);
            candAbc1Array[0] = rpc.getString(12);
            candAbc2Array[0] = rpc.getString(13);
            candAbc3Array[0] = rpc.getString(14);
            candDp1Array[0] = rpc.getString(9);
            candDp2Array[0] = rpc.getString(10);
            candDp3Array[0] = rpc.getString(11);
            candBloodTypeArray[0] = rpc.getString(8);
            candOrganArray[0] = rpc.getString(7);
            candEmailArray[0] = rpc.getString(6);
            candWeightArray[0] = rpc.getString(5);
            candAgeArray[0] = rpc.getString(4);
            candGenderArray[0] = rpc.getString(3);
            candLastNameArray[0] = rpc.getString(2);
            candFirstNameArray[0] = rpc.getString(1);

        }

        while (tempResultSet.next()) {

            filteredDonMica1Array[k] = tempResultSet.getString(21);
            filteredDonMica2Array[k] = tempResultSet.getString(22);
            filteredDonMica3Array[k] = tempResultSet.getString(23);
            filteredDonDq1Array[k] = tempResultSet.getString(18);
            filteredDonDq2Array[k] = tempResultSet.getString(19);
            filteredDonDq3Array[k] = tempResultSet.getString(20);
            filteredDonDrb1Array[k] = tempResultSet.getString(15);
            filteredDonDrb2Array[k] = tempResultSet.getString(16);
            filteredDonDrb3Array[k] = tempResultSet.getString(17);
            filteredDonAbc1Array[k] = tempResultSet.getString(12);
            filteredDonAbc2Array[k] = tempResultSet.getString(13);
            filteredDonAbc3Array[k] = tempResultSet.getString(14);
            filteredDonDp1Array[k] = tempResultSet.getString(9);
            filteredDonDp2Array[k] = tempResultSet.getString(10);
            filteredDonDp3Array[k] = tempResultSet.getString(11);
            filteredDonBloodTypeArray[k] = tempResultSet.getString(8);
            filteredDonOrganArray[k] = tempResultSet.getString(7);
            filteredDonEmailArray[k] = tempResultSet.getString(6);
            filteredDonWeightArray[k] = tempResultSet.getString(5);
            filteredDonAgeArray[k] = tempResultSet.getString(4);
            filteredDonGenderArray[k] = tempResultSet.getString(3);
            filteredDonLastNameArray[k] = tempResultSet.getString(2);
            filteredDonFirstNameArray[k] = tempResultSet.getString(1);

            k++;

        }

        int filteredDonArraySize = k;

        int filteredMicaMatchTotal = 0;
        int filteredDqMatchTotal = 0;
        int filteredDrbMatchTotal = 0;
        int filteredAbcMatchTotal = 0;
        int filteredDpMatchTotal = 0;

        System.out.println("");
        System.out.println("donorArraysize " + filteredDonArraySize);


        for (int i = 0; i < filteredDonArraySize; i++) {
                if (filteredDonMica1Array[i].equals(candMica1Array[0])) {filteredMicaMatchTotal++;}
                if (filteredDonMica2Array[i].equals(candMica2Array[0])) {filteredMicaMatchTotal++;}
                if (filteredDonMica3Array[i].equals(candMica3Array[0])) {filteredMicaMatchTotal++;}
                if (filteredDonDq1Array[i].equals(candDq1Array[0])) {filteredDqMatchTotal++;}
                if (filteredDonDq2Array[i].equals(candDq2Array[0])) {filteredDqMatchTotal++;}
                if (filteredDonDq3Array[i].equals(candDq3Array[0])) {filteredDqMatchTotal++;}
                if (filteredDonDrb1Array[i].equals(candDrb1Array[0])) {filteredDrbMatchTotal++;}
                if (filteredDonDrb2Array[i].equals(candDrb2Array[0])) {filteredDrbMatchTotal++;}
                if (filteredDonDrb3Array[i].equals(candDrb3Array[0])) {filteredDrbMatchTotal++;}
                if (filteredDonAbc1Array[i].equals(candAbc1Array[0])) {filteredAbcMatchTotal++;}
                if (filteredDonAbc2Array[i].equals(candAbc2Array[0])) {filteredAbcMatchTotal++;}
                if (filteredDonAbc3Array[i].equals(candAbc3Array[0])) {filteredAbcMatchTotal++;}
                if (filteredDonDp1Array[i].equals(candDp1Array[0])) {filteredDpMatchTotal++;}
                if (filteredDonDp2Array[i].equals(candDp2Array[0])) {filteredDpMatchTotal++;}
                if (filteredDonDp3Array[i].equals(candDp3Array[0])) {filteredDpMatchTotal++;}
                ////// rest of the remaining lines here

            System.out.println("");
            System.out.println("filteredMicaMatchTotal " + filteredMicaMatchTotal);
            System.out.println("filteredDqMatchTotal " + filteredDqMatchTotal);
            System.out.println("filteredDrbMatchTotal " + filteredDrbMatchTotal);
            System.out.println("filteredAbcMatchTotal " + filteredAbcMatchTotal);
            System.out.println("filteredDpMatchTotal " + filteredDpMatchTotal);

            if (filteredMicaMatchTotal == candMicaRequisite) {micaRequisiteSatisfied = true;}
            if (filteredDqMatchTotal == candDqRequisite) {dqRequisiteSatisfied = true;}
            if (filteredDrbMatchTotal == candDrbRequisite) {drbRequisiteSatisfied = true;}
            if (filteredAbcMatchTotal == candAbcRequisite) {abcRequisiteSatisfied = true;}
            if (filteredDpMatchTotal == candDpRequisite) { dpRequisiteSatisfied = true;}



            if (micaRequisiteSatisfied && dqRequisiteSatisfied && drbRequisiteSatisfied && abcRequisiteSatisfied && dpRequisiteSatisfied) {
                statement6 = this.conn2.createStatement();
                statement6.executeUpdate("INSERT INTO TempTable2(FirstName, LastName, Gender, Age, Weight, Email, Organ, BloodType, " +
                        "DP1, DP2, DP3, ABC1, ABC2, ABC3, DRB1, DRB2, DRB3, DQ1, DQ2, DQ3, MICA1, MICA2, MICA3)" +
                        "VALUES ('" + filteredDonFirstNameArray[i] + "', '" + filteredDonLastNameArray[i] + "', '" + filteredDonGenderArray[i] + "', '" + filteredDonAgeArray[i] + "', '" + filteredDonWeightArray[i] + "', '" + filteredDonEmailArray[i] + "', '" + filteredDonOrganArray[i] + "', '" + filteredDonBloodTypeArray[i] +
                        "', '" + filteredDonDp1Array[i] + "', '" + filteredDonDp2Array[i] + "', '" + filteredDonDp3Array[i] + "', '" + filteredDonAbc1Array[i] + "', '" + filteredDonAbc2Array[i] + "', '" + filteredDonAbc3Array[i] + "', '" + filteredDonDrb1Array[i] + "', '" + filteredDonDrb2Array[i] + "', '" + filteredDonDrb3Array[i] +
                        "','" + filteredDonDq1Array[i] + "', '" + filteredDonDq2Array[i] + "', '" + filteredDonDq3Array[i] + "', '" + filteredDonMica1Array[i] + "', '" + filteredDonMica2Array[i] + "', '" + filteredDonMica3Array[i] + "');");
            }

          micaRequisiteSatisfied = true;
          dqRequisiteSatisfied = true;
          drbRequisiteSatisfied = true;
          abcRequisiteSatisfied = true;
          dpRequisiteSatisfied = true;

          filteredMicaMatchTotal = 0;
          filteredDqMatchTotal = 0;
          filteredDrbMatchTotal = 0;
          filteredAbcMatchTotal = 0;
          filteredDpMatchTotal = 0;


        }


            statement10 = this.conn2.createStatement();
            int deletedRows = statement10.executeUpdate("DELETE FROM TempTable;");


        return resultSetPickedCandidate;
    }
}