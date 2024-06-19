package com.proj.organtransplantapp.Controllers;

import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.util.ResourceBundle;

public class SearchCandidateController implements Initializable {

    public Button emailSearch_btn;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        emailSearch_btn.setOnAction(event -> onEmailSearch());
    }

    private void onEmailSearch() {
        try {
            ObservableList

        } catch (Exception e) {

        }
    }

}
