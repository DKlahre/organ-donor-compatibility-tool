package com.proj.organtransplantapp.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {

    private AnchorPane searchCandidateView;

    public ViewFactory(){
    }

    public void showInitialWindow()  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Initial.fxml"));
         createStage(loader);
    }

    public void showSearchCandidateWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/SearchCandidate.fxml"));
        createStage(loader);
    }

    public void showSearchDonorController() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/SearchDonor.fxml"));
        createStage(loader);
    }

    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());

        } catch (Exception e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/snakeRod2.png"))));
        stage.show();
    }

    public AnchorPane getSearchCandidateView(){
        if (searchCandidateView == null) {
            try {
                searchCandidateView = new FXMLLoader(getClass().getResource("/Fxml/SearchCandidate.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return searchCandidateView;
    }

    public void closeStage (Stage stage) {
        stage.close();
    }

}
