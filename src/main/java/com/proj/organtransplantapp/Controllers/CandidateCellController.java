package com.proj.organtransplantapp.Controllers;

import com.proj.organtransplantapp.Models.Candidate;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CandidateCellController implements Initializable {

    public Label fName_lbl;
    public Label weight_lbl;
    public Label gender_lbl;
    public Label age_lbl;
    public Label lName_lbl;
    public Label email_lbl;
    public Label organ_lbl;
    public Label bloodType_lbl;
    public Label DP1_lbl;
    public Label ABC1_lbl;
    public Label DRB1_lbl;
    public Label DQ1_lbl;
    public Label MICA1_lbl;
    public Label DP2_lbl;
    public Label ABC2_lbl;
    public Label DRB2_lbl;
    public Label DQ2_lbl;
    public Label MICA2_lbl;
    public Label DP3_lbl;
    public Label ABC3_lbl;
    public Label DRB3_lbl;
    public Label DQ3_lbl;
    public Label MICA3_lbl;
    public final Candidate candidate;


    public CandidateCellController(Candidate candidate) {
        this.candidate = candidate;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        fName_lbl.textProperty().bind(candidate.firstNameProperty());
        weight_lbl.textProperty().bind(candidate.weightProperty());
        gender_lbl.textProperty().bind(candidate.genderProperty());
        age_lbl.textProperty().bind(candidate.ageProperty());
        lName_lbl.textProperty().bind(candidate.lastNameProperty());
        email_lbl.textProperty().bind(candidate.emailProperty());
        organ_lbl.textProperty().bind(candidate.organProperty());
        bloodType_lbl.textProperty().bind(candidate.bloodTypeProperty());
        DP1_lbl.textProperty().bind(candidate.DP1Property());
        ABC1_lbl.textProperty().bind(candidate.ABC1Property());
        DRB1_lbl.textProperty().bind(candidate.DRB1Property());
        DQ1_lbl.textProperty().bind(candidate.DQ1Property());
        MICA1_lbl.textProperty().bind(candidate.MICA1Property());
        DP2_lbl.textProperty().bind(candidate.DP2Property());
        ABC2_lbl.textProperty().bind(candidate.ABC2Property());
        DRB2_lbl.textProperty().bind(candidate.DRB2Property());
        DQ2_lbl.textProperty().bind(candidate.DQ2Property());
        MICA2_lbl.textProperty().bind(candidate.MICA2Property());
        DP3_lbl.textProperty().bind(candidate.DP3Property());
        ABC3_lbl.textProperty().bind(candidate.ABC3Property());
        DRB3_lbl.textProperty().bind(candidate.DRB3Property());
        DQ3_lbl.textProperty().bind(candidate.DQ3Property());
        MICA3_lbl.textProperty().bind(candidate.MICA3Property());
    }

}
