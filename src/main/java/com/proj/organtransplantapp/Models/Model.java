package com.proj.organtransplantapp.Models;

import com.proj.organtransplantapp.Views.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

public class Model {

    private static Model model;
    private final DatabaseDriver databaseDriver;
    private final ViewFactory viewFactory;


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

       // System.out.println("searchResult.get(0).ABC1Property() " + searchResult.get(0).ABC1Property());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchResult;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

}
