package com.proj.organtransplantapp.Views;

import com.proj.organtransplantapp.Controllers.CandidateCellController;
import com.proj.organtransplantapp.Controllers.CandidatePickedCellController;
import com.proj.organtransplantapp.Models.Candidate;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class CandidatePickedCellFactory  extends ListCell<Candidate> {

    @Override
    protected void updateItem(Candidate candidate, boolean empty) {
        super.updateItem(candidate, empty);
        if(empty) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/CandidatePickedCell.fxml"));
            CandidatePickedCellController controller = new CandidatePickedCellController(candidate);
            loader.setController(controller);
            setText(null);
            try {
                setGraphic(loader.load());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}