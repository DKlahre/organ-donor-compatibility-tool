package com.proj.organtransplantapp.Controllers;

import com.proj.organtransplantapp.Models.Candidate;
import com.proj.organtransplantapp.Models.Model;
import com.proj.organtransplantapp.Views.CandidateCellFactory;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchCandidateController implements Initializable {

    public Button emailSearch_btn;
    public ListView<Candidate> candidate_listview;
    public TextField email_fld;
    public Button findDonor_btn;
    public Button lastName_btn;
    public TextField lastName_fld;
    public Label email_error_message_lbl;
    public Label lname_error_message_lbl;
    public Label press_cand_select_btn_lbl;
    private Candidate candidate;
    private ObservableList<Candidate> candidates;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        lastName_btn.setOnAction(event -> onLastNameSearch());
        emailSearch_btn.setOnAction(event -> onEmailSearch());
        findDonor_btn.setOnAction(event -> onFindDonor());
    }

    private void onEmailSearch() {

            ObservableList<Candidate> searchResults = Model.getInstance().searchCandEmail(email_fld.getText());
            candidate_listview.setItems(searchResults);
            // candidate_listview.setMouseTransparent(true);
            candidate_listview.setFocusTraversable(false);
            candidate_listview.setCellFactory(e -> new CandidateCellFactory());
            candidates = searchResults;

            if (candidate_listview.getItems().isEmpty()) {
                email_error_message_lbl.setText("Email address not found");
                lname_error_message_lbl.setText("");
                lastName_fld.setText("");
                press_cand_select_btn_lbl.setText("");
            } else {
                lname_error_message_lbl.setText("");
                email_error_message_lbl.setText("");
                lastName_fld.setText("");
                press_cand_select_btn_lbl.setText("Press candidate selection button");
            }

        }

    private void onLastNameSearch() {

            ObservableList<Candidate> searchResults = Model.getInstance().searchCandLastName(lastName_fld.getText());
            candidate_listview.setItems(searchResults);
            // candidate_listview.setMouseTransparent(true);
            candidate_listview.setFocusTraversable(false);
            candidate_listview.setCellFactory(e -> new CandidateCellFactory());
            candidates = searchResults;

            if (candidate_listview.getItems().isEmpty()) {
                lname_error_message_lbl.setText("Last name not found");
                email_error_message_lbl.setText("");
                email_fld.setText("");
                press_cand_select_btn_lbl.setText("");
            } else {
                lname_error_message_lbl.setText("");
                email_error_message_lbl.setText("");
                email_fld.setText("");
                press_cand_select_btn_lbl.setText("Press candidate selection button");
            }
        }

        private void onFindDonor() {
            Stage stage = (Stage) emailSearch_btn.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showSearchDonorController();
            }

}
