package com.proj.organtransplantapp.Controllers;

import com.proj.organtransplantapp.Models.Candidate;
import com.proj.organtransplantapp.Models.Model;
import com.proj.organtransplantapp.Views.CandidateCellFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchCandidateController implements Initializable {

    public Button emailSearch_btn;
    public ListView<Candidate> candidate_listview;
    public TextField email_fld;
    public Button findDonor_btn;
    private Candidate candidate;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        emailSearch_btn.setOnAction(event -> onEmailSearch());
        findDonor_btn.setOnAction(event -> onFindDonor());
    }

    private void onEmailSearch() {
        ObservableList<Candidate> searchResults = Model.getInstance().searchCandEmail(email_fld.getText());
         candidate_listview.setItems(searchResults);
         ////////
        // candidate_listview.setMouseTransparent(true);
        candidate_listview.setFocusTraversable(false);
        candidate_listview.setCellFactory(e -> new CandidateCellFactory());

       // candidate_listview.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> mouseEvent.consume());


         /////////

         candidate = searchResults.get(0);
    }




    private void onFindDonor() {
        Stage stage = (Stage) emailSearch_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showInitialWindow();
    }

}
