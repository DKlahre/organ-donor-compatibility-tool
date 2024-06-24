package com.proj.organtransplantapp.Controllers;

import com.proj.organtransplantapp.Models.Candidate;
import com.proj.organtransplantapp.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
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
    public Button confirmCandidate_btn;
    public final Candidate candidate;


    public CandidateCellController(Candidate candidate) {
        this.candidate = candidate;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        fName_lbl.textProperty().bind(candidate.firstNameProperty());
        lName_lbl.textProperty().bind(candidate.lastNameProperty());
        gender_lbl.textProperty().bind(candidate.genderProperty());
        age_lbl.textProperty().bind(candidate.ageProperty());
        weight_lbl.textProperty().bind(candidate.weightProperty());
        email_lbl.textProperty().bind(candidate.emailProperty());
        organ_lbl.textProperty().bind(candidate.organProperty());
        bloodType_lbl.textProperty().bind(candidate.bloodTypeProperty());
        DP1_lbl.textProperty().bind(candidate.DP1Property());
        DP2_lbl.textProperty().bind(candidate.DP2Property());
        DP3_lbl.textProperty().bind(candidate.DP3Property());
        ABC1_lbl.textProperty().bind(candidate.ABC1Property());
        ABC2_lbl.textProperty().bind(candidate.ABC2Property());
        ABC3_lbl.textProperty().bind(candidate.ABC3Property());
        DRB1_lbl.textProperty().bind(candidate.DRB1Property());
        DRB2_lbl.textProperty().bind(candidate.DRB2Property());
        DRB3_lbl.textProperty().bind(candidate.DRB3Property());
        DQ1_lbl.textProperty().bind(candidate.DQ1Property());
        DQ2_lbl.textProperty().bind(candidate.DQ2Property());
        DQ3_lbl.textProperty().bind(candidate.DQ3Property());
        MICA1_lbl.textProperty().bind(candidate.MICA1Property());
        MICA2_lbl.textProperty().bind(candidate.MICA2Property());
        MICA3_lbl.textProperty().bind(candidate.MICA3Property());
        confirmCandidate_btn.setOnAction(even -> confirmCandidate());
    }

    private void confirmCandidate() {
        String email = candidate.emailProperty().getValue();
        Model.getInstance().emailStore(email);

    }

}
