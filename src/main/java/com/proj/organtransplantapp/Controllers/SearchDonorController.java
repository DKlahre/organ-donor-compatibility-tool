package com.proj.organtransplantapp.Controllers;

import com.proj.organtransplantapp.Models.Candidate;
import com.proj.organtransplantapp.Models.Donor;
import com.proj.organtransplantapp.Models.Model;
import com.proj.organtransplantapp.Views.CandidateCellFactory;
import com.proj.organtransplantapp.Views.CandidatePickedCellFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.SQLException;
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
    public Spinner<Integer> micaapr_spinner;
    public Spinner<Integer> dqapr_spinner;
    public Spinner<Integer> drbapr_spinner;
    public Spinner<Integer> abcapr_spinner;
    public Spinner<Integer> dpapr_spinner;
    public ChoiceBox organ_cb;
    public ChoiceBox bloodType_cb;
    public Button processSearch_btn;
    private ObservableList<Candidate> candidates;
    public ListView<Candidate> candidate_listview;
//    HashMap<String,Integer> myMap.ObservableList=new HashMap<String,Integer>();
    ObservableList strMap;
    public Integer currentValue;
    public Double currentDoubValue;
    private String[] bloodTypeArray = {"A", "AB", "B", "O"};
    private String[] organArray = {"Pancreas", "Lung", "Heart", "Kidney", "Liver"};
    int selectionVal;
    String organ;
    String bloodType;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        String email = Model.getInstance().getEmailStore();
        ObservableList<Candidate> searchResults = Model.getInstance().searchCandEmail(email);
        candidate_listview.setItems(searchResults);
        // candidate_listview.setMouseTransparent(true);
        candidate_listview.setFocusTraversable(false);
        candidate_listview.setCellFactory(e -> new CandidatePickedCellFactory());
        candidates = searchResults;

                ////////// Eplet1 spinner
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

                /////// Eplet2 spinner
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

                //////// Eplet3 spinner

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

                //////// Eplet4 spinner

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

                ////////// Eplet5 spinner

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

                ////////// DPAPR spinner
                SpinnerValueFactory<Integer> valFactory1 =
                        new SpinnerValueFactory.IntegerSpinnerValueFactory(0,3);
                valFactory1.setValue(1);
                dpapr_spinner.setValueFactory(valFactory1);
                currentValue = dpapr_spinner.getValue();
                dpapr_spinner.valueProperty().addListener(new ChangeListener<Integer>() {
                    @Override
                    public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                        currentValue = dpapr_spinner.getValue();
                    }
                });

                ////////// ABCAPR spinner
                SpinnerValueFactory<Integer> valFactory2 =
                        new SpinnerValueFactory.IntegerSpinnerValueFactory(0,3);
                valFactory2.setValue(1);
                abcapr_spinner.setValueFactory(valFactory2);
                currentValue = abcapr_spinner.getValue();
                abcapr_spinner.valueProperty().addListener(new ChangeListener<Integer>() {
                    @Override
                    public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                        currentValue = abcapr_spinner.getValue();
                    }
                });

                ////////// DRBAPR spinner
                SpinnerValueFactory<Integer> valFactory3 =
                        new SpinnerValueFactory.IntegerSpinnerValueFactory(0,3);
                valFactory3.setValue(1);
                drbapr_spinner.setValueFactory(valFactory3);
                currentValue = drbapr_spinner.getValue();

                drbapr_spinner.valueProperty().addListener(new ChangeListener<Integer>() {
                    @Override
                    public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                        currentValue = drbapr_spinner.getValue();
                    }
                });

                ////////// DQAPR spinner
                SpinnerValueFactory<Integer> valFactory4 =
                        new SpinnerValueFactory.IntegerSpinnerValueFactory(0,3);
                valFactory4.setValue(1);
                dqapr_spinner.setValueFactory(valFactory4);
                currentValue = dqapr_spinner.getValue();
                dqapr_spinner.valueProperty().addListener(new ChangeListener<Integer>() {
                    @Override
                    public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                        currentValue = dqapr_spinner.getValue();
                    }
                });

                ////////// MICAAPR spinner
                SpinnerValueFactory<Integer> valFactory5 =
                        new SpinnerValueFactory.IntegerSpinnerValueFactory(0,3);
                valFactory5.setValue(1);
                micaapr_spinner.setValueFactory(valFactory5);
                currentValue = micaapr_spinner.getValue();
               // micaapr_spinner.setOnTouchReleased(this::setMicaApr);
                micaapr_spinner.valueProperty().addListener(new ChangeListener<Integer>() {
                    @Override
                    public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                        currentValue = micaapr_spinner.getValue();
                    }
                });

                organ_cb.getItems().addAll(organArray);
                organ_cb.setOnAction(this::getOrgan);

                bloodType_cb.getItems().addAll(bloodTypeArray);
                bloodType_cb.setOnAction(this::getBloodType);

                processSearch_btn.setOnAction(this::processSearch);
    }

    private void getOrgan(Event event) {
       organ = (String) organ_cb.getValue();
       System.out.println("organ: " + organ);
    }

    private void getBloodType(Event event) {
        bloodType = (String) bloodType_cb.getValue();
        System.out.println("bloodType: " + bloodType);
    }

//    private void setMicaApr(Event event) {
//        String strMicaApr = String.valueOf(micaapr_spinner.getValue());
//    }


    private void processSearch(Event event)  {

        String strMicaApr = String.valueOf(micaapr_spinner.getValue());
        String strDqApr = String.valueOf(dqapr_spinner.getValue());
        String strDrbApr = String.valueOf(drbapr_spinner.getValue());
        String strAbcApr = String.valueOf(abcapr_spinner.getValue());
        String strDpApr = String.valueOf(dpapr_spinner.getValue());

        ObservableList<Donor> searchResults = Model.getInstance().searchDonors(organ, bloodType, strMicaApr, strDqApr, strDrbApr, strAbcApr, strDpApr);

        System.out.println("process button pressed");
    }


}
