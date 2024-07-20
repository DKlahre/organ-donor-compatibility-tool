package com.proj.organtransplantapp.Views;

import com.proj.organtransplantapp.Controllers.CandidateCellController;
import com.proj.organtransplantapp.Models.Candidate;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class CandidateCellFactory  extends ListCell<Candidate> {

    @Override
    protected void updateItem(Candidate candidate, boolean empty) {
        super.updateItem(candidate, empty);

        if(empty) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/CandidateCell.fxml"));
            CandidateCellController controller = new CandidateCellController(candidate);
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
