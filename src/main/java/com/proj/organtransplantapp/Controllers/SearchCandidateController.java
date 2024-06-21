package com.proj.organtransplantapp.Controllers;

import com.proj.organtransplantapp.Models.Candidate;
import com.proj.organtransplantapp.Models.Model;
import com.proj.organtransplantapp.Views.CandidateCellFactory;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.util.ResourceBundle;

public class SearchCandidateController implements Initializable {

    public Button emailSearch_btn;
    public ListView<Candidate> candidate_listview;
    public TextField email_fld;
    private Candidate candidate;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        emailSearch_btn.setOnAction(event -> onEmailSearch());
    }

    private void onEmailSearch() {
        try {
            ObservableList<Candidate> searchResults = Model.getInstance().searchCandEmail(email_fld.getText());
            candidate_listview.setItems(searchResults);
            candidate_listview.setCellFactory(e -> new CandidateCellFactory());
            candidate = searchResults.get(0);
        } catch (Exception e) {
            System.out.println("Candidate not found");
        }
    }

}
