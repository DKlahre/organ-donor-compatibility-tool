package com.proj.organtransplantapp.Controllers;

import com.proj.organtransplantapp.Models.Candidate;
import com.proj.organtransplantapp.Models.Model;
import com.proj.organtransplantapp.Views.CandidateCellFactory;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchDonorController implements Initializable {
   // public ListView candidate_listview;
    public ListView donor_listview;
    private ObservableList<Candidate> candidates;
    public ListView<Candidate> candidate_listview;

//    public TextField email_fld;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String email = Model.getInstance().getEmailStore();
        ObservableList<Candidate> searchResults = Model.getInstance().searchCandEmail(email);
        candidate_listview.setItems(searchResults);
        // candidate_listview.setMouseTransparent(true);
        candidate_listview.setFocusTraversable(false);
        candidate_listview.setCellFactory(e -> new CandidateCellFactory());
        candidates = searchResults;
    }

}
