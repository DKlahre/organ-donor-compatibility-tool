package com.proj.organtransplantapp.Controllers;

import com.proj.organtransplantapp.Models.Candidate;
import com.proj.organtransplantapp.Models.Model;
import com.proj.organtransplantapp.Views.CandidateCellFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.io.IOException;
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

        ObservableList<Candidate> searchResults = Model.getInstance().searchCandEmail(email_fld.getText());
//           System.out.println("searchResults: FirstName " + searchResults.get(0).firstNameProperty() );
//            System.out.println("searchResults: LastName " + searchResults.get(0).lastNameProperty() );
//            System.out.println("searchResults: Gender " + searchResults.get(0).genderProperty() );
//            System.out.println("searchResults: Age " + searchResults.get(0).ageProperty() );
//            System.out.println("searchResults: Weight " + searchResults.get(0).weightProperty() );
//            System.out.println("searchResults: Email " + searchResults.get(0).emailProperty() );
//            System.out.println("searchResults: Organ " + searchResults.get(0).organProperty() );
//            System.out.println("searchResults: BloodType " + searchResults.get(0).bloodTypeProperty() );
//            System.out.println("searchResults: DP1 " + searchResults.get(0).DP1Property() );
//            System.out.println("searchResults: DP2 " + searchResults.get(0).DP2Property() );
//            System.out.println("searchResults: DP3 " + searchResults.get(0).DP3Property() );
//            System.out.println("searchResults: ABC1 " + searchResults.get(0).ABC1Property() );
//            System.out.println("searchResults: ABC2 " + searchResults.get(0).ABC2Property() );
//            System.out.println("searchResults: ABC3 " + searchResults.get(0).ABC3Property() );
//            System.out.println("searchResults: DRB1 " + searchResults.get(0).DRB1Property() );
//            System.out.println("searchResults: DRB2 " + searchResults.get(0).DRB2Property() );
//            System.out.println("searchResults: DRB3 " + searchResults.get(0).DRB3Property() );
//            System.out.println("searchResults: DQ1 " + searchResults.get(0).DQ1Property() );
//            System.out.println("searchResults: DQ2 " + searchResults.get(0).DQ2Property() );
//            System.out.println("searchResults: DQ3 " + searchResults.get(0).DQ3Property() );
//            System.out.println("searchResults: MICA1 " + searchResults.get(0).MICA1Property() );
//            System.out.println("searchResults: MICA2 " + searchResults.get(0).MICA2Property() );
//            System.out.println("searchResults: MICA3 " + searchResults.get(0).MICA3Property() );


         candidate_listview.setItems(searchResults);

         candidate_listview.setCellFactory(e -> new CandidateCellFactory());
//           candidate = searchResults.get(0);

//       ListView<Candidate> processingListView = new ListView<>(searchResults);
//        processingListView.setCellFactory(e -> new CandidateCellFactory());
//        ListView<Candidate> candidate_listview = new ListView<>(searchResults);
//        candidate_listview.setCellFactory(e -> new CandidateCellFactory());
        candidate = searchResults.get(0);
    }

}
