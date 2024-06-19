package com.proj.organtransplantapp.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Candidate {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty gender;
    private final StringProperty weight;
    private final StringProperty email;

    public Candidate(String candFirstName, String candLastName, String candGender, String candWeight, String candEmail) {
        this.firstName = new SimpleStringProperty(this, "FirstName", candFirstName);
        this.lastName = new SimpleStringProperty(this, "LastName", candLastName);
        this.gender = new SimpleStringProperty(this, "Gender", candGender);
        this.weight = new SimpleStringProperty(this, "Weight", candWeight);
        this.email = new SimpleStringProperty(this, "Email", candEmail);
    }

    public  StringProperty firstNameProperty() {return firstName;}
    public String strFirstName() {return firstName.get();}
    public StringProperty lastNameProperty() {return lastName;}
    public String strLastName() {return  lastName.get();}
    public StringProperty genderProperty() {return gender;}
    public StringProperty weightProperty() {return weight;}
    public StringProperty emailProperty() {return email;}

}
