package com.proj.organtransplantapp.Controllers;

import com.proj.organtransplantapp.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class InitialController implements Initializable {
    public Button initial_entry_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Model.getInstance().getViewFactory().showInitialWindow();
        initial_entry_btn.setOnAction(event -> onInitial());
    }

    private void onInitial() {
      //  Stage stage = (Stage) initial_entry_btn.getScene().getWindow();
       // Model.getInstance().getViewFactory().showCandidateWindow();
        System.out.println("Hey");
    }
}
