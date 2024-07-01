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
    public Spinner<Double> abc_spinner;
    public Spinner<Double> drb_spinner;
    public Spinner<Double> dq_spinner;
    public Spinner<Double> mica_spinner;
    private ObservableList<Candidate> candidates;
    public ListView<Candidate> candidate_listview;
//    HashMap<String,Integer> myMap.ObservableList=new HashMap<String,Integer>();
    ObservableList strMap;
    public Integer currentValue;
    public Double currentDoubValue;
    int selectionVal;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

                SpinnerValueFactory.DoubleSpinnerValueFactory valueFactory =
                new SpinnerValueFactory.DoubleSpinnerValueFactory(0.00, 100.00);
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

                //////////////////

                SpinnerValueFactory.DoubleSpinnerValueFactory valueFactory2 =
                        new SpinnerValueFactory.DoubleSpinnerValueFactory(0.00, 100.00);
                valueFactory2.setMin(0.0);
                valueFactory2.setMax(100.00);
                valueFactory2.setAmountToStepBy(33.332);
                valueFactory2.increment(1);
                abc_spinner.setValueFactory(valueFactory2);
                currentDoubValue = abc_spinner.getValue();
                abc_spinner.valueProperty().addListener(new ChangeListener<Double>() {
                    @Override
                    public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {
                        currentDoubValue = abc_spinner.getValue();
                        if (valueFactory2.getValue() == 100.0) {
                            valueFactory2.setAmountToStepBy(33.336);
                        }
                        if (valueFactory2.getValue() == 0.0) {
                            valueFactory2.setAmountToStepBy(33.332);
                        }
                    }
                });

                /////////////

                SpinnerValueFactory.DoubleSpinnerValueFactory valueFactory3 =
                        new SpinnerValueFactory.DoubleSpinnerValueFactory(0.00, 100.00);
                valueFactory3.setMin(0.0);
                valueFactory3.setMax(100.00);
                valueFactory3.setAmountToStepBy(33.332);
                valueFactory3.increment(1);
                drb_spinner.setValueFactory(valueFactory3);
                currentDoubValue = drb_spinner.getValue();
                drb_spinner.valueProperty().addListener(new ChangeListener<Double>() {
                    @Override
                    public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {
                        currentDoubValue = drb_spinner.getValue();
                        if (valueFactory3.getValue() == 100.0) {
                            valueFactory3.setAmountToStepBy(33.336);
                        }
                        if (valueFactory3.getValue() == 0.0) {
                            valueFactory3.setAmountToStepBy(33.332);
                        }
                    }
                });

                ///////////////

                SpinnerValueFactory.DoubleSpinnerValueFactory valueFactory4 =
                        new SpinnerValueFactory.DoubleSpinnerValueFactory(0.00, 100.00);
                valueFactory4.setMin(0.0);
                valueFactory4.setMax(100.00);
                valueFactory4.setAmountToStepBy(33.332);
                valueFactory4.increment(1);
                dq_spinner.setValueFactory(valueFactory4);
                currentDoubValue = dq_spinner.getValue();
                dq_spinner.valueProperty().addListener(new ChangeListener<Double>() {
                    @Override
                    public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {
                        currentDoubValue = dq_spinner.getValue();
                        if (valueFactory4.getValue() == 100.0) {
                            valueFactory4.setAmountToStepBy(33.336);
                        }
                        if (valueFactory4.getValue() == 0.0) {
                            valueFactory4.setAmountToStepBy(33.332);
                        }
                    }
                });

                ////////

                SpinnerValueFactory.DoubleSpinnerValueFactory valueFactory5 =
                        new SpinnerValueFactory.DoubleSpinnerValueFactory(0.00, 100.00);
                valueFactory5.setMin(0.0);
                valueFactory5.setMax(100.00);
                valueFactory5.setAmountToStepBy(33.332);
                valueFactory5.increment(1);
                mica_spinner.setValueFactory(valueFactory5);
                currentDoubValue = mica_spinner.getValue();
                mica_spinner.valueProperty().addListener(new ChangeListener<Double>() {
                    @Override
                    public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {
                        currentDoubValue = mica_spinner.getValue();
                        if (valueFactory5.getValue() == 100.0) {
                            valueFactory5.setAmountToStepBy(33.336);
                        }
                        if (valueFactory5.getValue() == 0.0) {
                            valueFactory5.setAmountToStepBy(33.332);
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
