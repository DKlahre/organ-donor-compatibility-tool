package com.proj.organtransplantapp.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Candidate {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty gender;
    private final StringProperty weight;
    private final StringProperty email;
    private final StringProperty age;
    private final StringProperty organ;
    private final StringProperty bloodType;
    private final StringProperty DP1;
    private final StringProperty DP2;
    private final StringProperty DP3;
    private final StringProperty ABC1;
    private final StringProperty ABC2;
    private final StringProperty ABC3;
    private final StringProperty DRB1;
    private final StringProperty DRB2;
    private final StringProperty DRB3;
    private final StringProperty DQ1;
    private final StringProperty DQ2;
    private final StringProperty DQ3;
    private final StringProperty MICA1;
    private final StringProperty MICA2;
    private final StringProperty MICA3;


    public Candidate(String candFirstName, String candLastName, String candGender, String candAge, String candWeight, String candEmail, String candOrgan, String candBloodType,
                     String candDP1, String candDP2, String candDP3, String candABC1, String candABC2, String candABC3, String candDRB1, String candDRB2, String candDRB3,
                     String candDQ1, String candDQ2, String candDQ3, String candMICA1, String candMICA2, String candMICA3) {
        this.firstName = new SimpleStringProperty(this, "FirstName", candFirstName);
        this.lastName = new SimpleStringProperty(this, "LastName", candLastName);
        this.gender = new SimpleStringProperty(this, "Gender", candGender);
        this.age = new SimpleStringProperty(this, "Age", candAge);
        this.weight = new SimpleStringProperty(this, "Weight", candWeight);
        this.email = new SimpleStringProperty(this, "Email", candEmail);
        this.organ = new SimpleStringProperty(this, "Organ", candOrgan);
        this.bloodType = new SimpleStringProperty(this, "BloodType", candBloodType);
        this.DP1 = new SimpleStringProperty(this, "DP1", candDP1);
        this.DP2 = new SimpleStringProperty(this, "DP2", candDP2);
        this.DP3 = new SimpleStringProperty(this, "DP3", candDP3);

        this.ABC1 = new SimpleStringProperty(this, "ABC1", candABC1);
        this.ABC2 = new SimpleStringProperty(this, "ABC2", candABC2);
        this.ABC3 = new SimpleStringProperty(this, "ABC3", candABC3);

        this.DRB1 = new SimpleStringProperty(this, "DRB1", candDRB1);
        this.DRB2 = new SimpleStringProperty(this, "DRB2", candDRB2);
        this.DRB3 = new SimpleStringProperty(this, "BRB3", candDRB3);

        this.DQ1 = new SimpleStringProperty(this, "DQ1", candDQ1);
        this.DQ2 = new SimpleStringProperty(this, "DQ2", candDQ2);
        this.DQ3 = new SimpleStringProperty(this, "DQ3", candDQ3);

        this.MICA1 = new SimpleStringProperty(this, "MICA1", candMICA1);
        this.MICA2 = new SimpleStringProperty(this, "MICA2", candMICA2);
        this.MICA3 = new SimpleStringProperty(this, "MICA3", candMICA3);
    }

    public  StringProperty firstNameProperty() {return firstName;}
    public String strFirstName() {return firstName.get();}
    public StringProperty lastNameProperty() {return lastName;}
    public String strLastName() {return  lastName.get();}
    public StringProperty genderProperty() {return gender;}
    public StringProperty ageProperty() {return age;}
    public StringProperty weightProperty() {return weight;}
    public StringProperty emailProperty() {return email;}
    public StringProperty organProperty() {return organ;}
    public StringProperty bloodTypeProperty() {return bloodType;}
    public StringProperty DP1Property() {return DP1;}
    public StringProperty DP2Property() {return DP2;}
    public StringProperty DP3Property() {return DP3;}
    public StringProperty ABC1Property() {return ABC1;}
    public StringProperty ABC2Property() {return ABC2;}
    public StringProperty ABC3Property() {return ABC3;}
    public StringProperty DRB1Property() {return DRB1;}
    public StringProperty DRB2Property() {return DRB2;}
    public StringProperty DRB3Property() {return DRB3;}
    public StringProperty DQ1Property() {return DQ1;}
    public StringProperty DQ2Property() {return DQ2;}
    public StringProperty DQ3Property() {return DQ3;}
    public StringProperty MICA1Property() {return MICA1;}
    public StringProperty MICA2Property() {return MICA2;}
    public StringProperty MICA3Property() {return MICA3;}

}
