package com.proj.organtransplantapp.Views;

import com.proj.organtransplantapp.Controllers.DonorOptionsCellController;
import com.proj.organtransplantapp.Models.Donor;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class DonorOptionsCellFactory  extends ListCell<Donor> {

    @Override
    protected void updateItem(Donor donor, boolean empty) {
        super.updateItem(donor, empty);

        if(empty) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/DonorOptionsCell.fxml"));
            DonorOptionsCellController controller = new DonorOptionsCellController(donor);
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