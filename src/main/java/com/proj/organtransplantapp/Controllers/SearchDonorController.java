package com.proj.organtransplantapp.Controllers;

import com.proj.organtransplantapp.Models.Candidate;
import com.proj.organtransplantapp.Models.Model;
import com.proj.organtransplantapp.Views.CandidateCellFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class SearchDonorController implements Initializable {
   // public ListView candidate_listview;
    public ListView donor_listview;
    public Spinner<Double> dp_spinner;
    public Spinner<Integer> abc_spinner;
    public Spinner<Integer> drb_spinner;
    public Spinner<Integer> dq_spinner;
    public Spinner<Integer> mica_spinner;
    private ObservableList<Candidate> candidates;
    public ListView<Candidate> candidate_listview;
//    HashMap<String,Integer> myMap.ObservableList=new HashMap<String,Integer>();
    ObservableList strMap;
    public Integer currentValue;
    public Double currentDoubValue;
    int selectionVal;

    private static final double MIN = 0;
    private static final double MAX = 1;
    private static final double INITIAL_VALUE = 0.5;
    private static final double STEP_INCREMENT = 0.1;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        myMap.put("Texas",1);
//        myMap.put("Florida", 2);
//        myMap.put("Maryland", 3);

       // strMap.set(myMap);

                SpinnerValueFactory.DoubleSpinnerValueFactory valueFactory =
                new SpinnerValueFactory.DoubleSpinnerValueFactory(0.00, 100.00);
               // valueFactory.setValue(33.33);
                valueFactory.setMin(0.0);
                valueFactory.setMax(100.00);
                valueFactory.setAmountToStepBy(33.332);
                valueFactory.increment(1);
                dp_spinner.setValueFactory(valueFactory);
                currentDoubValue = dp_spinner.getValue();

                dp_spinner.valueProperty().addListener(new ChangeListener<Double>() {
                    @Override
                    public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {
                        currentDoubValue = dp_spinner.getValue();
                        if (valueFactory.getValue() == 100.0) {
                            valueFactory.setAmountToStepBy(33.336);
                        }
                        if (valueFactory.getValue() == 0.0) {
                            valueFactory.setAmountToStepBy(33.332);
                        }
                    }
                });

//        SpinnerValueFactory<Integer> valueFactory =
//                new SpinnerValueFactory.IntegerSpinnerValueFactory(0,4);
//        valueFactory.setValue(1);
//        dp_spinner.setValueFactory(valueFactory);
//        currentValue = dp_spinner.getValue();
//
//        dp_spinner.valueProperty().addListener(new ChangeListener<Integer>() {
//            @Override
//            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
//                currentValue = dp_spinner.getValue();
//            }
//        });



        String email = Model.getInstance().getEmailStore();
        ObservableList<Candidate> searchResults = Model.getInstance().searchCandEmail(email);
        candidate_listview.setItems(searchResults);
        // candidate_listview.setMouseTransparent(true);
        candidate_listview.setFocusTraversable(false);
        candidate_listview.setCellFactory(e -> new CandidateCellFactory());
        candidates = searchResults;
    }

}
