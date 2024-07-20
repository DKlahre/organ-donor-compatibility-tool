package com.proj.organtransplantapp.Controllers;

import com.proj.organtransplantapp.Models.Donor;
import com.proj.organtransplantapp.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class DonorOptionsCellController implements Initializable {

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

    public final Donor donor;

    public Button printpdf_btn;


    public DonorOptionsCellController(Donor donor) {
        this.donor = donor;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        fName_lbl.textProperty().bind(donor.firstNameProperty());
        lName_lbl.textProperty().bind(donor.lastNameProperty());
        gender_lbl.textProperty().bind(donor.genderProperty());
        age_lbl.textProperty().bind(donor.ageProperty());
        weight_lbl.textProperty().bind(donor.weightProperty());
        email_lbl.textProperty().bind(donor.emailProperty());
        organ_lbl.textProperty().bind(donor.organProperty());
        bloodType_lbl.textProperty().bind(donor.bloodTypeProperty());
        DP1_lbl.textProperty().bind(donor.DP1Property());
        DP2_lbl.textProperty().bind(donor.DP2Property());
        DP3_lbl.textProperty().bind(donor.DP3Property());
        ABC1_lbl.textProperty().bind(donor.ABC1Property());
        ABC2_lbl.textProperty().bind(donor.ABC2Property());
        ABC3_lbl.textProperty().bind(donor.ABC3Property());
        DRB1_lbl.textProperty().bind(donor.DRB1Property());
        DRB2_lbl.textProperty().bind(donor.DRB2Property());
        DRB3_lbl.textProperty().bind(donor.DRB3Property());
        DQ1_lbl.textProperty().bind(donor.DQ1Property());
        DQ2_lbl.textProperty().bind(donor.DQ2Property());
        DQ3_lbl.textProperty().bind(donor.DQ3Property());
        MICA1_lbl.textProperty().bind(donor.MICA1Property());
        MICA2_lbl.textProperty().bind(donor.MICA2Property());
        MICA3_lbl.textProperty().bind(donor.MICA3Property());
        printpdf_btn.setOnAction(event -> printPdf());
    }

    private void printPdf() {
        String email = donor.emailProperty().getValue();
        ResultSet resultSet = Model.getInstance().getDatabaseDriver().printDonorPdf(email);
    }

}