package com.proj.organtransplantapp.Models;

import com.proj.organtransplantapp.Views.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class Model {

    private static Model model;
    private final DatabaseDriver databaseDriver;
    private final ViewFactory viewFactory;

    private ObservableList<Candidate> candidates;
    private ObservableList<Candidate> candidate;
    public String emailStore;


    public Model() {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
    }

    public static synchronized Model getInstance() {
        if(model == null){
            model = new Model();
        }
        return model;
    }

    public ObservableList<Candidate> searchCandEmail(String email) {
        ObservableList<Candidate> searchResult = FXCollections.observableArrayList();
        ResultSet resultSet = databaseDriver.searchCandEmail(email);
        try {
            String candFirstName = resultSet.getString("FirstName");
            String candLastName = resultSet.getString("LastName");
            String candGender = resultSet.getString("Gender");
            String candAge = resultSet.getString("Age");
            String candWeight = resultSet.getString("Weight");
            String candEmail = resultSet.getString("Email");
            String candOrgan = resultSet.getString("Organ");
            String candBloodType = resultSet.getString("BloodType");
            String candDP1 = resultSet.getString("DP1");
            String candDP2 = resultSet.getString("DP2");
            String candDP3 = resultSet.getString("DP3");
            String candABC1 = resultSet.getString("ABC1");
            String candABC2 = resultSet.getString("ABC2");
            String candABC3 = resultSet.getString("ABC3");
            String candDRB1 = resultSet.getString("DRB1");
            String candDRB2 = resultSet.getString("DRB2");
            String candDRB3 = resultSet.getString("DRB3");
            String candDQ1 = resultSet.getString("DQ1");
            String candDQ2 = resultSet.getString("DQ2");
            String candDQ3 = resultSet.getString("DQ3");
            String candMICA1 = resultSet.getString("MICA1");
            String candMICA2 = resultSet.getString("MICA2");
            String candMICA3 = resultSet.getString("MICA3");
            searchResult.add(new Candidate(candFirstName, candLastName, candGender, candAge, candWeight,
                    candEmail, candOrgan, candBloodType, candDP1, candDP2, candDP3, candABC1, candABC2,
                    candABC3, candDRB1, candDRB2, candDRB3, candDQ1, candDQ2, candDQ3, candMICA1, candMICA2, candMICA3));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchResult;
    }

    public ObservableList<Candidate> searchCandLastName(String lastName){
        ObservableList<Candidate> searchResult = FXCollections.observableArrayList();
        ResultSet resultSet = databaseDriver.searchCandLastName(lastName);
        try {
            while (resultSet.next()) {
                String candFirstName = resultSet.getString("FirstName");
                String candLastName = resultSet.getString("LastName");
                String candGender = resultSet.getString("Gender");
                String candAge = resultSet.getString("Age");
                String candWeight = resultSet.getString("Weight");
                String candEmail = resultSet.getString("Email");
                String candOrgan = resultSet.getString("Organ");
                String candBloodType = resultSet.getString("BloodType");
                String candDP1 = resultSet.getString("DP1");
                String candDP2 = resultSet.getString("DP2");
                String candDP3 = resultSet.getString("DP3");
                String candABC1 = resultSet.getString("ABC1");
                String candABC2 = resultSet.getString("ABC2");
                String candABC3 = resultSet.getString("ABC3");
                String candDRB1 = resultSet.getString("DRB1");
                String candDRB2 = resultSet.getString("DRB2");
                String candDRB3 = resultSet.getString("DRB3");
                String candDQ1 = resultSet.getString("DQ1");
                String candDQ2 = resultSet.getString("DQ2");
                String candDQ3 = resultSet.getString("DQ3");
                String candMICA1 = resultSet.getString("MICA1");
                String candMICA2 = resultSet.getString("MICA2");
                String candMICA3 = resultSet.getString("MICA3");
                searchResult.add(new Candidate(candFirstName, candLastName, candGender, candAge, candWeight,
                        candEmail, candOrgan, candBloodType, candDP1, candDP2, candDP3, candABC1, candABC2,
                        candABC3, candDRB1, candDRB2, candDRB3, candDQ1, candDQ2, candDQ3, candMICA1, candMICA2, candMICA3));
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        return searchResult;
    }

    public ObservableList<Donor> searchDonors(String organ, String bloodType, String micaApr, String dqApr, String drbApr, String abcApr, String dpApr, String dp, String abc, String drb, String dq, String mica)  {
        ObservableList<Donor> searchResult = FXCollections.observableArrayList();

        try {
            ResultSet resultSet = databaseDriver.searchDonorsDB(organ, bloodType, micaApr, dqApr, drbApr, abcApr, dpApr, dp, abc, drb, dq, mica);
            while (resultSet.next()) {
                String donFirstName = resultSet.getString("FirstName");
                String donLastName = resultSet.getString("LastName");
                String donGender = resultSet.getString("Gender");
                String donAge = resultSet.getString("Age");
                String donWeight = resultSet.getString("Weight");
                String donEmail = resultSet.getString("Email");
                String donOrgan = resultSet.getString("Organ");
                String donBloodType = resultSet.getString("BloodType");
                String donDP1 = resultSet.getString("DP1");
                String donDP2 = resultSet.getString("DP2");
                String donDP3 = resultSet.getString("DP3");
                String donABC1 = resultSet.getString("ABC1");
                String donABC2 = resultSet.getString("ABC2");
                String donABC3 = resultSet.getString("ABC3");
                String donDRB1 = resultSet.getString("DRB1");
                String donDRB2 = resultSet.getString("DRB2");
                String donDRB3 = resultSet.getString("DRB3");
                String donDQ1 = resultSet.getString("DQ1");
                String donDQ2 = resultSet.getString("DQ2");
                String donDQ3 = resultSet.getString("DQ3");
                String donMICA1 = resultSet.getString("MICA1");
                String donMICA2 = resultSet.getString("MICA2");
                String donMICA3 = resultSet.getString("MICA3");
                searchResult.add(new Donor(donFirstName, donLastName, donGender, donAge, donWeight,
                        donEmail, donOrgan, donBloodType, donDP1, donDP2, donDP3, donABC1, donABC2,
                        donABC3, donDRB1, donDRB2, donDRB3, donDQ1, donDQ2, donDQ3, donMICA1, donMICA2, donMICA3));
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        return searchResult;
    }




    public void emailStore (String emailStore) {
        this.emailStore = emailStore;
        System.out.println("emailStore: " + emailStore);
        // return emailStore;
    }

    public String getEmailStore() {
        return emailStore;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public DatabaseDriver getDatabaseDriver() {
        return databaseDriver;
    }

//    public ObservableList<Donor> getTheDonors(){
//        ObservableList<Donor> searchResult = FXCollections.observableArrayList();
//
//        try {
//            ResultSet resultSet = databaseDriver.getDonors();
//            while (resultSet.next()) {
//                String donFirstName = resultSet.getString("FirstName");
//                String donLastName = resultSet.getString("LastName");
//                String donGender = resultSet.getString("Gender");
//                String donAge = resultSet.getString("Age");
//                String donWeight = resultSet.getString("Weight");
//                String donEmail = resultSet.getString("Email");
//                String donOrgan = resultSet.getString("Organ");
//                String donBloodType = resultSet.getString("BloodType");
//                String donDP1 = resultSet.getString("DP1");
//                System.out.println("donDP1 " + donDP1);
//                String donDP2 = resultSet.getString("DP2");
//                String donDP3 = resultSet.getString("DP3");
//                String donABC1 = resultSet.getString("ABC1");
//                String donABC2 = resultSet.getString("ABC2");
//                String donABC3 = resultSet.getString("ABC3");
//                String donDRB1 = resultSet.getString("DRB1");
//                String donDRB2 = resultSet.getString("DRB2");
//                String donDRB3 = resultSet.getString("DRB3");
//                String donDQ1 = resultSet.getString("DQ1");
//                String donDQ2 = resultSet.getString("DQ2");
//                String donDQ3 = resultSet.getString("DQ3");
//                String donMICA1 = resultSet.getString("MICA1");
//                System.out.println("donMICA1 " + donMICA1);
//                String donMICA2 = resultSet.getString("MICA2");
//                String donMICA3 = resultSet.getString("MICA3");
//                searchResult.add(new Donor(donFirstName, donLastName, donGender, donAge, donWeight,
//                        donEmail, donOrgan, donBloodType, donDP1, donDP2, donDP3, donABC1, donABC2,
//                        donABC3, donDRB1, donDRB2, donDRB3, donDQ1, donDQ2, donDQ3, donMICA1, donMICA2, donMICA3));
//            }
//        } catch(Exception e){
//            e.printStackTrace();
//        }
//
//        return searchResult;
//    };

}
